package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateOthChTaxableRrDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChTaxableModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateOthChTaxableMapper
{

	public static EstimateOthChTaxableModel toEstimateOthChTaxableModel(EstimateOthChTaxableRrDto estimateOthChTaxableReqDto)
	{
		EstimateOthChTaxableModel estimateOthChTaxableModel = new EstimateOthChTaxableModel();
		estimateOthChTaxableModel.setOthChargeId(estimateOthChTaxableReqDto.getOthChId());
		estimateOthChTaxableModel.setRate(estimateOthChTaxableReqDto.getRate());
		estimateOthChTaxableModel.setRateTypeId(estimateOthChTaxableReqDto.getRateTypeId());
		estimateOthChTaxableModel.setTaxId(estimateOthChTaxableReqDto.getTaxId());
		return estimateOthChTaxableModel;
	}

	public static List<EstimateOthChTaxableModel> toEstimateOthChTaxableModels(List<EstimateOthChTaxableRrDto> estimateOthChTaxableReqDtos)
	{
		List<EstimateOthChTaxableModel> estimateOthChTaxableModels = new ArrayList<>();

		if (estimateOthChTaxableReqDtos != null)
		{
			for (EstimateOthChTaxableRrDto estimateOthChTaxableReqDto : estimateOthChTaxableReqDtos)
			{
				estimateOthChTaxableModels.add(toEstimateOthChTaxableModel(estimateOthChTaxableReqDto));
			}
		}

		return estimateOthChTaxableModels;
	}

	public static EstimateOthChTaxableRrDto toEstimateOthChTaxableRrDtos(EstimateOthChTaxableModel estimateOthChTaxableModel)
	{
		EstimateOthChTaxableRrDto estimateOthChTaxableRrDto = new EstimateOthChTaxableRrDto();
		estimateOthChTaxableRrDto.setOthChId(estimateOthChTaxableModel.getOthChargeId());
		estimateOthChTaxableRrDto.setRate(estimateOthChTaxableModel.getRate());
		estimateOthChTaxableRrDto.setRateTypeId(estimateOthChTaxableModel.getRateTypeId());
		estimateOthChTaxableRrDto.setTaxId(estimateOthChTaxableModel.getTaxId());
		return estimateOthChTaxableRrDto;
	}

	public static List<EstimateOthChTaxableRrDto> toEstimateOthChTaxableRrDtos(List<EstimateOthChTaxableModel> estimateOthChTaxableModels)
	{
		List<EstimateOthChTaxableRrDto> estimateOthChTaxableRrDtos = new ArrayList<>();

		if (estimateOthChTaxableModels != null)
		{
			for (EstimateOthChTaxableModel estimateOthChTaxableModel : estimateOthChTaxableModels)
			{
				estimateOthChTaxableRrDtos.add(toEstimateOthChTaxableRrDtos(estimateOthChTaxableModel));
			}
		}

		return estimateOthChTaxableRrDtos;
	}
}
