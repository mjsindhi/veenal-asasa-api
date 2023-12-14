package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.model.gen.SalesAgentModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesAgentDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	public static final String tableName = "sales_agent";

	public void create(SalesAgentModel salesAgentModel)
	{
		session.persist(salesAgentModel);
	}

	public List<SalesAgentModel> getBySalesId(int salesId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = '%s'", "sales_id", salesId));
		sql = SqlHelper.putWheres(conditions, sql);
		return session.createNativeQuery(sql, SalesAgentModel.class).getResultList();
	}

	public void deleteExtra(int salesId, List<SalesAgentModel> salesAgentModels)
	{
		int[] nos = new int[salesAgentModels.size()];
		for (int i = 0; i < salesAgentModels.size(); i++)
		{
			nos[i] = salesAgentModels.get(i).getId();
		}

		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = %s", "sales_id", salesId));
		if (nos.length > 0)
		{
			conditions.add(String.format("%s NOT IN (%s)", "id", Util.getCSV(nos)));
		}

		String sql = String.format("DELETE FROM %s", tableName);
		sql = SqlHelper.putWheres(conditions, sql);
		session.createNativeQuery(sql).executeUpdate();
	}

	public void deleteBySalesId(int salesId)
	{
		String sql = String.format("DELETE FROM %s", tableName);
		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = '%s'", "sales_id", salesId));
		sql = SqlHelper.putWheres(conditions, sql);
		session.createNativeQuery(sql).executeUpdate();
	}

	public String getTableName()
	{
		return tableName;
	}

}
