package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateItemRrDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateItemModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateItemMapper
{

	public static EstimateItemModel toEstimateItemModel(EstimateItemRrDto estimateItemReqDto)
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

	public static List<EstimateItemModel> toEstimateItemModels(List<EstimateItemRrDto> estimateItemReqDtos)
	{
		List<EstimateItemModel> estimateItemModels = new ArrayList<>();

		if (estimateItemReqDtos != null)
		{
			for (EstimateItemRrDto estimateItemReqDto : estimateItemReqDtos)
			{
				estimateItemModels.add(toEstimateItemModel(estimateItemReqDto));
			}
		}

		return estimateItemModels;
	}

	public static EstimateItemRrDto toEstimateItemRrDto(EstimateItemModel estimateItemModel)
	{
		EstimateItemRrDto estimateItemRrDto = new EstimateItemRrDto();
		estimateItemRrDto.setId(estimateItemModel.getId());
		estimateItemRrDto.setProductId(estimateItemModel.getProductId());
		estimateItemRrDto.setDesc(estimateItemModel.getDesc());
		estimateItemRrDto.setQty(estimateItemModel.getQty());
		estimateItemRrDto.setRate(estimateItemModel.getRate());
		estimateItemRrDto.setDiscRate(estimateItemModel.getDiscRate());
		estimateItemRrDto.setDiscRateTypeId(estimateItemModel.getDiscRateTypeId());
		return estimateItemRrDto;
	}

	public static List<EstimateItemRrDto> toEstimateItemRrDtos(List<EstimateItemModel> estimateItemModels)
	{
		List<EstimateItemRrDto> estimateItemRrDtos = new ArrayList<>();

		if (estimateItemModels != null)
		{
			for (EstimateItemModel estimateItemModel : estimateItemModels)
			{
				estimateItemRrDtos.add(toEstimateItemRrDto(estimateItemModel));
			}
		}

		return estimateItemRrDtos;
	}
}
