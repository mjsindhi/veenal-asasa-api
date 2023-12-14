package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.TradeTermsDao;
import com.hemsw.asasaapi.veenal.dto.ldto.TradeTermsLdto;
import com.hemsw.asasaapi.veenal.dto.req.TradeTermsReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.TradeTermsMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.TradeTermsModel;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TradeTermsSer
{

	@Autowired
	TradeTermsDao tradeTermsDao;

	@Transactional
	public CommonUpsertResDto create(TradeTermsReqDto tradeTermsReqDto, UserModel userModel)
	{
		if (tradeTermsReqDto == null
				|| tradeTermsReqDto.getName() == null
				|| tradeTermsReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (tradeTermsDao.isNameExists(tradeTermsReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		TradeTermsModel leadStatusModel = TradeTermsMapper.toTradeTermsModel(tradeTermsReqDto);
		leadStatusModel.setCreatedByUserId(userModel.getId());
		tradeTermsDao.create(leadStatusModel);

		return new CommonUpsertResDto(leadStatusModel.getId());

	}

	@Transactional
	public boolean create(TradeTermsModel leadStatusModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!checkIsValidCreate(leadStatusModel, errorMsg))
		{
			return false;
		}

		leadStatusModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		tradeTermsDao.create(leadStatusModel);

		return true;

	}

	@Transactional
	public CommonGetResDto<List<TradeTermsLdto>> getLdtos(String name)
	{
		try
		{
			List<TradeTermsLdto> data = null;
			data = tradeTermsDao.getLdtos(name);
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
		data = tradeTermsDao.getNames();

		return data;
	}

	@Transactional
	public List<TradeTermsModel> get()
	{
		List<TradeTermsModel> productcategoryModels = null;
		productcategoryModels = tradeTermsDao.get();

		return productcategoryModels;
	}

	public boolean checkIsValidCreate(TradeTermsModel productcategory, StringBuilder errorMsg)

	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		TradeTermsModel productcategoryFound = tradeTermsDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(TradeTermsModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		TradeTermsModel productcategoryFound = tradeTermsDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(TradeTermsModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("TradeTerms dto is null");
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
