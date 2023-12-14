package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.SalesChannelReqDto;
import com.hemsw.asasaapi.veenal.model.gen.SalesChannelModel;

public class SalesChannelMapper
{

	public static SalesChannelModel toSalesChannelModel(SalesChannelReqDto leadStatusReqDto)
	{
		SalesChannelModel leadStatusModel = new SalesChannelModel();
		leadStatusModel.setName(leadStatusReqDto.getName());
		return leadStatusModel;
	}
}
