package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.TaxCatDao;
import com.hemsw.asasaapi.veenal.dao.gen.TaxDao;
import com.hemsw.asasaapi.veenal.dto.ldto.TaxCategoryLdto;
import com.hemsw.asasaapi.veenal.dto.req.TaxCatReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.TaxCatMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.TaxCatModel;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TaxCatSer
{

	@Autowired
	TaxCatDao taxCatDao;

	@Autowired
	TaxDao taxDao;

	@Transactional
	public CommonUpsertResDto create(TaxCatReqDto taxCatReqDto, UserModel userModel)
	{
		try
		{

			if (taxCatReqDto == null
					|| taxCatReqDto.getName() == null
					|| taxCatReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (taxCatDao.isNameExists(taxCatReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			if (!taxDao.isIdExists(taxCatReqDto.getTaxId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_tax",
						"Invalid tax",
						"Invalid tax"
				));
			}

			TaxCatModel taxCatModel = TaxCatMapper.toTaxCatModel(taxCatReqDto);
			taxCatModel.setCreatedByUserId(userModel.getId());
			taxCatDao.create(taxCatModel);

			return new CommonUpsertResDto(taxCatModel.getId());
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

	public boolean create(TaxCatModel agent, StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isTaxCategoryAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		agent.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		taxCatDao.create(agent);
		return true;
	}

	public boolean createNonTx(List<TaxCatModel> taxCategoryModels, StringBuilder errorMsg) throws SQLException, ParseException, IllegalAccessException, Exception
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isTaxCategoryAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		taxCatDao.deleteAll();
		for (TaxCatModel taxCategoryModel : taxCategoryModels)
		{
			if (!checkIsValidCreate(taxCategoryModel, errorMsg))
			{
				return false;
			}

			taxCategoryModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
			taxCatDao.create(taxCategoryModel);
		}
		return true;
	}

	@Transactional
	public CommonGetResDto<List<TaxCategoryLdto>> getLdtos(String name)
	{
		try
		{
			List<TaxCategoryLdto> data = null;
			data = taxCatDao.getLdtos(name);
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
	public Map<Integer, TaxCatModel> getMap()
	{
		Map<Integer, TaxCatModel> data = new HashMap<>();

		List<TaxCatModel> taxCategoryModels = taxCatDao.get();
		for (TaxCatModel taxCategoryModel : taxCategoryModels)
		{
			data.put(taxCategoryModel.getId(), taxCategoryModel);
		}

		return data;
	}

	@Transactional
	public List<String> getNames()
	{
		List<String> data = null;
		data = taxCatDao.getNames();

		return data;
	}

	@Transactional
	public List<TaxCatModel> get()
	{
		List<TaxCatModel> productcategoryModels = null;
		productcategoryModels = taxCatDao.get();

		return productcategoryModels;
	}

	public boolean checkIsValidCreate(TaxCatModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		TaxCatModel productcategoryFound = taxCatDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(TaxCatModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		TaxCatModel productcategoryFound = taxCatDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(TaxCatModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("TaxCategory dto is null");
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
