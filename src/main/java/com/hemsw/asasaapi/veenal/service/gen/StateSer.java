package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.StateReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.StateMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.StateModel;
import com.hemsw.asasaapi.veenal.dao.gen.StateDao;
import com.hemsw.asasaapi.veenal.dto.ldto.StateLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class StateSer
{

	@Autowired
	private StateDao stateDao;

	@Transactional
	public CommonUpsertResDto create(StateReqDto stateReqDto, UserModel userModel)
	{
		try
		{
			if (stateReqDto == null
					|| stateReqDto.getName() == null
					|| stateReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (stateDao.isNameExists(stateReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			if (stateDao.isCodeNameExists(stateReqDto.getCodeName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"code_name_exists",
						"Code name already exists",
						"Code name already exists"
				));
			}
			if (stateDao.isCodeNoExists(stateReqDto.getCodeNo()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"code_no_exists",
						"Code no already exists",
						"Code no already exists"
				));
			}

			StateModel stateModel = StateMapper.toStateModel(stateReqDto);
			stateModel.setCreatedByUserId(userModel.getId());
			stateDao.create(stateModel);

			return new CommonUpsertResDto(stateModel.getId());
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonUpsertResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonUpsertResDto(ex, ex2);
			}
		}

	}

	@Transactional
	public CommonGetResDto<List<StateLdto>> getLdtos(String name, Integer countryId)
	{
		try
		{

			List<StateLdto> data = stateDao.getLdtos(name, countryId);
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
