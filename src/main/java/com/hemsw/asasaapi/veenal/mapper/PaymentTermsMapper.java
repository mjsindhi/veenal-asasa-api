package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.PaymentTermsReqDto;
import com.hemsw.asasaapi.veenal.model.gen.PaymentTermsModel;

public class PaymentTermsMapper
{

	public static PaymentTermsModel toPaymentTermsModel(PaymentTermsReqDto leadStatusReqDto)
	{
		PaymentTermsModel paymentTermsModel = new PaymentTermsModel();
		paymentTermsModel.setName(leadStatusReqDto.getName());
		paymentTermsModel.setValue(leadStatusReqDto.getValue());
		return paymentTermsModel;
	}
}
