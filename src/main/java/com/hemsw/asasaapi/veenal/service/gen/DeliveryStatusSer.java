package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.DeliveryStatusReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.DeliveryStatusMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.DeliveryStatusModel;
import com.hemsw.asasaapi.veenal.dao.gen.DeliveryStatusDao;
import com.hemsw.asasaapi.veenal.dto.ldto.DeliveryStatusLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.DeliveryStatusResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class DeliveryStatusSer
{

	@Autowired
	private DeliveryStatusDao deliveryStatusDao;

	@Transactional
	public CommonUpsertResDto create(DeliveryStatusReqDto deliveryStatusReqDto, UserModel userModel)
	{
		try
		{
			if (deliveryStatusReqDto == null
					|| deliveryStatusReqDto.getName() == null
					|| deliveryStatusReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (deliveryStatusDao.isNameExists(deliveryStatusReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			DeliveryStatusModel deliveryStatusModel = DeliveryStatusMapper.toDeliveryStatusModel(deliveryStatusReqDto);
			deliveryStatusModel.setCreatedByUserId(userModel.getId());
			deliveryStatusDao.create(deliveryStatusModel);

			return new CommonUpsertResDto(deliveryStatusModel.getId());
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
	public CommonUpsertResDto update(int id, DeliveryStatusReqDto deliveryStatusReqDto)
	{
		try
		{
			DeliveryStatusModel deliveryStatusModel = deliveryStatusDao.getById(id);
			if (deliveryStatusModel == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"id_invalid",
						"Id is invalid",
						"Id is invalid"
				));
			}

			if (deliveryStatusReqDto == null
					|| deliveryStatusReqDto.getName() == null
					|| deliveryStatusReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			DeliveryStatusModel deliveryStatusModelByName = deliveryStatusDao.getByName(deliveryStatusReqDto.getName());
			if (deliveryStatusModelByName != null && deliveryStatusModelByName.getId() != id)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			DeliveryStatusMapper.toDeliveryStatusModel(deliveryStatusModel, deliveryStatusReqDto);

			return new CommonUpsertResDto(deliveryStatusModel.getId());
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
	public CommonGetResDto<List<DeliveryStatusLdto>> getLdtos(String name, String deliveryStatusId)
	{
		try
		{
			List<DeliveryStatusLdto> data = null;
			data = deliveryStatusDao.getLdtos(name, deliveryStatusId);
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
	public CommonGetOneResDto<DeliveryStatusResDto> getById(int id)
	{
		try
		{
			DeliveryStatusResDto data = null;
			data = DeliveryStatusMapper.toDeliveryStatusResDto(deliveryStatusDao.getById(id));

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
			deliveryStatusDao.delete(id);

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
