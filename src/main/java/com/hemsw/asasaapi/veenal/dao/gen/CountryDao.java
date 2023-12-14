package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.dto.ldto.CountryLdto;
import com.hemsw.asasaapi.veenal.model.gen.CountryModel;
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
public class CountryDao
{

	@Autowired
	private EntityManager session;

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_country} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_country", "country");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isCodeExists(String code)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_country} WHERE code = '%s'", SqlHelper.escape(code));
		Map<String, String> map = new HashMap<>();
		map.put("table_country", "country");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	@Transactional
	public void create(CountryModel countryModel)
	{
		session.persist(countryModel);
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_country} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_country", "country");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<CountryLdto> getLdtos(String name)
	{
		String sql = "	SELECT	\n"
				+ "			{table_country}.id as id,\n"
				+ "			{table_country}.name as name,\n"
				+ "			{table_country}.code as code,\n"
				+ "			{table_country}.currency_name,\n"
				+ "			{table_country}.currency_code,\n"
				+ "	{table_user}.id created_by_user_id,\n"
				+ "	{table_user}.name created_by_user_name,\n"
				+ "	{table_country}.created_at\n"
				+ "		FROM\n"
				+ "			{table_country}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_country}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_country", "country");
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<CountryLdto> countryLdtos = session
				.createNativeQuery(sql, CountryLdto.class)
				.getResultList();

		return countryLdtos;

	}
}
