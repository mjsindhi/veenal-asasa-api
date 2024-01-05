package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.PaymentStatusReqDto;
import com.hemsw.asasaapi.veenal.dto.res.PaymentStatusResDto;
import com.hemsw.asasaapi.veenal.model.gen.PaymentStatusModel;

public class PaymentStatusMapper
{

	public static PaymentStatusModel toPaymentStatusModel(PaymentStatusReqDto paymentStatusReqDto)
	{
		PaymentStatusModel paymentStatusModel = new PaymentStatusModel();
		paymentStatusModel.setName(paymentStatusReqDto.getName());
		return paymentStatusModel;
	}

	public static void toPaymentStatusModel(
			PaymentStatusModel paymentStatusModel,
			PaymentStatusReqDto paymentStatusReqDto
	)
	{
		paymentStatusModel.setName(paymentStatusReqDto.getName());
	}

	public static PaymentStatusResDto toPaymentStatusResDto(PaymentStatusModel paymentStatusModel)
	{
		return new PaymentStatusResDto(paymentStatusModel.getName());
	}
}
