package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.dto.ldto.UnitLdto;
import com.hemsw.asasaapi.veenal.model.gen.UnitModel;
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
public class UnitRepoImpl
{

	@Autowired
	private EntityManager session;

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_unit} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_unit", "unit");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isCodeExists(String code)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_unit} WHERE code = '%s'", SqlHelper.escape(code));
		Map<String, String> map = new HashMap<>();
		map.put("table_unit", "unit");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	@Transactional
	public void create(UnitModel unitModel)
	{
		session.persist(unitModel);
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_unit} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_unit", "unit");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<UnitLdto> getLdtos(String name)
	{
		String sql = "	SELECT	\n"
				+ "			{table_unit}.id as id,\n"
				+ "			{table_unit}.code as code,\n"
				+ "			{table_unit}.name as name,\n"
				+ "			{table_unit}.is_derived as is_derived,\n"
				+ "			{table_unit}.base_unit_id as base_unit_id,\n"
				+ "			base_unit.name as base_unit_name,\n"
				+ "			{table_unit}.operator_id as operator_id,\n"
				+ "			{table_unit}.num as num,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_unit}.created_at as created_at\n"
				+ "		FROM\n"
				+ "			{table_unit}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_unit} base_unit\n"
				+ "		ON\n"
				+ "			base_unit.id = {table_unit}.base_unit_id\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_unit}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_unit", "unit");
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<UnitLdto> unitLdtos = session
				.createNativeQuery(sql, UnitLdto.class)
				.getResultList();

		return unitLdtos;

	}
}
