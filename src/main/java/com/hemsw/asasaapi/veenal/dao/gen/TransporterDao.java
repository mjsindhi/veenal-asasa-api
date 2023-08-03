package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.dto.ldto.TransporterLdto;
import com.hemsw.asasaapi.veenal.model.gen.TransporterModel;
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
public class TransporterDao
{

	@Autowired
	private EntityManager session;

	@Transactional
	public void create(TransporterModel transporterModel)
	{
		session.persist(transporterModel);
	}

	public boolean isNameExists(String name)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_transporter} WHERE name = '%s'", SqlHelper.escape(name));
		Map<String, String> map = new HashMap<>();
		map.put("table_transporter", "transporter");
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public List<TransporterLdto> getLdtos(String name, String transporterId)
	{
		String sql = "	SELECT	\n"
				+ "			{table_transporter}.id as id,\n"
				+ "			{table_transporter}.name as name,\n"
				+ "			{table_transporter}.transporter_id as transporter_id,\n"
				+ "			{table_user}.name created_by_user_name,\n"
				+ "			{table_transporter}.created_at as created_at\n"
				+ "		FROM\n"
				+ "			{table_transporter}\n"
				+ "		LEFT JOIN\n"
				+ "			{table_user}\n"
				+ "		ON\n"
				+ "			{table_user}.id = {table_transporter}.created_by_user_id\n";

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}
		if (transporterId != null && !transporterId.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "transporter_id", SqlHelper.escape(transporterId)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_transporter", "transporter");
		map.put("table_user", "user");
		sql = Util.formatString(sql, map);

		List<TransporterLdto> transporterLdtos = session
				.createNativeQuery(sql, TransporterLdto.class)
				.getResultList();

		return transporterLdtos;

	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table_transporter} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table_transporter", TableName.TRANSPORTER);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}
}
