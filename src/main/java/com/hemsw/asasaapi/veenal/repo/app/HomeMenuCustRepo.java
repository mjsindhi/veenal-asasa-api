package com.hemsw.asasaapi.veenal.repo.app;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.model.app.MenuModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeMenuCustRepo
{

	public static final String tableName = "home_menu_cust";

	@Autowired
	private EntityManager session;

	public List<MenuModel> getByParentId(Integer parentId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);

		List<String> wheres = new ArrayList<>();

		if (parentId == null)
		{
			wheres.add(String.format("%s IS NULL", "parent_id"));
		}
		else
		{
			wheres.add(String.format("%s = %s", "parent_id", parentId));
		}

		sql = SqlHelper.putWheres(wheres, sql);

		sql = sql + " ORDER BY id\n";

		return session.createNativeQuery(sql, MenuModel.class)
				.getResultList();

	}

}
