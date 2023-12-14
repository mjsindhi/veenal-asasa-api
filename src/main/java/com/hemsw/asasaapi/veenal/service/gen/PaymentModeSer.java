package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.PaymentModeDao;
import com.hemsw.asasaapi.veenal.dto.ldto.PaymentModeLdto;
import com.hemsw.asasaapi.veenal.dto.req.PaymentModeReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.PaymentModeMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.PaymentModeModel;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class PaymentModeSer
{

	@Autowired
	PaymentModeDao paymentModeDao;

	@Transactional
	public CommonUpsertResDto create(PaymentModeReqDto paymentModeReqDto, UserModel userModel)
	{
		if (paymentModeReqDto == null
				|| paymentModeReqDto.getName() == null
				|| paymentModeReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (paymentModeDao.isNameExists(paymentModeReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		PaymentModeModel leadStatusModel = PaymentModeMapper.toPaymentModeModel(paymentModeReqDto);
		leadStatusModel.setCreatedByUserId(userModel.getId());
		paymentModeDao.create(leadStatusModel);

		return new CommonUpsertResDto(leadStatusModel.getId());

	}

	@Transactional
	public boolean create(PaymentModeModel leadStatusModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!checkIsValidCreate(leadStatusModel, errorMsg))
		{
			return false;
		}

		leadStatusModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		paymentModeDao.create(leadStatusModel);

		return true;

	}

	@Transactional
	public CommonGetResDto<List<PaymentModeLdto>> getLdtos(String name)
	{
		try
		{
			List<PaymentModeLdto> data = null;
			data = paymentModeDao.getLdtos(name);
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
	public List<String> getNames()
	{
		List<String> data = null;
		data = paymentModeDao.getNames();

		return data;
	}

	@Transactional
	public List<PaymentModeModel> get()
	{
		List<PaymentModeModel> productcategoryModels = null;
		productcategoryModels = paymentModeDao.get();

		return productcategoryModels;
	}

	public boolean checkIsValidCreate(PaymentModeModel productcategory, StringBuilder errorMsg)

	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		PaymentModeModel productcategoryFound = paymentModeDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(PaymentModeModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		PaymentModeModel productcategoryFound = paymentModeDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(PaymentModeModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("PaymentMode dto is null");
			return false;
		}

		if (productcategory.getName() == null || productcategory.getName().equals(""))
		{
			errorMsg.append("Name is required");
			return false;
		}

		return true;
	}

}
