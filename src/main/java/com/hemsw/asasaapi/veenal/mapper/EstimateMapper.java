package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.rr.EstimateRrDto;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;

public class EstimateMapper
{

	public static EstimateModel toEstimateModel(EstimateRrDto estimateReqDto)
	{
		EstimateModel estimateModel = new EstimateModel();
		toEstimateModel(estimateModel, estimateReqDto);
		return estimateModel;
	}

	public static void toEstimateModel(EstimateModel estimateModel, EstimateRrDto estimateReqDto)
	{
		estimateModel.setCustomerId(estimateReqDto.getCustomerId());
		estimateModel.setName(estimateReqDto.getName());
		estimateModel.setAddress(estimateReqDto.getAddress());
		estimateModel.setCity(estimateReqDto.getCity());
		estimateModel.setStateId(estimateReqDto.getStateId());
		estimateModel.setCountryId(estimateReqDto.getCountryId());
		estimateModel.setPin(estimateReqDto.getPin());
		estimateModel.setEmail(estimateReqDto.getEmail());
		estimateModel.setContactNo(estimateReqDto.getContactNo());
		estimateModel.setIsShippingSameAsBilling(estimateReqDto.isIsShippingSameAsBilling());
		estimateModel.setShippingName(estimateReqDto.getShippingName());
		estimateModel.setShippingAddress(estimateReqDto.getShippingAddress());
		estimateModel.setShippingCity(estimateReqDto.getShippingCity());
		estimateModel.setShippingStateId(estimateReqDto.getShippingStateId());
		estimateModel.setShippingCountryId(estimateReqDto.getShippingCountryId());
		estimateModel.setShippingPin(estimateReqDto.getShippingPin());
		estimateModel.setShippingEmail(estimateReqDto.getShippingEmail());
		estimateModel.setShippingContactNo(estimateReqDto.getShippingContactNo());
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
		estimateModel.setLockStockForDays(estimateReqDto.getLockStockForDays());
		estimateModel.setIsLut(estimateReqDto.isIsLut());
	}

	public static EstimateRrDto toEstimateRrDto(EstimateModel estimateModel)
	{
		EstimateRrDto estimateRrDto = new EstimateRrDto();
		estimateRrDto.setCustomerId(estimateModel.getCustomerId());
		estimateRrDto.setName(estimateModel.getName());
		estimateRrDto.setAddress(estimateModel.getAddress());
		estimateRrDto.setCity(estimateModel.getCity());
		estimateRrDto.setStateId(estimateModel.getStateId());
		estimateRrDto.setCountryId(estimateModel.getCountryId());
		estimateRrDto.setPin(estimateModel.getPin());
		estimateRrDto.setEmail(estimateModel.getEmail());
		estimateRrDto.setContactNo(estimateModel.getContactNo());
		estimateRrDto.setIsShippingSameAsBilling(estimateModel.isIsShippingSameAsBilling());
		estimateRrDto.setShippingName(estimateModel.getShippingName());
		estimateRrDto.setShippingAddress(estimateModel.getShippingAddress());
		estimateRrDto.setShippingCity(estimateModel.getShippingCity());
		estimateRrDto.setShippingStateId(estimateModel.getShippingStateId());
		estimateRrDto.setShippingCountryId(estimateModel.getShippingCountryId());
		estimateRrDto.setShippingPin(estimateModel.getShippingPin());
		estimateRrDto.setShippingEmail(estimateModel.getShippingEmail());
		estimateRrDto.setShippingContactNo(estimateModel.getShippingContactNo());
		estimateRrDto.setIsIntra(estimateModel.isIsIntra());
		estimateRrDto.setTransporterId(estimateModel.getTransporterId());
		estimateRrDto.setIsTax(estimateModel.isIsTax());
		estimateRrDto.setNote(estimateModel.getNote());
		estimateRrDto.setStatusId(estimateModel.getStatusId());
		estimateRrDto.setPaymentModeId(estimateModel.getPaymentModeId());
		estimateRrDto.setPaymentTermId(estimateModel.getPaymentTermId());
		estimateRrDto.setSalesChannelId(estimateModel.getSalesChannelId());
		estimateRrDto.setTradeTermId(estimateModel.getTradeTermId());
		estimateRrDto.setCurrencyId(estimateModel.getCurrencyId());
		estimateRrDto.setCurrencyConversionRate(estimateModel.getCurrencyConversionRate());
		estimateRrDto.setLockStockForDays(estimateModel.getLockStockForDays());
		estimateRrDto.setIsLut(estimateModel.isIsLut());
		return estimateRrDto;
	}

	public static void toEstimateRrDto(EstimateRrDto estimateRrDto, VoucherModel voucherModel)
	{
		estimateRrDto.setDate(voucherModel.getDate());
		estimateRrDto.setNo(voucherModel.getNo());
	}

}
