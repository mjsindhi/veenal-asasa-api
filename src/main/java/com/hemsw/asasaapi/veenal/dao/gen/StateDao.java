package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.StateLdto;
import com.hemsw.asasaapi.veenal.model.gen.StateModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateDao
{

	@Autowired
	private EntityManager session;

	public void create(StateModel stateModel)
	{
		session.persist(stateModel);
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_state} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_state", TableName.STATE);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_state} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_state", "state");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isCodeNameExists(String codeName)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_state} WHERE code_name = '%s'", SqlHelper.escape(codeName));
		Map<String, String> map = new HashMap<>();
		map.put("table_state", "state");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isCodeNoExists(int codeNo)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_state} WHERE code_no = %s", codeNo);
		Map<String, String> map = new HashMap<>();
		map.put("table_state", "state");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<StateLdto> getLdtos(String name, Integer countryId)
	{
		String sql = "SELECT\n"
				+ "	{table_state}.id,\n"
				+ "	{table_state}.name,\n"
				+ "	{table_state}.code_name,\n"
				+ "	{table_state}.code_no,\n"
				+ "	{table_country}.id country_id,\n"
				+ "	{table_country}.name country_name,\n"
				+ "	{table_user}.id created_by_user_id,\n"
				+ "	{table_user}.name created_by_user_name,\n"
				+ "	{table_state}.created_at\n"
				+ "FROM	\n"
				+ "	{table_state}\n"
				+ "LEFT JOIN\n"
				+ "	{table_country}\n"
				+ "ON\n"
				+ "	{table_state}.`country_id` = {table_country}.id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_state}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (countryId != null)
		{
			wheres.add(String.format("%s = %s", "country_id", countryId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_state", TableName.STATE);
		map.put("table_country", TableName.COUNTRY);
		map.put("table_user", TableName.USER);
		sql = Util.formatString(sql, map);

		List<StateLdto> stateLdtos = session
				.createNativeQuery(sql, StateLdto.class)
				.getResultList();

		return stateLdtos;

	}
}
