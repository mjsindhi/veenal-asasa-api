package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.TransporterReqDto;
import com.hemsw.asasaapi.veenal.model.gen.TransporterModel;

public class TransporterMapper
{

	public static TransporterModel toTransporterModel(TransporterReqDto transporterReqDto)
	{
		return new TransporterModel()
				.setName(transporterReqDto.getName())
				.setTransporterId(transporterReqDto.getTransporterId());
	}
}
