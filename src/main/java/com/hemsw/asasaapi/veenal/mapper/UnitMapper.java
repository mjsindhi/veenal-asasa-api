package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.UnitDto;
import com.hemsw.asasaapi.veenal.dto.req.UnitReqDto;
import com.hemsw.asasaapi.veenal.model.gen.UnitModel;

public class UnitMapper
{
	
	public static UnitDto toUnitDto(UnitModel unitModel)
	{
		return new UnitDto()
				.setId(unitModel.getId())
				.setName(unitModel.getName());
	}
	
	public static UnitModel toUnitModel(UnitReqDto unitReqDto)
	{
		UnitModel unitModel = new UnitModel()
				.setName(unitReqDto.getName())
				.setCode(unitReqDto.getCode())
				.setDerived(unitReqDto.getIsDerived());
		
		if (unitModel.isDerived())
		{
			unitModel
					.setBaseUnitId(unitReqDto.getBaseUnitId())
					.setOperatorId(unitReqDto.getOperatorId())
					.setNum(unitReqDto.getQty());
		}
		return unitModel;
	}
}
