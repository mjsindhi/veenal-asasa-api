package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.model.gen.CommVouItemModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommVouItemDao
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private OrderJournalDao orderJournalDao;

	String tableName = "comm_vou_item";
	String sqlGetByCommVouId = "SELECT * FROM %s WHERE comm_vou_id = %s";

	public void create(CommVouItemModel commVouItemModel)
	{
		session.persist(commVouItemModel);
	}

	public String getTableName()
	{
		return tableName;
	}

	public List<CommVouItemModel> getByCommVouId(int commVouId)
	{
		String sql = String.format(sqlGetByCommVouId, tableName, String.valueOf(commVouId));
		return session.createNativeQuery(sql, CommVouItemModel.class).getResultList();
	}

	public void deleteAllByInvAdjustId(int purchaseOrderId)
	{

		orderJournalDao.deleteAllVoucherItemIds(purchaseOrderId);

		String sql = String.format("DELETE FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("comm_vou_id=%s", purchaseOrderId));

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

}
