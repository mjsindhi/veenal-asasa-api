package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.SalesChannelLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.SalesChannelModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesChannelDao
{

	@Autowired
	private EntityManager session;

	public void create(SalesChannelModel salesChannelModel)
	{
		session.persist(salesChannelModel);
	}

	public List<SalesChannelLdto> getLdtos(String name)
	{
		String sql = "SELECT\n"
				+ "	{table_lead_src}.id,\n"
				+ "	{table_lead_src}.name,\n"
				+ "	{table_user}.id created_by_user_id,\n"
				+ "	{table_user}.name created_by_user_name,\n"
				+ "	{table_lead_src}.created_at\n"
				+ "FROM	\n"
				+ "	{table_lead_src}\n"
				+ "	LEFT JOIN\n"
				+ "		{table_user}\n"
				+ "	ON\n"
				+ "		{table_user}.id = {table_lead_src}.created_by_user_id\n";

		sql = String.format(sql, TableName.SALES_CHANNEL);

		List<String> conditions = new ArrayList<>();
		if (name != null && !name.isEmpty())
		{
			conditions.add(String.format("%s LIKE '%%%s%%'", "{table_lead_src}.name", name));
		}
		sql = SqlHelper.putWheres(conditions, sql);
		sql = sql + " ORDER BY name ASC";

		Map<String, String> map = new HashMap<>();
		map.put("table_lead_src", TableName.SALES_CHANNEL);
		map.put("table_user", TableName.USER);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, SalesChannelLdto.class).getResultList();
	}

	public SalesChannelModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<SalesChannelModel> dtos = session.createNativeQuery(sql, SalesChannelModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<String> getNames()
	{
		String sql = String.format("SELECT name FROM %s", TableName.SALES_CHANNEL);
		return session.createNativeQuery(sql, String.class).getResultList();
	}

	public List<SalesChannelModel> get()
	{
		String sql = String.format(DaoHelper.SELECT_SQL, TableName.SALES_CHANNEL);
		return session.createNativeQuery(sql, SalesChannelModel.class).getResultList();
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", TableName.SALES_CHANNEL);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return TableName.SALES_CHANNEL;
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_lead_status} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_lead_status", "lead_src");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}
}
