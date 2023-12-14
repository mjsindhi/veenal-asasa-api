package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.EstimateOthChNonTaxableReqDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChModel;
import java.util.ArrayList;
import java.util.List;

public class EstimateOthChNonTaxableMapper
{

	public static EstimateOthChModel toEstimateOthChNonTaxableModel(EstimateOthChNonTaxableReqDto estimateOthChNonTaxableReqDto)
	{
		EstimateOthChModel estimateOthChModel = new EstimateOthChModel();
		estimateOthChModel.setOthChargeId(estimateOthChNonTaxableReqDto.getOthChId());
		estimateOthChModel.setRate(estimateOthChNonTaxableReqDto.getRate());
		estimateOthChModel.setRateTypeId(estimateOthChNonTaxableReqDto.getRateTypeId());
		return estimateOthChModel;
	}

	public static List<EstimateOthChModel> toEstimateOthChNonTaxableModels(List<EstimateOthChNonTaxableReqDto> estimateOthChNonTaxableReqDtos)
	{
		List<EstimateOthChModel> estimateOthChNonTaxableModels = new ArrayList<>();

		if (estimateOthChNonTaxableReqDtos != null)
		{
			for (EstimateOthChNonTaxableReqDto estimateOthChNonTaxableReqDto : estimateOthChNonTaxableReqDtos)
			{
				estimateOthChNonTaxableModels.add(toEstimateOthChNonTaxableModel(estimateOthChNonTaxableReqDto));
			}
		}

		return estimateOthChNonTaxableModels;
	}
}
