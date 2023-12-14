package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.LeadSrcDao;
import com.hemsw.asasaapi.veenal.dto.ldto.LeadSrcLdto;
import com.hemsw.asasaapi.veenal.dto.req.LeadSrcReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.LeadSrcMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.LeadSrcModel;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class LeadSrcSer
{

	@Autowired
	LeadSrcDao leadSrcDao;

	@Transactional
	public CommonUpsertResDto create(LeadSrcReqDto leadSrcReqDto, UserModel userModel)
	{
		if (leadSrcReqDto == null
				|| leadSrcReqDto.getName() == null
				|| leadSrcReqDto.getName().isEmpty())
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_required",
					"Enter name",
					"Enter name"
			));
		}

		if (leadSrcDao.isNameExists(leadSrcReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		LeadSrcModel leadStatusModel = LeadSrcMapper.toLeadSrcModel(leadSrcReqDto);
		leadStatusModel.setCreatedByUserId(userModel.getId());
		leadSrcDao.create(leadStatusModel);

		return new CommonUpsertResDto(leadStatusModel.getId());

	}

	@Transactional
	public boolean create(LeadSrcModel leadStatusModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!checkIsValidCreate(leadStatusModel, errorMsg))
		{
			return false;
		}

		leadStatusModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		leadSrcDao.create(leadStatusModel);

		return true;

	}

	@Transactional
	public CommonGetResDto<List<LeadSrcLdto>> getLdtos(String name)
	{
		try
		{
			List<LeadSrcLdto> data = null;
			data = leadSrcDao.getLdtos(name);
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
		data = leadSrcDao.getNames();

		return data;
	}

	@Transactional
	public List<LeadSrcModel> get()
	{
		List<LeadSrcModel> productcategoryModels = null;
		productcategoryModels = leadSrcDao.get();

		return productcategoryModels;
	}

	public boolean checkIsValidCreate(LeadSrcModel productcategory, StringBuilder errorMsg)

	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		LeadSrcModel productcategoryFound = leadSrcDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(LeadSrcModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		LeadSrcModel productcategoryFound = leadSrcDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(LeadSrcModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("LeadSrc dto is null");
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
