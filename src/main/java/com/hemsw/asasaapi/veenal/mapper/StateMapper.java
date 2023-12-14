package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.StateReqDto;
import com.hemsw.asasaapi.veenal.model.gen.StateModel;

public class StateMapper
{

	public static StateModel toStateModel(StateReqDto stateReqDto)
	{
		StateModel stateModel = new StateModel();
		stateModel.setName(stateReqDto.getName());
		stateModel.setCodeName(stateReqDto.getCodeName());
		stateModel.setCodeNo(stateReqDto.getCodeNo());
		stateModel.setCountryId(stateReqDto.getCountryId());
		return stateModel;
	}
}
