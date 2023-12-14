package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.SalesChannelDao;
import com.hemsw.asasaapi.veenal.dto.ldto.SalesChannelLdto;
import com.hemsw.asasaapi.veenal.dto.req.SalesChannelReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.SalesChannelMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesChannelModel;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class SalesChannelSer
{

	@Autowired
	SalesChannelDao salesChannelDao;

	@Transactional
	public CommonUpsertResDto create(SalesChannelReqDto salesChannelReqDto, UserModel userModel)
	{
		if (salesChannelReqDto == null
				|| salesChannelReqDto.getName() == null
				|| salesChannelReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (salesChannelDao.isNameExists(salesChannelReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		SalesChannelModel leadStatusModel = SalesChannelMapper.toSalesChannelModel(salesChannelReqDto);
		leadStatusModel.setCreatedByUserId(userModel.getId());
		salesChannelDao.create(leadStatusModel);

		return new CommonUpsertResDto(leadStatusModel.getId());

	}

	@Transactional
	public boolean create(SalesChannelModel leadStatusModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!checkIsValidCreate(leadStatusModel, errorMsg))
		{
			return false;
		}

		leadStatusModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		salesChannelDao.create(leadStatusModel);

		return true;

	}

	@Transactional
	public CommonGetResDto<List<SalesChannelLdto>> getLdtos(String name)
	{
		try
		{
			List<SalesChannelLdto> data = null;
			data = salesChannelDao.getLdtos(name);
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
		data = salesChannelDao.getNames();

		return data;
	}

	@Transactional
	public List<SalesChannelModel> get()
	{
		List<SalesChannelModel> productcategoryModels = null;
		productcategoryModels = salesChannelDao.get();

		return productcategoryModels;
	}

	public boolean checkIsValidCreate(SalesChannelModel productcategory, StringBuilder errorMsg)

	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		SalesChannelModel productcategoryFound = salesChannelDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(SalesChannelModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		SalesChannelModel productcategoryFound = salesChannelDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(SalesChannelModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("SalesChannel dto is null");
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
