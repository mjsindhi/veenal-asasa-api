package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.PaymentStatusLdto;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.PaymentStatusModel;
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
public class PaymentStatusDao
{

	@Autowired
	private EntityManager session;

	@Transactional
	public void create(PaymentStatusModel paymentStatusModel)
	{
		session.persist(paymentStatusModel);
	}

	public PaymentStatusModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.PAYMENT_STATUS, String.valueOf(id));
		List<PaymentStatusModel> dtos = session.createNativeQuery(sql, PaymentStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public PaymentStatusModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, TableName.PAYMENT_STATUS, SqlHelper.escape(name));
		List<PaymentStatusModel> dtos = session.createNativeQuery(sql, PaymentStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<PaymentStatusLdto> getLdtos(String name, String paymentStatusId)
	{
		String sql = "	SELECT	\n"
				+ "			{table_paymentStatus}.id as id,\n"
				+ "			{table_paymentStatus}.name as name,\n"
				+ "			{table_paymentStatus}.paymentStatus_id as paymentStatus_id,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_paymentStatus}.created_at as created_at\n"
				+ "		FROM\n"
				+ "			{table_paymentStatus}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_paymentStatus}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (paymentStatusId != null && !paymentStatusId.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "paymentStatus_id", SqlHelper.escape(paymentStatusId)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_paymentStatus", "paymentStatus");
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<PaymentStatusLdto> paymentStatusLdtos = session
				.createNativeQuery(sql, PaymentStatusLdto.class)
				.getResultList();

		return paymentStatusLdtos;

	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_paymentStatus} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_paymentStatus", "paymentStatus");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_paymentStatus} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_paymentStatus", TableName.PAYMENT_STATUS);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.PAYMENT_STATUS, id)).executeUpdate();
	}
}
