package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateOthChOnItemRrDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChOnItemModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateOthChOnItemMapper
{

	public static EstimateOthChOnItemModel toEstimateOthChOnItemModel(EstimateOthChOnItemRrDto estimateOthChOnItemRrDto)
	{
		EstimateOthChOnItemModel estimateOthChOnItemModel = new EstimateOthChOnItemModel();
		estimateOthChOnItemModel.setOthChargeId(estimateOthChOnItemRrDto.getOthChId());
		estimateOthChOnItemModel.setRate(estimateOthChOnItemRrDto.getRate());
		estimateOthChOnItemModel.setRateTypeId(estimateOthChOnItemRrDto.getRateTypeId());
		return estimateOthChOnItemModel;
	}

	public static List<EstimateOthChOnItemModel> toEstimateOthChOnItemModels(List<EstimateOthChOnItemRrDto> estimateOthChOnItemRrDtos)
	{
		List<EstimateOthChOnItemModel> estimateOthChOnItemModels = new ArrayList<>();

		if (estimateOthChOnItemRrDtos != null)
		{
			for (EstimateOthChOnItemRrDto estimateItemReqDto : estimateOthChOnItemRrDtos)
			{
				estimateOthChOnItemModels.add(toEstimateOthChOnItemModel(estimateItemReqDto));
			}
		}

		return estimateOthChOnItemModels;
	}

	public static EstimateOthChOnItemRrDto toEstimateOthChOnItemRrDto(EstimateOthChOnItemModel estimateOthChOnItemModel)
	{
		EstimateOthChOnItemRrDto estimateOthChOnItemRrDto = new EstimateOthChOnItemRrDto();
		estimateOthChOnItemRrDto.setOthChId(estimateOthChOnItemModel.getOthChargeId());
		estimateOthChOnItemRrDto.setRate(estimateOthChOnItemModel.getRate());
		estimateOthChOnItemRrDto.setRateTypeId(estimateOthChOnItemModel.getRateTypeId());
		return estimateOthChOnItemRrDto;
	}

	public static List<EstimateOthChOnItemRrDto> toEstimateOthChOnItemRrDtos(List<EstimateOthChOnItemModel> estimateOthChOnItemModels)
	{
		List<EstimateOthChOnItemRrDto> estimateOthChOnItemRrDtos = new ArrayList<>();

		if (estimateOthChOnItemModels != null)
		{
			for (EstimateOthChOnItemModel estimateItemReqDto : estimateOthChOnItemModels)
			{
				estimateOthChOnItemRrDtos.add(toEstimateOthChOnItemRrDto(estimateItemReqDto));
			}
		}

		return estimateOthChOnItemRrDtos;
	}
}
