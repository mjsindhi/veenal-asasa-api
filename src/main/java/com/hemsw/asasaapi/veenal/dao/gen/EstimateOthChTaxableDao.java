package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChTaxableModel;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstimateOthChTaxableDao //extends BaseDao<EstimateOthChargeTaxableModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	String tableName = "estimate_oth_charge_taxable";
	String sqlDeleteByEstimateId = "DELETE FROM %s WHERE estimate_id = %s;";

	public String getTableName()
	{
		return tableName;
	}

	public List<EstimateOthChTaxableModel> get(int estimateId)
	{
		String sql = String.format("SELECT * FROM %s", tableName);
		List<String> wheres = new ArrayList<>();
		wheres.add(tableName + ".estimate_id=" + estimateId);
		sql = SqlHelper.putWheres(wheres, sql);
		return session.createNativeQuery(sql, EstimateOthChTaxableModel.class).getResultList();
	}

	public void save(EstimateModel estimateModel, List<EstimateOthChTaxableModel> estimateOthChargeTaxableModels)
	{
		String sql = String.format(sqlDeleteByEstimateId, tableName, estimateModel.getVoucherModel().getId());
		session.createNativeQuery(sql).executeUpdate();

		for (EstimateOthChTaxableModel estimateOthChargeTaxableModel : estimateOthChargeTaxableModels)
		{
			estimateOthChargeTaxableModel.setEstimateModel(estimateModel);
			session.persist(estimateOthChargeTaxableModel);
		}
	}
}
