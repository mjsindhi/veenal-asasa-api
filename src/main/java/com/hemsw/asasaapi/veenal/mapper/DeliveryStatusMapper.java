package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.DeliveryStatusReqDto;
import com.hemsw.asasaapi.veenal.dto.res.DeliveryStatusResDto;
import com.hemsw.asasaapi.veenal.model.gen.DeliveryStatusModel;

public class DeliveryStatusMapper
{

	public static DeliveryStatusModel toDeliveryStatusModel(DeliveryStatusReqDto deliveryStatusReqDto)
	{
		DeliveryStatusModel deliveryStatusModel = new DeliveryStatusModel();
		deliveryStatusModel.setName(deliveryStatusReqDto.getName());
		return deliveryStatusModel;
	}

	public static void toDeliveryStatusModel(
			DeliveryStatusModel deliveryStatusModel,
			DeliveryStatusReqDto deliveryStatusReqDto
	)
	{
		deliveryStatusModel.setName(deliveryStatusReqDto.getName());
	}

	public static DeliveryStatusResDto toDeliveryStatusResDto(DeliveryStatusModel deliveryStatusModel)
	{
		return new DeliveryStatusResDto(deliveryStatusModel.getName());
	}
}
