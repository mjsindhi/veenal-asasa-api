package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.ProductLdto;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepoImpl
{

	@Autowired
	private EntityManager session;

	@Transactional
	public void create(ProductModel productModel)
	{
		session.persist(productModel);
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
			Integer taxCatId,
			Boolean isMfg
	)
	{
		String sql = "SELECT\n"
				+ "	{table_product}.id,\n"
				+ "	{table_product}.name,\n"
				+ "	{table_product}.code,\n"
				+ "	{table_unit}.name unit_name,\n"
				+ "	(CASE WHEN {table_product}.tax_category_id IS NULL THEN {table_product}.hsn ELSE {table_tax_cat}.hsn END) hsn,\n"
				+ "	{table_product}.purchase_price,\n"
				+ "	{table_product}.sales_price,\n"
				+ "	{table_product}.min_sales_price,\n"
				+ "	{table_product}.max_sales_price,\n"
				+ "	{table_product}.internet_sales_price,\n"
				+ "	{table_product}.mrp,\n"
				+ "	{table_product}.discount,\n"
				+ "	{table_category}.name product_category_name,\n"
				+ "	{table_tax_cat}.name tax_category_name,\n"
				+ "	(CASE WHEN {table_product}.tax_category_id IS NULL THEN tbl_tax_2.name ELSE {table_tax}.name END) tax_name,\n"
				+ "	{table_product}.note,\n"
				+ "	{table_product}.is_sold,\n"
				+ "	{table_product}.is_made,\n"
				+ "	{table_product}.min_qty,\n"
				+ "	{table_product}.reorder_qty,\n"
				+ "	{table_acct}.name supplier_name,\n"
				+ "	{table_product}.weight,\n"
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
				+ "	{table_product}.`product_category_id` = {table_category}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax_cat}\n"
				+ "ON\n"
				+ "	{table_product}.`tax_category_id` = {table_tax_cat}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax}\n"
				+ "ON\n"
				+ "	{table_tax_cat}.`tax_id` = {table_tax}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_acct}\n"
				+ "ON\n"
				+ "	{table_product}.`supplier_id` = {table_acct}.id\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax} as tbl_tax_2\n"
				+ "ON\n"
				+ "	{table_product}.`tax_id` = {table_tax}.id"
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
		if (taxCatId != null)
		{
			wheres.add("{table_product}.tax_category_id = " + taxCatId + "");
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
		map.put("table_category", TableName.PRODUCT_CATEGORY);
		map.put("table_tax_cat", TableName.TAX_CATEGORY);
		map.put("table_tax", TableName.TAX);
		map.put("table_acct", TableName.ACCT);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		List<ProductLdto> productLdtos = session
				.createNativeQuery(sql, ProductLdto.class)
				.getResultList();

		return productLdtos;

	}

}
