package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.EstimateItemReqDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateItemModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateItemMapper
{

	public static EstimateItemModel toEstimateItemModel(EstimateItemReqDto estimateItemReqDto)
	{
		EstimateItemModel estimateItemModel = new EstimateItemModel();
		estimateItemModel.setId(estimateItemReqDto.getId());
		estimateItemModel.setProductId(estimateItemReqDto.getProductId());
		estimateItemModel.setDesc(estimateItemReqDto.getDesc());
		estimateItemModel.setQty(estimateItemReqDto.getQty());
		estimateItemModel.setRate(estimateItemReqDto.getRate());
		estimateItemModel.setDiscRate(estimateItemReqDto.getDiscRate());
		estimateItemModel.setDiscRateTypeId(estimateItemReqDto.getDiscRateTypeId());
		return estimateItemModel;
	}

	public static List<EstimateItemModel> toEstimateItemModels(List<EstimateItemReqDto> estimateItemReqDtos)
	{
		List<EstimateItemModel> estimateItemModels = new ArrayList<>();

		if (estimateItemReqDtos != null)
		{
			for (EstimateItemReqDto estimateItemReqDto : estimateItemReqDtos)
			{
				estimateItemModels.add(toEstimateItemModel(estimateItemReqDto));
			}
		}

		return estimateItemModels;
	}
}
