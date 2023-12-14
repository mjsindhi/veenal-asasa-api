package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import static com.hemsw.asasaapi.veenal.dao.gen.VoucherDao.tableName;
import com.hemsw.asasaapi.veenal.dto.hdto.ProdForEstimateHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.ProductLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao
{

	@Autowired
	private EntityManager session;

	public void create(ProductModel productModel)
	{
		session.persist(productModel);
	}

	public ProductModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.PRODUCT, String.valueOf(id));
		List<ProductModel> dtos = session.createNativeQuery(sql, ProductModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_product} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_product", "product");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isCodeExists(String code)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_product} WHERE code = '%s'", SqlHelper.escape(code));
		Map<String, String> map = new HashMap<>();
		map.put("table_product", "product");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<ProductLdto> getLdtos(
			String name,
			Integer unitId,
			Boolean withCategory,
			Integer categoryId,
			Boolean searchInSubCat,
			String categoryName,
			Integer taxCategoryId,
			Boolean isMfg
	)
	{
		String sql = "SELECT\n"
				+ "	{table_product}.id,\n"
				+ "	{table_product}.name,\n"
				+ "	{table_product}.code,\n"
				+ "	{table_product}.desc,\n"
				+ "	{table_unit}.id unit_id,\n"
				+ "	{table_unit}.name unit_name,\n"
				+ "	(CASE WHEN {table_product}.tax_cat_id IS NULL THEN {table_product}.hsn ELSE {table_tax_cat}.hsn END) hsn,\n"
				+ "	{table_product}.raw_purchase_price,\n"
				+ "	{table_product}.polish_price,\n"
				+ "	{table_product}.cost_price,\n"
				+ "	{table_product}.additional_cost,\n"
				+ "	{table_product}.min_sales_price,\n"
				+ "	{table_product}.wholesale_sales_price,\n"
				+ "	{table_product}.mrp,\n"
				+ "	{table_product}.internet_sales_price,\n"
				+ "	{table_product}.max_sales_price,\n"
				+ "	{table_product}.discount,\n"
				+ "	{table_category}.id product_category_id,\n"
				+ "	{table_category}.name product_category_name,\n"
				+ "	{table_tax_cat}.id tax_cat_id,\n"
				+ "	{table_tax_cat}.name tax_category_name,\n"
				+ "	(CASE WHEN {table_product}.tax_cat_id IS NULL THEN tbl_tax_2.id ELSE {table_tax}.id END) tax_id,\n"
				+ "	(CASE WHEN {table_product}.tax_cat_id IS NULL THEN tbl_tax_2.name ELSE {table_tax}.name END) tax_name,\n"
				+ "	{table_product}.note,\n"
				+ "	{table_product}.is_sold,\n"
				+ "	{table_product}.is_made,\n"
				+ "	{table_product}.min_qty,\n"
				+ "	{table_product}.reorder_qty,\n"
				+ "	t_acct_raw_supplier.id raw_supplier_id,\n"
				+ "	t_acct_raw_supplier.name raw_supplier_name,\n"
				+ "	t_acct_polished_by_supplier.id polished_by_supplier_id,\n"
				+ "	t_acct_polished_by_supplier.name polished_by_supplier_name,\n"
				+ "	{table_product}.weight,\n"
				+ "	{table_user}.id created_by_user_id,\n"
				+ "	{table_user}.name created_by_user_name,\n"
				+ "	{table_product}.created_at\n"
				+ "FROM	\n"
				+ "	{table_product}\n"
				+ "LEFT JOIN\n"
				+ "	{table_unit}\n"
				+ "ON\n"
				+ "	{table_product}.`unit_id` = {table_unit}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_category}\n"
				+ "ON\n"
				+ "	{table_product}.`category_id` = {table_category}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax_cat}\n"
				+ "ON\n"
				+ "	{table_product}.`tax_cat_id` = {table_tax_cat}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax}\n"
				+ "ON\n"
				+ "	{table_tax_cat}.`tax_id` = {table_tax}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_acct} t_acct_raw_supplier\n"
				+ "ON\n"
				+ "	{table_product}.`raw_supplier_id` = t_acct_raw_supplier.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_acct} t_acct_polished_by_supplier\n"
				+ "ON\n"
				+ "	{table_product}.`polished_by_supplier_id` = t_acct_polished_by_supplier.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax} as tbl_tax_2\n"
				+ "ON\n"
				+ "	{table_product}.`tax_id` = tbl_tax_2.id"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_product}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();
		if (name != null && !name.isEmpty())
		{
			wheres.add("{table_product}.name LIKE '%" + name + "%'");
		}
		if (unitId != null)
		{
			wheres.add("{table_product}.unit_id = " + unitId + "");
		}
		if (withCategory != null)
		{
			wheres.add(String.format("%s IS %s", "{table_product}.category_id", withCategory ? "NOT NULL" : "NULL"));
		}
		if (categoryId != null)
		{
			if (searchInSubCat != null && searchInSubCat)
			{
				wheres.add(String.format("%s IN ( \n"
						+ "	WITH RECURSIVE \n"
						+ "	  types(x) AS ( \n"
						+ "		 SELECT %s \n"
						+ "		 UNION ALL \n"
						+ "		 SELECT id FROM {table_category}, types where parent_id in (types.x) \n"
						+ "	  ) \n"
						+ "	SELECT * FROM types \n"
						+ ") \n",
						"{table_product}.category_id",
						categoryId));
			}
			else
			{
				wheres.add(String.format("%s = %s", "{table_product}.category_id", categoryId));
			}
		}
		if (categoryName != null && !categoryName.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "{table_category}.name", categoryName));
		}
		if (taxCategoryId != null)
		{
			wheres.add("{table_product}.tax_cat_id = " + taxCategoryId + "");
		}
		if (isMfg != null)
		{
			wheres.add("{table_product}.is_made = " + (isMfg ? "1" : "0") + " ");
		}
		sql = SqlHelper.putWheres(wheres, sql);
		sql = sql + " ORDER BY {table_product}.name ASC";

		Map<String, String> map = new HashMap<>();
		map.put("table_product", TableName.PRODUCT);
		map.put("table_unit", TableName.UNIT);
		map.put("table_category", TableName.PRODUCT_CAT);
		map.put("table_tax_cat", TableName.TAX_CAT);
		map.put("table_tax", TableName.TAX);
		map.put("table_acct", TableName.ACCT);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		List<ProductLdto> productLdtos = session
				.createNativeQuery(sql, ProductLdto.class)
				.getResultList();

		return productLdtos;

	}

	public List<ProdForEstimateHdto> getProdListForEstimateHdtos()
	{
		String sql = "SELECT\n"
				+ "	{table_product}.id,\n"
				+ "	{table_product}.name,\n"
				+ "	{table_product}.code,\n"
				+ "	{table_product}.desc,\n"
				+ "	{table_unit}.id unit_id,\n"
				+ "	{table_unit}.name unit_name,\n"
				+ "	(CASE WHEN {table_product}.tax_cat_id IS NULL THEN {table_product}.hsn ELSE {table_tax_cat}.hsn END) hsn,\n"
				+ "	{table_product}.raw_purchase_price,\n"
				+ "	{table_product}.polish_price,\n"
				+ "	{table_product}.cost_price,\n"
				+ "	{table_product}.additional_cost,\n"
				+ "	{table_product}.min_sales_price,\n"
				+ "	{table_product}.wholesale_sales_price,\n"
				+ "	{table_product}.mrp,\n"
				+ "	{table_product}.internet_sales_price,\n"
				+ "	{table_product}.max_sales_price,\n"
				+ "	{table_product}.discount,\n"
				+ "	{table_category}.id product_category_id,\n"
				+ "	{table_category}.name product_category_name,\n"
				+ "	{table_tax_cat}.id tax_cat_id,\n"
				+ "	{table_tax_cat}.name tax_category_name,\n"
				+ "	(CASE WHEN {table_product}.tax_cat_id IS NULL THEN tbl_tax_2.id ELSE {table_tax}.id END) tax_id,\n"
				+ "	(CASE WHEN {table_product}.tax_cat_id IS NULL THEN tbl_tax_2.name ELSE {table_tax}.name END) tax_name,\n"
				+ "	{table_product}.note,\n"
				+ "	{table_product}.is_sold,\n"
				+ "	{table_product}.is_made,\n"
				+ "	{table_product}.min_qty,\n"
				+ "	{table_product}.reorder_qty,\n"
				+ "	t_acct_raw_supplier.id raw_supplier_id,\n"
				+ "	t_acct_raw_supplier.name raw_supplier_name,\n"
				+ "	t_acct_polished_by_supplier.id polished_by_supplier_id,\n"
				+ "	t_acct_polished_by_supplier.name polished_by_supplier_name,\n"
				+ "	{table_product}.weight,\n"
				+ "	{table_user}.id created_by_user_id,\n"
				+ "	{table_user}.name created_by_user_name,\n"
				+ "	{table_product}.created_at,\n"
				+ "	IFNULL(t_current_stock.current_stock_qty, 0) qty_current,\n"
				+ "	IFNULL(pending_qty_sales, 0) pending_qty_sales,\n"
				+ "	IFNULL(t_pending_qty_estimate.pending_qty_estimate, 0) pending_qty_estimate\n"
				+ "FROM	\n"
				+ "	{table_product}\n"
				+ "LEFT JOIN\n"
				+ "	{table_unit}\n"
				+ "ON\n"
				+ "	{table_product}.`unit_id` = {table_unit}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_category}\n"
				+ "ON\n"
				+ "	{table_product}.`category_id` = {table_category}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax_cat}\n"
				+ "ON\n"
				+ "	{table_product}.`tax_cat_id` = {table_tax_cat}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax}\n"
				+ "ON\n"
				+ "	{table_tax_cat}.`tax_id` = {table_tax}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax} as tbl_tax_2\n"
				+ "ON\n"
				+ "	{table_product}.`tax_id` = tbl_tax_2.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_acct} t_acct_raw_supplier\n"
				+ "ON\n"
				+ "	{table_product}.`raw_supplier_id` = t_acct_raw_supplier.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_acct} t_acct_polished_by_supplier\n"
				+ "ON\n"
				+ "	{table_product}.`polished_by_supplier_id` = t_acct_polished_by_supplier.id\n"
				+ "LEFT JOIN\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			IFNULL(SUM(tx_type * qty), 0) current_stock_qty\n"
				+ "		FROM	\n"
				+ "			goods_journal\n"
				+ "		WHERE\n"
				+ "			date(date) <= date('{date_to}')\n"
				+ "		GROUP BY\n"
				+ "			product_id\n"
				+ "	) t_current_stock\n"
				+ "ON\n"
				+ "	t_current_stock.product_id = product.id\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		product_id,\n"
				+ "		SUM((order_journal.order_qty - IFNULL(t_order_set_qty.set_qty, 0))) pending_qty_sales\n"
				+ "	FROM\n"
				+ "		order_journal\n"
				+ "	LEFT JOIN\n"
				+ "		(\n"
				+ "			SELECT\n"
				+ "				order_journal_id_order,\n"
				+ "				IFNULL(SUM(QTY),0) set_qty\n"
				+ "			FROM\n"
				+ "				order_set_against\n"
				+ "			GROUP BY\n"
				+ "				order_journal_id_order\n"
				+ "		) t_order_set_qty\n"
				+ "	ON\n"
				+ "		t_order_set_qty.order_journal_id_order = order_journal.id	\n"
				+ "	WHERE\n"
				+ "		order_type_id = 2\n"
				+ "	AND\n"
				+ "		order_qty IS NOT NULL\n"
				+ "	AND\n"
				+ "		order_journal.order_qty > IFNULL(t_order_set_qty.set_qty, 0)\n"
				+ "	AND\n"
				+ "		date(order_journal.date) <= date('{date_to}')\n"
				+ "	GROUP BY \n"
				+ "		product_id\n"
				+ ") t_pending_qty_sales\n"
				+ "ON\n"
				+ "	t_pending_qty_sales.product_id = product.id\n"
				+ "LEFT JOIN\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		IFNULL(SUM(qty),0) pending_qty_estimate,\n"
				+ "		product_id\n"
				+ "	FROM\n"
				+ "		estimate_item\n"
				+ "	LEFT JOIN\n"
				+ "		estimate\n"
				+ "	ON\n"
				+ "		estimate.id = estimate_item.estimate_id\n"
				+ "	LEFT JOIN\n"
				+ "		voucher\n"
				+ "	ON\n"
				+ "		voucher.id = estimate_item.estimate_id\n"
				+ "	WHERE\n"
				+ "		estimate.status_id = 2\n"
				+ "	AND\n"
				+ "		estimate.lock_stock_for_days IS NOT NULL\n"
				+ "	AND\n"
				+ "		NOW() <= DATE_ADD(voucher.date, INTERVAL estimate.lock_stock_for_days DAY)\n"
				+ "	GROUP BY \n"
				+ "		product_id\n"
				+ ") t_pending_qty_estimate\n"
				+ "ON\n"
				+ "	t_pending_qty_estimate.product_id = product.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_product}.created_by_user_id\n";
		sql = String.format(sql, tableName);

		sql = sql + " ORDER BY {table_product}.name ASC";

		Map<String, String> map = new HashMap<>();

		map.put("table_product", TableName.PRODUCT);
		map.put("table_unit", TableName.UNIT);
		map.put("table_category", TableName.PRODUCT_CAT);
		map.put("table_tax_cat", TableName.TAX_CAT);
		map.put("table_tax", TableName.TAX);
		map.put("table_acct", TableName.ACCT);
		map.put("table_user", TableName.USER);

		map.put("date_to", "9999-12-31");

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, ProdForEstimateHdto.class).getResultList();
	}

	public List<ProductModel> get(String name, Boolean isHosiery, Boolean isMfg, Boolean isService, List<Integer> ids)
	{
		String sql = String.format(DaoHelper.SELECT_SQL, TableName.PRODUCT);

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(TableName.PRODUCT + ".name LIKE '%" + name + "%'");
		}

		if (isHosiery != null)
		{
			wheres.add(TableName.PRODUCT + ".is_hosiery = " + (isHosiery ? "1" : "0") + " ");
		}

		if (isMfg != null)
		{
			wheres.add(TableName.PRODUCT + ".is_made = " + (isMfg ? "1" : "0") + " ");
		}

		if (isService != null)
		{
			wheres.add(TableName.PRODUCT + ".is_service = " + (isService ? "1" : "0") + " ");
		}

		if (ids != null && !ids.isEmpty())
		{
			wheres.add(String.format("%s.id IN (%s)", TableName.PRODUCT, Util.getCSVFromInt(ids)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY name asc";

		return session.createNativeQuery(sql, ProductModel.class).getResultList();
	}

}
