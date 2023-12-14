package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.EstimateReqDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;

public class EstimateMapper
{

	public static EstimateModel toEstimateModel(EstimateReqDto estimateReqDto)
	{
		EstimateModel estimateModel = new EstimateModel();
		estimateModel.setCustomerId(estimateReqDto.getCustomerId());
		estimateModel.setIsIntra(estimateReqDto.isIsIntra());
		estimateModel.setTransporterId(estimateReqDto.getTransporterId());
		estimateModel.setIsTax(estimateReqDto.isIsTax());
		estimateModel.setNote(estimateReqDto.getNote());
		estimateModel.setStatusId(estimateReqDto.getStatusId());
		estimateModel.setPaymentModeId(estimateReqDto.getPaymentModeId());
		estimateModel.setPaymentTermId(estimateReqDto.getPaymentTermId());
		estimateModel.setSalesChannelId(estimateReqDto.getSalesChannelId());
		estimateModel.setTradeTermId(estimateReqDto.getTradeTermId());
		estimateModel.setCurrencyId(estimateReqDto.getCurrencyId());
		estimateModel.setCurrencyConversionRate(estimateReqDto.getCurrencyConversionRate());
		estimateModel.setLockStockForDays(estimateReqDto.getLockStatusForDays());
		return estimateModel;
	}
}
