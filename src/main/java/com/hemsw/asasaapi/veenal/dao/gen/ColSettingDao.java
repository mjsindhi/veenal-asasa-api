package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.app.ColSettingModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ColSettingDao
{

	@Autowired
	private EntityManager session;

	public ColSettingModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, TableName.COL_SETTING, String.valueOf(id));
		List<ColSettingModel> dtos = session.createNativeQuery(sql, ColSettingModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<ColSettingModel> getByMenuIdForSelect(int menuId, Boolean isVisible)
	{
		String sql = String.format(DaoHelper.SELECT_SQL, TableName.COL_SETTING);

		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = '%s'", "menu_id", menuId));

		if (isVisible != null)
		{
			conditions.add(String.format("%s = %s", "is_visible", isVisible ? 1 : 0));
		}

		sql = SqlHelper.putWheres(conditions, sql);

		sql = sql + " ORDER BY is_visible DESC,\n";
		sql = sql + " seq_no ASC\n";

		return session.createNativeQuery(sql, ColSettingModel.class).getResultList();
	}

	public List<ColSettingModel> getByMenuIdForOrder(int menuId, Boolean isOrderBy)
	{
		String sql = String.format(DaoHelper.SELECT_SQL, TableName.COL_SETTING);

		List<String> conditions = new ArrayList<>();
		conditions.add(String.format("%s = '%s'", "menu_id", menuId));

		if (isOrderBy != null)
		{
			conditions.add(String.format("%s = %s", "is_order_by", isOrderBy ? 1 : 0));
		}

		sql = SqlHelper.putWheres(conditions, sql);

		sql = sql + " ORDER BY is_order_by DESC,\n";
		sql = sql + " order_by_seq_no ASC\n";

		return session.createNativeQuery(sql, ColSettingModel.class).getResultList();
	}
}
