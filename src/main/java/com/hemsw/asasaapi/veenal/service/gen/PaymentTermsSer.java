package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.PaymentTermsDao;
import com.hemsw.asasaapi.veenal.dto.ldto.PaymentTermsLdto;
import com.hemsw.asasaapi.veenal.dto.req.PaymentTermsReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.PaymentTermsMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.PaymentTermsModel;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class PaymentTermsSer
{

	@Autowired
	PaymentTermsDao paymentTermsDao;

	@Transactional
	public CommonUpsertResDto create(PaymentTermsReqDto paymentTermsReqDto, UserModel userModel)
	{
		if (paymentTermsReqDto == null
				|| paymentTermsReqDto.getName() == null
				|| paymentTermsReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (paymentTermsDao.isNameExists(paymentTermsReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		PaymentTermsModel leadStatusModel = PaymentTermsMapper.toPaymentTermsModel(paymentTermsReqDto);
		leadStatusModel.setCreatedByUserId(userModel.getId());
		paymentTermsDao.create(leadStatusModel);

		return new CommonUpsertResDto(leadStatusModel.getId());

	}

	@Transactional
	public boolean create(PaymentTermsModel leadStatusModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!checkIsValidCreate(leadStatusModel, errorMsg))
		{
			return false;
		}

		leadStatusModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		paymentTermsDao.create(leadStatusModel);

		return true;

	}

	@Transactional
	public CommonGetResDto<List<PaymentTermsLdto>> getLdtos(String name)
	{
		try
		{
			List<PaymentTermsLdto> data = null;
			data = paymentTermsDao.getLdtos(name);
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
		data = paymentTermsDao.getNames();

		return data;
	}

	@Transactional
	public List<PaymentTermsModel> get()
	{
		List<PaymentTermsModel> productcategoryModels = null;
		productcategoryModels = paymentTermsDao.get();

		return productcategoryModels;
	}

	public boolean checkIsValidCreate(PaymentTermsModel productcategory, StringBuilder errorMsg)

	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		PaymentTermsModel productcategoryFound = paymentTermsDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(PaymentTermsModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		PaymentTermsModel productcategoryFound = paymentTermsDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(PaymentTermsModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("PaymentTerms dto is null");
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
