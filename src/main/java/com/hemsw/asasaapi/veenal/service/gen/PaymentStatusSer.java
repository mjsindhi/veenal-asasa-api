package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dto.req.PaymentStatusReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.PaymentStatusMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.PaymentStatusModel;
import com.hemsw.asasaapi.veenal.dao.gen.PaymentStatusDao;
import com.hemsw.asasaapi.veenal.dto.ldto.PaymentStatusLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonDeleteResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetOneResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.PaymentStatusResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class PaymentStatusSer
{

	@Autowired
	private PaymentStatusDao paymentStatusDao;

	@Transactional
	public CommonUpsertResDto create(PaymentStatusReqDto paymentStatusReqDto, UserModel userModel)
	{
		try
		{
			if (paymentStatusReqDto == null
					|| paymentStatusReqDto.getName() == null
					|| paymentStatusReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (paymentStatusDao.isNameExists(paymentStatusReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			PaymentStatusModel paymentStatusModel = PaymentStatusMapper.toPaymentStatusModel(paymentStatusReqDto);
			paymentStatusModel.setCreatedByUserId(userModel.getId());
			paymentStatusDao.create(paymentStatusModel);

			return new CommonUpsertResDto(paymentStatusModel.getId());
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
	public CommonUpsertResDto update(int id, PaymentStatusReqDto paymentStatusReqDto)
	{
		try
		{
			PaymentStatusModel paymentStatusModel = paymentStatusDao.getById(id);
			if (paymentStatusModel == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"id_invalid",
						"Id is invalid",
						"Id is invalid"
				));
			}

			if (paymentStatusReqDto == null
					|| paymentStatusReqDto.getName() == null
					|| paymentStatusReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			PaymentStatusModel paymentStatusModelByName = paymentStatusDao.getByName(paymentStatusReqDto.getName());
			if (paymentStatusModelByName != null && paymentStatusModelByName.getId() != id)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			PaymentStatusMapper.toPaymentStatusModel(paymentStatusModel, paymentStatusReqDto);

			return new CommonUpsertResDto(paymentStatusModel.getId());
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
	public CommonGetResDto<List<PaymentStatusLdto>> getLdtos(String name, String paymentStatusId)
	{
		try
		{
			List<PaymentStatusLdto> data = null;
			data = paymentStatusDao.getLdtos(name, paymentStatusId);
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
	public CommonGetOneResDto<PaymentStatusResDto> getById(int id)
	{
		try
		{
			PaymentStatusResDto data = null;
			data = PaymentStatusMapper.toPaymentStatusResDto(paymentStatusDao.getById(id));

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
			paymentStatusDao.delete(id);

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
