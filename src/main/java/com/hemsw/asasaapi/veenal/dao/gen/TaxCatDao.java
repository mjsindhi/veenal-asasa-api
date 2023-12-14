package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.TaxCategoryLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.TaxCatModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxCatDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	public static final String tableName = "tax_category";

	public void create(TaxCatModel taxCategoryModel)
	{
		session.persist(taxCategoryModel);
	}

	public List<TaxCatModel> get()
	{
		String sql = String.format(DaoHelper.SELECT_SQL, tableName);
		return session.createNativeQuery(sql, TaxCatModel.class).getResultList();
	}

	public TaxCatModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<TaxCatModel> dtos = session.createNativeQuery(sql, TaxCatModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public TaxCatModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<TaxCatModel> dtos = session.createNativeQuery(sql, TaxCatModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<TaxCategoryLdto> getLdtos(String name)
	{
		String sql = "SELECT\n"
				+ "	{table_tax_cat}.id,\n"
				+ "	{table_tax_cat}.name,\n"
				+ "	{table_tax}.name tax_name,\n"
				+ "	{table_tax_cat}.hsn, \n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_tax_cat}.created_at\n"
				+ "FROM	\n"
				+ "	{table_tax_cat}\n"
				+ "LEFT JOIN\n"
				+ "	{table_tax}\n"
				+ "ON\n"
				+ "	{table_tax}.`id` = {table_tax_cat}.tax_id"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_tax_cat}.created_by_user_id\n";
		sql = String.format(sql, tableName);

		List<String> conditions = new ArrayList<>();
		if (name != null && !name.isEmpty())
		{
			conditions.add(String.format("%s LIKE '%%%s%%'", "{table_tax_cat}.name", name));
		}
		sql = SqlHelper.putWheres(conditions, sql);
		sql = sql + " ORDER BY name ASC";

		Map<String, String> map = new HashMap<>();
		map.put("table_tax_cat", tableName);
		map.put("table_tax", TableName.TAX);
		map.put("table_user", TableName.USER);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, TaxCategoryLdto.class).getResultList();
	}

	public List<String> getNames()
	{
		String sql = String.format("SELECT name FROM %s", tableName);
		return session.createNativeQuery(sql, String.class).getResultList();
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_tax_cat} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_tax_cat", TableName.TAX_CAT);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_tax_category} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_tax_category", TableName.TAX_CAT);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();
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
