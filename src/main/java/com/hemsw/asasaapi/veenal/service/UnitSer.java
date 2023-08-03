package com.hemsw.asasaapi.veenal.service;

import com.hemsw.asasaapi.veenal.dto.req.UnitReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.UnitMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.UnitModel;
import com.hemsw.asasaapi.veenal.dao.gen.UnitRepoImpl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitSer
{

	@Autowired
	private UnitRepoImpl unitRepoImpl;

	public CommonUpsertResDto create(UnitReqDto unitReqDto, UserModel userModel)
	{
		if (unitReqDto == null
				|| unitReqDto.getName() == null
				|| unitReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (unitReqDto.getCode() == null
				|| unitReqDto.getCode().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"code_required",
					"Enter code",
					"Enter code"
			));
		}

		if (unitReqDto.getIsDerived() == null)
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"is_derived_required",
					"Select if unit is derived or not",
					"Select if unit is derived or not"
			));
		}

		if (unitReqDto.getIsDerived() == true)
		{

			if (unitReqDto.getBaseUnitId() == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"base_unit_required",
						"Select base unit",
						"Select base unit"
				));
			}

			if (unitReqDto.getOperatorId() == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"operator_required",
						"Select opeator",
						"Select opeator"
				));
			}

			if (unitReqDto.getQty() == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"base_unit_qty_required",
						"Enter base unit quantity",
						"Enter base unit quantity"
				));
			}
		}

		if (unitRepoImpl.isNameExists(unitReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		if (unitRepoImpl.isCodeExists(unitReqDto.getCode()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"code_exists",
					"Code already exists",
					"Code already exists"
			));
		}

		if (unitReqDto.getIsDerived() == true)
		{
			if (!unitRepoImpl.isIdExists(unitReqDto.getBaseUnitId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_base_unit",
						"Invalid base unit",
						"Invalid base unit"
				));
			}

			if (unitReqDto.getOperatorId() != 1 && unitReqDto.getOperatorId() != 2)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_operator",
						"Invalid operator",
						"Invalid operator"
				));
			}
		}

		UnitModel unitModel = UnitMapper.toUnitModel(unitReqDto);
		unitModel.setCreatedByUserId(userModel.getId());
		unitRepoImpl.create(unitModel);

		return new CommonUpsertResDto(unitModel.getId());

	}

}
