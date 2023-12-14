package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.LeadSrcReqDto;
import com.hemsw.asasaapi.veenal.model.gen.LeadSrcModel;

public class LeadSrcMapper
{

	public static LeadSrcModel toLeadSrcModel(LeadSrcReqDto leadStatusReqDto)
	{
		LeadSrcModel leadStatusModel = new LeadSrcModel();
		leadStatusModel.setName(leadStatusReqDto.getName());
		return leadStatusModel;
	}
}
