package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.EstimateOthChOnItemReqDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChOnItemModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateOthChOnItemMapper
{

	public static EstimateOthChOnItemModel toEstimateOthChOnItemModel(EstimateOthChOnItemReqDto estimateOthChOnItemReqDto)
	{
		EstimateOthChOnItemModel estimateOthChOnItemModel = new EstimateOthChOnItemModel();
		estimateOthChOnItemModel.setOthChargeId(estimateOthChOnItemReqDto.getOthChId());
		estimateOthChOnItemModel.setRate(estimateOthChOnItemReqDto.getRate());
		estimateOthChOnItemModel.setRateTypeId(estimateOthChOnItemReqDto.getRateTypeId());
		return estimateOthChOnItemModel;
	}

	public static List<EstimateOthChOnItemModel> toEstimateOthChOnItemModels(List<EstimateOthChOnItemReqDto> estimateOthChOnItemReqDtos)
	{
		List<EstimateOthChOnItemModel> estimateOthChOnItemModels = new ArrayList<>();

		if (estimateOthChOnItemReqDtos != null)
		{
			for (EstimateOthChOnItemReqDto estimateItemReqDto : estimateOthChOnItemReqDtos)
			{
				estimateOthChOnItemModels.add(toEstimateOthChOnItemModel(estimateItemReqDto));
			}
		}

		return estimateOthChOnItemModels;
	}
}
