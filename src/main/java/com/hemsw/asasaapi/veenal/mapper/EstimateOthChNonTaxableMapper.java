package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateOthChNonTaxableRrDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateOthChNonTaxableMapper
{

	public static EstimateOthChModel toEstimateOthChNonTaxableModel(EstimateOthChNonTaxableRrDto estimateOthChNonTaxableReqDto)
	{
		EstimateOthChModel estimateOthChModel = new EstimateOthChModel();
		estimateOthChModel.setOthChargeId(estimateOthChNonTaxableReqDto.getOthChId());
		estimateOthChModel.setRate(estimateOthChNonTaxableReqDto.getRate());
		estimateOthChModel.setRateTypeId(estimateOthChNonTaxableReqDto.getRateTypeId());
		return estimateOthChModel;
	}

	public static List<EstimateOthChModel> toEstimateOthChNonTaxableModels(List<EstimateOthChNonTaxableRrDto> estimateOthChNonTaxableReqDtos)
	{
		List<EstimateOthChModel> estimateOthChNonTaxableModels = new ArrayList<>();

		if (estimateOthChNonTaxableReqDtos != null)
		{
			for (EstimateOthChNonTaxableRrDto estimateOthChNonTaxableReqDto : estimateOthChNonTaxableReqDtos)
			{
				estimateOthChNonTaxableModels.add(toEstimateOthChNonTaxableModel(estimateOthChNonTaxableReqDto));
			}
		}

		return estimateOthChNonTaxableModels;
	}

	public static EstimateOthChNonTaxableRrDto toEstimateOthChNonTaxableRrDto(EstimateOthChModel estimateOthChModel)
	{
		EstimateOthChNonTaxableRrDto estimateOthChNonTaxableRrDto = new EstimateOthChNonTaxableRrDto();
		estimateOthChNonTaxableRrDto.setOthChId(estimateOthChModel.getOthChargeId());
		estimateOthChNonTaxableRrDto.setRate(estimateOthChModel.getRate());
		estimateOthChNonTaxableRrDto.setRateTypeId(estimateOthChModel.getRateTypeId());
		return estimateOthChNonTaxableRrDto;
	}

	public static List<EstimateOthChNonTaxableRrDto> toEstimateOthChNonTaxableRrDtos(List<EstimateOthChModel> estimateOthChModels)
	{
		List<EstimateOthChNonTaxableRrDto> estimateOthChNonTaxableRrDto = new ArrayList<>();

		if (estimateOthChModels != null)
		{
			for (EstimateOthChModel estimateOthChModel : estimateOthChModels)
			{
				estimateOthChNonTaxableRrDto.add(toEstimateOthChNonTaxableRrDto(estimateOthChModel));
			}
		}

		return estimateOthChNonTaxableRrDto;
	}

}
