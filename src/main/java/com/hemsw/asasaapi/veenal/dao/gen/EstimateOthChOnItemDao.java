package com.hemsw.asasaapi.veenal.dao.gen;

import com.hemsw.asasaapi.veenal.SqlHelper;
import com.hemsw.asasaapi.veenal.TableName;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChOnItemModel;
import com.hemsw.asasaapi.veenal.util.Util;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstimateOthChOnItemDao //extends BaseDao<SalesOthChargeModel>
{

	@Autowired
	private EntityManager session;

	@Autowired
	private ColSettingDao colSettingDao;

	String tableName = "estimate_oth_charge_on_item";
	String sqlDeleteByEstimateId = "DELETE FROM %s WHERE estimate_id = %s;";

	public String getTableName()
	{
		return tableName;
	}

	public List<EstimateOthChOnItemModel> get(int estimateId, Integer othChId, boolean isSystem)
	{
		String sql = String.format("SELECT \n"
				+ "	{table_estimate_oth_charge_on_item}.*\n"
				+ "FROM\n"
				+ "	{table_estimate_oth_charge_on_item}\n"
				+ "LEFT JOIN\n"
				+ "	{table_oth_charge}\n"
				+ "ON\n"
				+ "	{table_estimate_oth_charge_on_item}.oth_charge_id = {table_oth_charge}.id", tableName);

		List<String> wheres = new ArrayList<>();
		wheres.add("{table_estimate_oth_charge_on_item}.estimate_id=" + estimateId);

		if (othChId != null)
		{
			wheres.add("{table_estimate_oth_charge_on_item}.oth_charge_id=" + othChId.toString());
		}

		wheres.add("{table_oth_charge}.id" + (isSystem ? "<= 100" : " > 100"));
		sql = SqlHelper.putWheres(wheres, sql);

		Map<String, String> map = new HashMap<>();
		map.put("table_estimate_oth_charge_on_item", tableName);
		map.put("table_oth_charge", TableName.VOU_OTH_CH);

		sql = Util.formatString(sql, map);

		return session.createNativeQuery(sql, EstimateOthChOnItemModel.class).getResultList();
	}

	public void save(EstimateModel estimateModel, List<EstimateOthChOnItemModel> estimateOthChargeModels)
	{
		String sql = String.format(sqlDeleteByEstimateId, tableName, estimateModel.getVoucherModel().getId());
		session.createNativeQuery(sql).executeUpdate();

		for (EstimateOthChOnItemModel estimateOthChargeModel : estimateOthChargeModels)
		{
			estimateOthChargeModel.setEstimateModel(estimateModel);
			session.persist(estimateOthChargeModel);
		}
	}
}
