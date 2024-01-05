package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.DeliveryStatusLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.DeliveryStatusModel;
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
public class DeliveryStatusDao
{

	@Autowired
	private EntityManager session;

	@Transactional
	public void create(DeliveryStatusModel deliveryStatusModel)
	{
		session.persist(deliveryStatusModel);
	}

	public DeliveryStatusModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.DELIVERY_STATUS, String.valueOf(id));
		List<DeliveryStatusModel> dtos = session.createNativeQuery(sql, DeliveryStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public DeliveryStatusModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, TableName.DELIVERY_STATUS, SqlHelper.escape(name));
		List<DeliveryStatusModel> dtos = session.createNativeQuery(sql, DeliveryStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<DeliveryStatusLdto> getLdtos(String name, String deliveryStatusId)
	{
		String sql = "	SELECT	\n"
				+ "			{table_delivery_status}.id as id,\n"
				+ "			{table_delivery_status}.name as name,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_delivery_status}.created_at as created_at\n"
				+ "		FROM\n"
				+ "			{table_delivery_status}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_delivery_status}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (deliveryStatusId != null && !deliveryStatusId.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "delivery_status_id", SqlHelper.escape(deliveryStatusId)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_delivery_status", TableName.DELIVERY_STATUS);
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<DeliveryStatusLdto> deliveryStatusLdtos = session
				.createNativeQuery(sql, DeliveryStatusLdto.class)
				.getResultList();

		return deliveryStatusLdtos;

	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_delivery_status} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_delivery_status", TableName.DELIVERY_STATUS);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_delivery_status} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_delivery_status", TableName.DELIVERY_STATUS);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.DELIVERY_STATUS, id)).executeUpdate();
	}
}
