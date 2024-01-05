package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.FulfillmentStatusLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.FulfillmentStatusModel;
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
public class FulfillmentStatusDao
{

	@Autowired
	private EntityManager session;

	@Transactional
	public void create(FulfillmentStatusModel fulfillmentStatusModel)
	{
		session.persist(fulfillmentStatusModel);
	}

	public FulfillmentStatusModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.FULFILLMENT_STATUS, String.valueOf(id));
		List<FulfillmentStatusModel> dtos = session.createNativeQuery(sql, FulfillmentStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public FulfillmentStatusModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, TableName.FULFILLMENT_STATUS, SqlHelper.escape(name));
		List<FulfillmentStatusModel> dtos = session.createNativeQuery(sql, FulfillmentStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<FulfillmentStatusLdto> getLdtos(String name, String fulfillmentStatusId)
	{
		String sql = "	SELECT	\n"
				+ "			{table_fulfillmentStatus}.id as id,\n"
				+ "			{table_fulfillmentStatus}.name as name,\n"
				+ "			{table_fulfillmentStatus}.fulfillmentStatus_id as fulfillmentStatus_id,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_fulfillmentStatus}.created_at as created_at\n"
				+ "		FROM\n"
				+ "			{table_fulfillmentStatus}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_fulfillmentStatus}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (fulfillmentStatusId != null && !fulfillmentStatusId.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "fulfillmentStatus_id", SqlHelper.escape(fulfillmentStatusId)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_fulfillmentStatus", "fulfillmentStatus");
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<FulfillmentStatusLdto> fulfillmentStatusLdtos = session
				.createNativeQuery(sql, FulfillmentStatusLdto.class)
				.getResultList();

		return fulfillmentStatusLdtos;

	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_fulfillmentStatus} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_fulfillmentStatus", "fulfillmentStatus");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_fulfillmentStatus} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_fulfillmentStatus", TableName.FULFILLMENT_STATUS);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.FULFILLMENT_STATUS, id)).executeUpdate();
	}
}
