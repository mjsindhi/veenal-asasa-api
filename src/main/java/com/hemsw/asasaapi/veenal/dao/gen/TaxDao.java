package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.TaxLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.TaxModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;
	public static String tableName = "tax";

	public void create(TaxModel taxModel)
	{
		session.persist(taxModel);
	}

	public List<TaxLdto> getLdtos(String name)
	{
		String sql = "SELECT\n"
				+ "	{table_tax}.id,\n"
				+ "	{table_tax}.name,\n"
				+ "	{table_tax}.cgst,\n"
				+ "	{table_tax}.sgst,\n"
				+ "	{table_tax}.igst,\n"
				+ "	{table_tax}.note,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_tax}.created_at\n"
				+ "FROM	\n"
				+ "	{table_tax}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_tax}.created_by_user_id\n";
		sql = String.format(sql, tableName);

		List<String> conditions = new ArrayList<>();
		if (name != null && !name.isEmpty())
		{
			conditions.add(String.format("%s LIKE '%%%s%%'", "{table_tax}.name", name));
		}
		sql = SqlHelper.putWheres(conditions, sql);
		sql = sql + " ORDER BY name ASC";

		Map<String, String> map = new HashMap<>();
		map.put("table_tax", tableName);
		map.put("table_user", TableName.USER);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, TaxLdto.class).getResultList();
	}

	public TaxModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, getTableName(), String.valueOf(id));
		List<TaxModel> dtos = session.createNativeQuery(sql, TaxModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<String> getNames()
	{
		String sql = String.format("SELECT name FROM %s", tableName);
		return session.createNativeQuery(sql, String.class).getResultList();
	}

	public TaxModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<TaxModel> dtos = session.createNativeQuery(sql, TaxModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<TaxModel> get()
	{
		String sql = String.format(DaoHelper.SELECT_SQL, tableName);
		return session.createNativeQuery(sql, TaxModel.class).getResultList();
	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.TAX, id)).executeUpdate();
	}

	public void delete(TaxModel taxModel)
	{
		session.remove(taxModel);
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_tax} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_tax", TableName.TAX);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public String getTableName()
	{
		return tableName;
	}

}
