package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.FulfillmentStatusReqDto;
import com.hemsw.asasaapi.veenal.dto.res.FulfillmentStatusResDto;
import com.hemsw.asasaapi.veenal.model.gen.FulfillmentStatusModel;

public class FulfillmentStatusMapper
{

	public static FulfillmentStatusModel toFulfillmentStatusModel(FulfillmentStatusReqDto fulfillmentStatusReqDto)
	{
		FulfillmentStatusModel fulfillmentStatusModel = new FulfillmentStatusModel();
		fulfillmentStatusModel.setName(fulfillmentStatusReqDto.getName());
		return fulfillmentStatusModel;
	}

	public static void toFulfillmentStatusModel(
			FulfillmentStatusModel fulfillmentStatusModel,
			FulfillmentStatusReqDto fulfillmentStatusReqDto
	)
	{
		fulfillmentStatusModel.setName(fulfillmentStatusReqDto.getName());
	}

	public static FulfillmentStatusResDto toFulfillmentStatusResDto(FulfillmentStatusModel fulfillmentStatusModel)
	{
		return new FulfillmentStatusResDto(fulfillmentStatusModel.getName());
	}
}
