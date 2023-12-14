package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.TransporterReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.TransporterMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.TransporterModel;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import com.hemsw.asasaapi.veenal.dto.ldto.TransporterLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TransporterSer
{

	@Autowired
	private TransporterDao transporterDao;

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

		if (transporterDao.isNameExists(transporterReqDto.getName()))
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
		transporterDao.create(transporterModel);

		return new CommonUpsertResDto(transporterModel.getId());

	}

	@Transactional
	public CommonGetResDto<List<TransporterLdto>> getLdtos(String name, String transporterId)
	{
		try
		{
			List<TransporterLdto> data = null;
			data = transporterDao.getLdtos(name, transporterId);
			return new CommonGetResDto(data);
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonGetResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonGetResDto(ex, ex2);
			}
		}
	}
}
