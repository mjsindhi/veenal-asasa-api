package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.EstimateStatusModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstimateStatusDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	public static String tableName = "estimate_status";

	public void create(EstimateStatusModel vObj)
	{
		session.persist(vObj);
	}

	public boolean isIdExists(int id)
	{
		String sql = String.format("SELECT COUNT(id)>0 FROM {table} WHERE id = %s", id);
		Map<String, String> map = new HashMap<>();
		map.put("table", TableName.ESTIMATE_STATUS);
		sql = Util.formatString(sql, map);
		return (boolean) session
				.createNativeQuery(sql, Boolean.TYPE)
				.getSingleResult();

	}

	public EstimateStatusModel getByName(String name)
	{
		String sql = String.format(DaoHelper.SELECT_BY_NAME_SQL, getTableName(), SqlHelper.escape(name));
		List<EstimateStatusModel> dtos = session.createNativeQuery(sql, EstimateStatusModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<String> getNames()
	{
		String sql = String.format("SELECT name FROM %s", tableName);
		return session.createNativeQuery(sql, String.class).getResultList();
	}

	public List<EstimateStatusModel> get(String name)
	{
		String sql = String.format(DaoHelper.SELECT_SQL, TableName.ESTIMATE_STATUS);

		List<String> wheres = new ArrayList<>();

		if (name != null && !name.isEmpty())
		{
			wheres.add(String.format("%s LIKE '%%%s%%'", "name", SqlHelper.escape(name)));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		List<EstimateStatusModel> results = session
				.createNativeQuery(sql, EstimateStatusModel.class)
				.getResultList();

		return results;

	}

	public void delete(int id)
	{
		session.createNativeQuery(String.format(DaoHelper.DELETE_BY_ID_SQL, TableName.ESTIMATE_STATUS, id)).executeUpdate();
	}

	public void delete(EstimateStatusModel estimateStatusModel)
	{
		session.remove(estimateStatusModel);
	}

	public void deleteAll()
	{
		String sql = String.format("DELETE FROM %s", tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return tableName;
	}

}
