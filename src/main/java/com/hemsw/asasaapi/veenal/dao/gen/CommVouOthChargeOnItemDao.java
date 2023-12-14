package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.model.gen.CommVouOthChargeOnItemModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommVouOthChargeOnItemDao //extends BaseDao<CommVouOthChargeModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	String tableName = "comm_vou_oth_charge_on_item";
	String sqlDeleteByCommVouId = "DELETE FROM %s WHERE comm_vou_id = %s;";

	public String getTableName()
	{
		return tableName;
	}

	public List<CommVouOthChargeOnItemModel> get(int commVouId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();
		wheres.add(tableName + ".comm_vou_id=" + commVouId);
		sql = SqlHelper.putWheres(wheres, sql);
		return session.createNativeQuery(sql, CommVouOthChargeOnItemModel.class).getResultList();
	}

	public void save(int commVouId, List<CommVouOthChargeOnItemModel> commVouOthChargeModels)
	{
		String sql = String.format(sqlDeleteByCommVouId, tableName, commVouId);
		session.createNativeQuery(sql).executeUpdate();

		for (CommVouOthChargeOnItemModel commVouOthChargeModel : commVouOthChargeModels)
		{
			commVouOthChargeModel.setCommVouId(commVouId);
			session.persist(commVouOthChargeModel);
		}
	}
}
