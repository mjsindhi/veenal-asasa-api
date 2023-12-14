package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.hdto.CurrentStockDetHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.ProductCategoryLdto;
import com.hemsw.asasaapi.veenal.enums.ListMenu;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductCatModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	public static final String tableName = "product_category";

	public void create(ProductCatModel productCategoryModel)
	{
		session.persist(productCategoryModel);
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_product_cat} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_product_cat", TableName.PRODUCT_CAT);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_product_cat} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_product_cat", TableName.PRODUCT_CAT);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();
	}

	public List<ProductCategoryLdto> getLdtos(String name, Boolean withParent, Integer parentId, Boolean searchInSubCat, String parentCatName)
	{
		String sql = "SELECT\n"
				+ "	{table_product_category}.id,\n"
				+ "	{table_product_category}.name,\n"
				+ "	{table_product_category}.note,\n"
				+ "	t_pc_parent.name parent_name,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_product_category}.created_at\n"
				+ "FROM	\n"
				+ "	{table_product_category}\n"
				+ "LEFT JOIN\n"
				+ "	{table_product_category} t_pc_parent\n"
				+ "ON\n"
				+ "	{table_product_category}.`parent_id` = t_pc_parent.id"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_product_category}.created_by_user_id\n";
		sql = String.format(sql, tableName);

		List<String> conditions = new ArrayList<>();
		if (name != null && !name.isEmpty())
		{
			conditions.add(String.format("%s LIKE '%%%s%%'", "{table_product_category}.name", name));
		}
		if (withParent != null)
		{
			conditions.add(String.format("%s IS %s", "{table_product_category}.parent_id", withParent ? "NOT NULL" : "NULL"));
		}
		if (parentId != null)
		{
			if (searchInSubCat != null && searchInSubCat)
			{
				conditions.add(String.format("%s IN ( \n"
						+ "	WITH RECURSIVE \n"
						+ "	  types(x) AS ( \n"
						+ "		 SELECT %s \n"
						+ "		 UNION ALL \n"
						+ "		 SELECT id FROM {table_product_category}, types where parent_id in (types.x) \n"
						+ "	  ) \n"
						+ "	SELECT * FROM types \n"
						+ ") \n",
						"{table_product_category}.parent_id",
						parentId));
			}
			else
			{
				conditions.add(String.format("%s = %s", "{table_product_category}.parent_id", parentId));
			}
		}
		if (parentCatName != null)
		{
			conditions.add(String.format("%s LIKE '%%%s%%'", "t_pc_parent.name", parentCatName));
		}
		sql = SqlHelper.putWheres(conditions, sql);
		sql = sql + " ORDER BY name ASC";

		Map<String, String> map = new HashMap<>();
		map.put("table_product_category", tableName);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, ProductCategoryLdto.class).getResultList();
	}

	public ProductCatModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<ProductCatModel> dtos = session.createNativeQuery(sql, ProductCatModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<String> getNames()
	{
		String sql = String.format("SELECT name FROM %s", tableName);
		return session.createNativeQuery(sql, String.class).getResultList();
	}

	public List<CurrentStockDetHdto> getCurrentStockByCat(
			Integer catId,
			Date dateTo,
			Boolean lowStock)
	{

		String sql = "WITH RECURSIVE cte_cat (root_id, parent_id, child_id) AS (\n"
				+ "	SELECT     \n"
				+ "		id,\n"
				+ "		parent_id,\n"
				+ "		id\n"
				+ "	FROM\n"
				+ "		product_category l1_pc\n"
				+ "	WHERE\n";

		if (catId == null)
		{
			sql = sql + String.format("parent_id is null", catId);
		}
		else
		{
			sql = sql + String.format("parent_id = %s", catId);
		}

		sql = sql + "\n	UNION ALL\n"
				+ "\n"
				+ "	SELECT\n"
				+ "		cte_cat.root_id,\n"
				+ "		cte_cat.child_id,\n"
				+ "		l2_pc.id\n"
				+ "	FROM\n"
				+ "		product_category l2_pc\n"
				+ "	INNER JOIN \n"
				+ "		cte_cat\n"
				+ "	ON \n"
				+ "		l2_pc.parent_id = cte_cat.child_id\n"
				+ "\n"
				+ ")\n"
				+ "SELECT\n"
				+ "	root_id id,\n"
				+ "	product_category.name name,\n"
				+ "	SUM(qty) qty,\n"
				+ "	IF(SUM(qty) = 0, 0, SUM(amt) / SUM(qty)) rate,\n"
				+ "	SUM(amt) amt,\n"
				+ "	SUM(pending_qty_purchase) pending_qty_purchase,\n"
				+ "	SUM(pending_qty_sales) pending_qty_sales,\n"
				+ "	SUM(final_qty) final_qty,\n"
				+ "	NULL min_qty_days,\n"
				+ "	NULL avg_daily_sales,\n"
				+ "	NULL reorder_level,\n"
				+ "	SUM(shortfall) shortfall,\n"
				+ "	NULL reorder_qty_days,\n"
				+ "	NULL min_reorder_qty,\n"
				+ "	NULL reorder_qty,\n"
				+ "	NULL suppliers\n"
				+ "FROM\n"
				+ "(\n"
				+ "	SELECT\n"
				+ "		product.id,\n"
				+ "		product.category_id,\n"
				+ "		IFNULL(t_current_stock.current_stock_qty, 0) qty,\n"
				+ "		IFNULL(t_rate.rate, 0) rate,\n"
				+ "		IFNULL(t_current_stock.current_stock_qty, 0) * IFNULL(t_rate.rate, 0) amt,\n"
				+ "		IFNULL(pending_qty_purchase, 0) pending_qty_purchase,\n"
				+ "		IFNULL(pending_qty_sales, 0) pending_qty_sales,\n"
				+ "		IFNULL(t_current_stock.current_stock_qty, 0)\n"
				+ "		+ IFNULL(pending_qty_purchase, 0)\n"
				+ "		/*- IFNULL(pending_qty_sales, 0)*/ final_qty,\n"
				+ "		product.min_qty_days,\n"
				+ "		t_avg_daily_sales.avg_daily_sales,\n"
				+ "		IF(\n"
				+ "			product.min_qty_days IS NULL OR \n"
				+ "			t_avg_daily_sales.avg_daily_sales IS NULL, \n"
				+ "			NULL, \n"
				+ "			product.min_qty_days * t_avg_daily_sales.avg_daily_sales\n"
				+ "		) reorder_level,\n"
				+ "		IF(\n"
				+ "			(SELECT final_qty) IS NULL OR \n"
				+ "			(SELECT reorder_level) IS NULL OR\n"
				+ "			(SELECT final_qty) > (SELECT reorder_level), \n"
				+ "			NULL,\n"
				+ "			(SELECT reorder_level) - (SELECT final_qty)\n"
				+ "		) shortfall,\n"
				+ "		product.reorder_qty_days,\n"
				+ "		IF(\n"
				+ "			(SELECT shortfall) IS NULL OR\n"
				+ "			t_avg_daily_sales.avg_daily_sales IS NULL OR\n"
				+ "			product.reorder_qty_days IS NULL, \n"
				+ "			NULL, \n"
				+ "			t_avg_daily_sales.avg_daily_sales * product.reorder_qty_days\n"
				+ "		) min_reorder_qty\n"
				+ "	FROM\n"
				+ "		product\n"
				+ "	LEFT JOIN\n"
				+ "		(\n"
				+ "			SELECT\n"
				+ "				product_id,\n"
				+ "				IFNULL(SUM(tx_type * qty), 0) current_stock_qty\n"
				+ "			FROM	\n"
				+ "				goods_journal\n"
				+ "			WHERE\n"
				+ "				date(date) <= date('{date_to}')\n"
				+ "			GROUP BY\n"
				+ "				product_id\n"
				+ "		) t_current_stock\n"
				+ "	ON\n"
				+ "		t_current_stock.product_id = product.id\n"
				+ "	LEFT JOIN\n"
				+ "		(\n"
				+ "			SELECT\n"
				+ "				product_id,\n"
				+ "				-- if SUM(qty) = 0 THEN rate = 0\n"
				+ "				-- else rate = sum(amt) / sum(qty)\n"
				+ "				IF(IFNULL(SUM(qty), 0) = 0, 0, IFNULL(SUM(amt), 0) / IFNULL(SUM(qty), 0)) rate\n"
				+ "			FROM	\n"
				+ "				goods_journal\n"
				+ "			LEFT JOIN\n"
				+ "				voucher\n"
				+ "			ON	\n"
				+ "				goods_journal.voucher_id = voucher.id\n"
				+ "			WHERE \n"
				+ "				tx_type = 1 -- Where stock is added\n"
				+ "			AND \n"
				+ "				(\n"
				+ "					voucher_id IS NULL -- Where it is opening stock\n"
				+ "					OR \n"
				+ "					voucher_type_id IN (1, 29) -- Where it is purchase or inv adjust\n"
				+ "				)\n"
				+ "			AND\n"
				+ "				date(goods_journal.date) <= date('{date_to}')\n"
				+ "			GROUP BY\n"
				+ "				product_id\n"
				+ "		) t_rate\n"
				+ "	ON\n"
				+ "		t_rate.product_id = product.id\n"
				+ "	LEFT JOIN\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			SUM((order_journal.order_qty - IFNULL(t_order_set_qty.set_qty, 0))) pending_qty_purchase\n"
				+ "		FROM\n"
				+ "			order_journal\n"
				+ "		LEFT JOIN\n"
				+ "			(\n"
				+ "				SELECT\n"
				+ "					order_journal_id_order,\n"
				+ "					IFNULL(SUM(QTY),0) set_qty\n"
				+ "				FROM\n"
				+ "					order_set_against\n"
				+ "				GROUP BY\n"
				+ "					order_journal_id_order\n"
				+ "			) t_order_set_qty\n"
				+ "		ON\n"
				+ "			t_order_set_qty.order_journal_id_order = order_journal.id	\n"
				+ "		WHERE\n"
				+ "			order_type_id = 1\n"
				+ "		AND\n"
				+ "			order_qty IS NOT NULL\n"
				+ "		AND\n"
				+ "			order_journal.order_qty > IFNULL(t_order_set_qty.set_qty, 0)\n"
				+ "		AND\n"
				+ "			date(order_journal.date) <= date('{date_to}')\n"
				+ "		GROUP BY \n"
				+ "			product_id\n"
				+ "	) t_pending_qty_purchase\n"
				+ "	ON\n"
				+ "		t_pending_qty_purchase.product_id = product.id\n"
				+ "	LEFT JOIN\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			SUM((order_journal.order_qty - IFNULL(t_order_set_qty.set_qty, 0))) pending_qty_sales\n"
				+ "		FROM\n"
				+ "			order_journal\n"
				+ "		LEFT JOIN\n"
				+ "			(\n"
				+ "				SELECT\n"
				+ "					order_journal_id_order,\n"
				+ "					IFNULL(SUM(QTY),0) set_qty\n"
				+ "				FROM\n"
				+ "					order_set_against\n"
				+ "				GROUP BY\n"
				+ "					order_journal_id_order\n"
				+ "			) t_order_set_qty\n"
				+ "		ON\n"
				+ "			t_order_set_qty.order_journal_id_order = order_journal.id	\n"
				+ "		WHERE\n"
				+ "			order_type_id = 2\n"
				+ "		AND\n"
				+ "			order_qty IS NOT NULL\n"
				+ "		AND\n"
				+ "			order_journal.order_qty > IFNULL(t_order_set_qty.set_qty, 0)\n"
				+ "		AND\n"
				+ "			date(order_journal.date) <= date('{date_to}')\n"
				+ "		GROUP BY \n"
				+ "			product_id\n"
				+ "	) t_pending_qty_sales\n"
				+ "	ON\n"
				+ "		t_pending_qty_sales.product_id = product.id\n"
				+ " LEFT JOIN\n"
				+ "	(\n"
				+ "		SELECT\n"
				+ "			product_id,\n"
				+ "			IFNULL(SUM(qty),0) / t_avg_sales_days.avg_sales_days avg_daily_sales\n"
				+ "		FROM\n"
				+ "			sales_item\n"
				+ "		LEFT JOIN\n"
				+ "			voucher\n"
				+ "		ON\n"
				+ "			voucher.id = sales_item.sales_id\n"
				+ "		JOIN\n"
				+ "		(\n"
				+ "			SELECT \n"
				+ "				IF(\n"
				+ "					VALUE IS NULL OR\n"
				+ "					CAST(VALUE AS UNSIGNED) IS NULL OR\n"
				+ "					CAST(VALUE AS UNSIGNED) <= 0,\n"
				+ "					1,\n"
				+ "					CAST(VALUE AS UNSIGNED)\n"
				+ "				) avg_sales_days\n"
				+ "			FROM\n"
				+ "				config\n"
				+ "			WHERE 	\n"
				+ "				`key` = 'avg_sales_days'\n"
				+ "		) t_avg_sales_days\n"
				+ "		WHERE\n"
				+ "			voucher.date >= DATE_ADD(NOW(), INTERVAL (-1 * t_avg_sales_days.avg_sales_days) DAY)\n"
				+ "		GROUP BY\n"
				+ "			product_id\n"
				+ "	) t_avg_daily_sales\n"
				+ "	ON\n"
				+ "		t_avg_daily_sales.product_id = product.id\n"
				+ ") t_final\n"
				+ "JOIN\n"
				+ "	cte_cat\n"
				+ "ON	\n"
				+ "	cte_cat.child_id = t_final.category_id\n"
				+ "LEFT JOIN\n"
				+ "	product_category\n"
				+ "ON\n"
				+ "	product_category.id = cte_cat.root_id\n"
				+ "GROUP BY\n"
				+ "	root_id";

		if (dateTo == null)
		{
			dateTo = Util.stringToDate("9999-12-31", Util.Formats.DB_DATE);
		}

		List<String> having = new ArrayList<>();
		if (lowStock != null)
		{
			if (lowStock)
			{
				having.add("shortfall > 0");
			}
			else
			{
				having.add("shortfall <= 0");
			}
		}
		sql = SqlHelper.putHavings(having, sql);

		List<ColSettingModel> colSettingModels = colSettingDao.getByMenuIdForOrder(ListMenu.CURRENT_STOCK_BY_CAT.getId(), true);

		List<String> orderBys = new ArrayList<>();
		for (ColSettingModel colSettingModel : colSettingModels)
		{
			orderBys.add(String.format("%s %s", colSettingModel.getColKey(), colSettingModel.getOrderByType().getSqlName()));
		}

		sql = SqlHelper.putOrderBys(orderBys, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_prod_cat", tableName);
		map.put("table_goods_journal", TableName.GOODS_JOURNAL);

		map.put("date_to", Util.dateToString(dateTo, Util.Formats.DB_DATE));

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, CurrentStockDetHdto.class).getResultList();

	}

	public List<ProductCatModel> getForMigration(Integer limit, Integer offset)
	{
		String sql = String.format("SELECT * FROM %s ORDER BY parent_id, id ", tableName);
		if (limit != null)
		{
			sql = sql + String.format(" LIMIT %s", limit);
		}
		if (offset != null)
		{
			sql = sql + String.format(" OFFSET %s", offset);
		}
		return session.createNativeQuery(sql, ProductCatModel.class).getResultList();
	}

	public List<ProductCatModel> get()
	{
		String sql = String.format(DaoHelper.SELECT_SQL, tableName);
		return session.createNativeQuery(sql, ProductCatModel.class).getResultList();
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.PRODUCT_CAT, id)).executeUpdate();
	}

	public void delete(ProductCatModel productCategoryModel)
	{
		session.remove(productCategoryModel);
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return tableName;
	}

}
