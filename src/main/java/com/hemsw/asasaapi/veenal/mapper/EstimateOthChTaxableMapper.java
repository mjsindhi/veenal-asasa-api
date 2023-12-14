package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.EstimateOthChTaxableReqDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChTaxableModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateOthChTaxableMapper
{

	public static EstimateOthChTaxableModel toEstimateOthChTaxableModel(EstimateOthChTaxableReqDto estimateOthChTaxableReqDto)
	{
		EstimateOthChTaxableModel estimateOthChTaxableModel = new EstimateOthChTaxableModel();
		estimateOthChTaxableModel.setOthChargeId(estimateOthChTaxableReqDto.getOthChId());
		estimateOthChTaxableModel.setRate(estimateOthChTaxableReqDto.getRate());
		estimateOthChTaxableModel.setRateTypeId(estimateOthChTaxableReqDto.getRateTypeId());
		estimateOthChTaxableModel.setTaxId(estimateOthChTaxableReqDto.getTaxId());
		return estimateOthChTaxableModel;
	}

	public static List<EstimateOthChTaxableModel> toEstimateOthChTaxableModels(List<EstimateOthChTaxableReqDto> estimateOthChTaxableReqDtos)
	{
		List<EstimateOthChTaxableModel> estimateOthChTaxableModels = new ArrayList<>();

		if (estimateOthChTaxableReqDtos != null)
		{
			for (EstimateOthChTaxableReqDto estimateOthChTaxableReqDto : estimateOthChTaxableReqDtos)
			{
				estimateOthChTaxableModels.add(toEstimateOthChTaxableModel(estimateOthChTaxableReqDto));
			}
		}

		return estimateOthChTaxableModels;
	}
}
