package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.helper.DaoHelper;
import com.hemsw.asasaapi.veenal.model.gen.EstimateItemModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstimateItemDao //extends BaseDao<EstimateItemModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	@Autowired
	private OrderJournalDao orderJournalDao;

	public static final String tableName = "estimate_item";

	public void create(EstimateItemModel vObj)
	{
		session.persist(vObj);
	}

	public EstimateItemModel getById(int id)
	{
		String sql = String.format(DaoHelper.SELECT_BY_ID_SQL, tableName, String.valueOf(id));
		List<EstimateItemModel> dtos = session.createNativeQuery(sql, EstimateItemModel.class).getResultList();
		return (dtos == null || dtos.isEmpty() ? null : dtos.get(0));
	}

	public List<EstimateItemModel> getByEstimateId(int estimateId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("estimate_id=%s", estimateId));
		sql = SqlHelper.putWheres(wheres, sql);
		return session.createNativeQuery(sql, EstimateItemModel.class).getResultList();
	}

	public void deleteAllByEstimateId(int purchaseOrderId)
	{

		orderJournalDao.deleteAllVoucherItemIds(purchaseOrderId);

		String sql = String.format("DELETE FROM %s", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add(String.format("estimate_id=%s", purchaseOrderId));

		sql = SqlHelper.putWheres(wheres, sql);

		session.createNativeQuery(sql).executeUpdate();
	}

	//
	public String getTableName()
	{
		return tableName;
	}

}
