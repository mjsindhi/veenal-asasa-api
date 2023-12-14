package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstimateOthChDao //extends BaseDao<EstimateOthChargeModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	String tableName = "estimate_oth_charge";
	String sqlDeleteByEstimateId = "DELETE FROM %s WHERE estimate_id = %s;";

	public String getTableName()
	{
		return tableName;
	}

	public List<EstimateOthChModel> get(int estimateId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();
		wheres.add(tableName + ".estimate_id=" + estimateId);
		sql = SqlHelper.putWheres(wheres, sql);
		return session.createNativeQuery(sql, EstimateOthChModel.class).getResultList();
	}

	public void save(EstimateModel estimateModel, List<EstimateOthChModel> estimateOthChargeModels)
	{
		String sql = String.format(sqlDeleteByEstimateId, tableName, estimateModel.getVoucherModel().getId());
		session.createNativeQuery(sql).executeUpdate();

		for (EstimateOthChModel estimateOthChargeModel : estimateOthChargeModels)
		{
			estimateOthChargeModel.setEstimateModel(estimateModel);
			session.persist(estimateOthChargeModel);
		}
	}
}
