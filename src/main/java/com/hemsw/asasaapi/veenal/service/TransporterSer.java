package com.hemsw.asasaapi.veenal.service;

import com.hemsw.asasaapi.veenal.dto.req.TransporterReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.TransporterMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.TransporterModel;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransporterSer
{

	@Autowired
	private TransporterDao transporterRepoImpl;

	public CommonUpsertResDto create(TransporterReqDto transporterReqDto, UserModel userModel)
	{
		if (transporterReqDto == null
				|| transporterReqDto.getName() == null
				|| transporterReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (transporterRepoImpl.isNameExists(transporterReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		TransporterModel transporterModel = TransporterMapper.toTransporterModel(transporterReqDto);
		transporterModel.setCreatedByUserId(userModel.getId());
		transporterRepoImpl.create(transporterModel);

		return new CommonUpsertResDto(transporterModel.getId());

	}

}
