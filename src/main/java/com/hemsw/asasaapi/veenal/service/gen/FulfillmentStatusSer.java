package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.FulfillmentStatusReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.FulfillmentStatusMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.FulfillmentStatusModel;
import com.hemsw.asasaapi.veenal.dao.gen.FulfillmentStatusDao;
import com.hemsw.asasaapi.veenal.dto.ldto.FulfillmentStatusLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.FulfillmentStatusResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class FulfillmentStatusSer
{

	@Autowired
	private FulfillmentStatusDao fulfillmentStatusDao;

	@Transactional
	public CommonUpsertResDto create(FulfillmentStatusReqDto fulfillmentStatusReqDto, UserModel userModel)
	{
		try
		{
			if (fulfillmentStatusReqDto == null
					|| fulfillmentStatusReqDto.getName() == null
					|| fulfillmentStatusReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (fulfillmentStatusDao.isNameExists(fulfillmentStatusReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			FulfillmentStatusModel fulfillmentStatusModel = FulfillmentStatusMapper.toFulfillmentStatusModel(fulfillmentStatusReqDto);
			fulfillmentStatusModel.setCreatedByUserId(userModel.getId());
			fulfillmentStatusDao.create(fulfillmentStatusModel);

			return new CommonUpsertResDto(fulfillmentStatusModel.getId());
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
	public CommonUpsertResDto update(int id, FulfillmentStatusReqDto fulfillmentStatusReqDto)
	{
		try
		{
			FulfillmentStatusModel fulfillmentStatusModel = fulfillmentStatusDao.getById(id);
			if (fulfillmentStatusModel == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"id_invalid",
						"Id is invalid",
						"Id is invalid"
				));
			}

			if (fulfillmentStatusReqDto == null
					|| fulfillmentStatusReqDto.getName() == null
					|| fulfillmentStatusReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			FulfillmentStatusModel fulfillmentStatusModelByName = fulfillmentStatusDao.getByName(fulfillmentStatusReqDto.getName());
			if (fulfillmentStatusModelByName != null && fulfillmentStatusModelByName.getId() != id)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			FulfillmentStatusMapper.toFulfillmentStatusModel(fulfillmentStatusModel, fulfillmentStatusReqDto);

			return new CommonUpsertResDto(fulfillmentStatusModel.getId());
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
	public CommonGetResDto<List<FulfillmentStatusLdto>> getLdtos(String name, String fulfillmentStatusId)
	{
		try
		{
			List<FulfillmentStatusLdto> data = null;
			data = fulfillmentStatusDao.getLdtos(name, fulfillmentStatusId);
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
	public CommonGetOneResDto<FulfillmentStatusResDto> getById(int id)
	{
		try
		{
			FulfillmentStatusResDto data = null;
			data = FulfillmentStatusMapper.toFulfillmentStatusResDto(fulfillmentStatusDao.getById(id));

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
			fulfillmentStatusDao.delete(id);

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
