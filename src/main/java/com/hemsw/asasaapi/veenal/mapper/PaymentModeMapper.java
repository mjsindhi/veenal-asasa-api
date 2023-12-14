package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.PaymentModeReqDto;
import com.hemsw.asasaapi.veenal.model.gen.PaymentModeModel;

public class PaymentModeMapper
{

	public static PaymentModeModel toPaymentModeModel(PaymentModeReqDto leadStatusReqDto)
	{
		PaymentModeModel leadStatusModel = new PaymentModeModel();
		leadStatusModel.setName(leadStatusReqDto.getName());
		return leadStatusModel;
	}
}
