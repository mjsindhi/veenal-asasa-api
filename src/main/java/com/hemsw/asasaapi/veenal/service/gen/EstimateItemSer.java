package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.EstimateItemDao;
import com.hemsw.asasaapi.veenal.dao.gen.GoodsJournalDao;
import com.hemsw.asasaapi.veenal.model.gen.EstimateItemModel;
import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstimateItemSer //extends BaseSer<EstimateItemModel>
{

	@Autowired
	GoodsJournalDao goodsJournalDao;

	@Autowired
	EstimateItemDao estimateItemDao;

	public boolean checkIsValidCreate(EstimateItemModel estimateItem, StringBuilder errorMsg)
	{
		if (!checkIsValid(estimateItem, errorMsg))
		{
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(EstimateItemModel estimateItem, StringBuilder errorMsg)
	{
		if (!checkIsValid(estimateItem, errorMsg))
		{
			return false;
		}

		return true;
	}

	public boolean checkIsValid(EstimateItemModel estimateItem, StringBuilder errorMsg)
	{

		if (estimateItem == null)
		{
			errorMsg.append("EstimateItem dto is null");
			return false;
		}

		return true;
	}

	@Transactional
	public EstimateItemModel getById(int id)
	{
		EstimateItemModel estimateItemitemModel = null;
		estimateItemitemModel = estimateItemDao.getById(id);

		return estimateItemitemModel;
	}

	public Map<Integer, EstimateItemModel> getMapByEstimateId(int estimateId)
	{
		Map<Integer, EstimateItemModel> data = new HashMap<>();
		List<EstimateItemModel> estimateitemModels = estimateItemDao.getByEstimateId(estimateId);
		for (EstimateItemModel estimateitemModel : estimateitemModels)
		{
			data.put(estimateitemModel.getId(), estimateitemModel);
		}

		return data;
	}

}
