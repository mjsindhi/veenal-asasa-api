package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.TransporterReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.TransporterMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.TransporterModel;
import com.hemsw.asasaapi.veenal.dao.gen.TransporterDao;
import com.hemsw.asasaapi.veenal.dto.ldto.TransporterLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.TransporterResDto;
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

	@Transactional
	public CommonUpsertResDto create(TransporterReqDto transporterReqDto, UserModel userModel)
	{
		try
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
	public CommonUpsertResDto update(int id, TransporterReqDto transporterReqDto)
	{
		try
		{
			TransporterModel transporterModel = transporterDao.getById(id);
			if (transporterModel == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"id_invalid",
						"Id is invalid",
						"Id is invalid"
				));
			}

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

			TransporterModel transporterModelByName = transporterDao.getByName(transporterReqDto.getName());
			if (transporterModelByName != null && transporterModelByName.getId() != id)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			TransporterMapper.toTransporterModel(transporterModel, transporterReqDto);

			return new CommonUpsertResDto(transporterModel.getId());
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

	@Transactional
	public CommonGetOneResDto<TransporterResDto> getById(int id)
	{
		try
		{
			TransporterResDto data = null;
			data = TransporterMapper.toTransporterResDto(transporterDao.getById(id));

			return new CommonGetOneResDto(data);
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonGetOneResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonGetOneResDto(ex, ex2);
			}
		}
	}

	@Transactional
	public CommonDeleteResDto delete(int id)
	{
		try
		{
			transporterDao.delete(id);

			return new CommonDeleteResDto();
		}
		catch (Exception ex)
		{
			try
			{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return new CommonDeleteResDto(ex);
			}
			catch (Exception ex2)
			{
				return new CommonDeleteResDto(ex, ex2);
			}
		}
	}
}
