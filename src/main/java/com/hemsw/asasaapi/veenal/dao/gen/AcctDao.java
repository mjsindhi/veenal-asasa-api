package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.dto.ldto.AcctLdto;
import com.hemsw.asasaapi.veenal.model.gen.AcctModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcctDao
{

	@Autowired
	private EntityManager session;

	public void create(AcctModel acctModel)
	{
		session.persist(acctModel);
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_acct} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_acct", "acct");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<AcctLdto> getLdtos(String name, String acctId)
	{
		String sql = "	SELECT	\n"
				+ "			{table_acct}.id as id,\n"
				+ "			{table_acct}.name as name,\n"
				+ "			{table_acct}.acct_id as acct_id,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_acct}.created_at as created_at\n"
				+ "		FROM\n"
				+ "			{table_acct}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_acct}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (acctId != null && !acctId.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "acct_id", SqlHelper.escape(acctId)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_acct", "acct");
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<AcctLdto> acctLdtos = session
				.createNativeQuery(sql, AcctLdto.class)
				.getResultList();

		return acctLdtos;

	}
}
