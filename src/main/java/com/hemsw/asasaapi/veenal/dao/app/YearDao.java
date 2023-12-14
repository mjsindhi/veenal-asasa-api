package com.hemsw.asasaapi.veenal.dao.app;

import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.YearModel;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YearDao
{

	@Autowired
	private EntityManager session;

	String tableName = "year";
	String sqlSelectByYearId = "SELECT * FROM %s WHERE company_id=%s";
	String sqlGetDefaultOne = "SELECT * FROM %s WHERE is_default=1";
	String sqlUnsetDefaultToAll = "UPDATE %s SET is_default = 0;";

	public void unsetDefaultToAll() throws SQLException
	{
		String sql = String.format(sqlUnsetDefaultToAll, tableName);
		session.createNativeQuery(sql).executeUpdate();
	}

	public YearModel getById(long id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.ACCT, String.valueOf(id));
		List<YearModel> yearModels = session.createNativeQuery(sql, YearModel.class).getResultList();
		if (yearModels == null || yearModels.size() != 1)
		{
			return null;
		}

		return yearModels.get(0);
	}

	public List<YearModel> getByCompanyId(long id)
	{
		String sql = String.format(sqlSelectByYearId, tableName, String.valueOf(id));
		List<YearModel> yearModels = session.createNativeQuery(sql, YearModel.class).getResultList();
		return yearModels;
	}

	public YearModel getDefaultOne()
	{
		String sql = String.format(sqlGetDefaultOne, tableName);
		List<YearModel> yearModels = session.createNativeQuery(sql, YearModel.class).getResultList();
		if (yearModels == null || yearModels.isEmpty() || yearModels.size() > 1)
		{
			return null;
		}
		else
		{
			return yearModels.get(0);
		}
	}

	public String getTableName()
	{
		return tableName;
	}
}
