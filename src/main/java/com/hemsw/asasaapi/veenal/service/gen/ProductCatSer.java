package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.ProductCategoryDao;
import com.hemsw.asasaapi.veenal.dto.hdto.CurrentStockDetHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.ProductCategoryLdto;
import com.hemsw.asasaapi.veenal.dto.req.ProductCatReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.helper.UserHelper;
import com.hemsw.asasaapi.veenal.mapper.ProductCatMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductCatModel;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ProductCatSer
{

	@Autowired
	ProductCategoryDao productCategoryDao;

	@Transactional
	public CommonUpsertResDto create(ProductCatReqDto productCatReqDto, UserModel userModel)
	{
		try
		{

			if (productCatReqDto == null
					|| productCatReqDto.getName() == null
					|| productCatReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (productCategoryDao.isNameExists(productCatReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			if (productCatReqDto.getParentId() != null)
			{
				if (!productCategoryDao.isIdExists(productCatReqDto.getParentId()))
				{
					return new CommonUpsertResDto(new ErrorResDto(
							new Date(),
							"invalid_parent_category",
							"Invalid parent category",
							"Invalid parent category"
					));
				}
			}

			ProductCatModel productCatModel = ProductCatMapper.toProductCatModel(productCatReqDto);
			productCatModel.setCreatedByUserId(userModel.getId());
			productCategoryDao.create(productCatModel);

			return new CommonUpsertResDto(productCatModel.getId());
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
	public boolean create(ProductCatModel productCategoryModel, StringBuilder errorMsg)
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isCatAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		if (!checkIsValidCreate(productCategoryModel, errorMsg))
		{
			return false;
		}
		productCategoryModel.setCreatedByUserId(UserHelper.getUserDetailsImpl().getUserModel().getId());
		productCategoryDao.create(productCategoryModel);

		return true;

	}

	public boolean createNonTx(List<ProductCatModel> productCategoryModels, StringBuilder errorMsg) throws SQLException, ParseException, IllegalAccessException, Exception
	{
		errorMsg = errorMsg == null ? new StringBuilder() : errorMsg;

		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isCatAdd())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		productCategoryDao.deleteAll();
		for (ProductCatModel productCategoryModel : productCategoryModels)
		{
			if (!checkIsValidCreate(productCategoryModel, errorMsg))
			{
				return false;
			}
			productCategoryDao.create(productCategoryModel);
		}
		return true;
	}

	@Transactional
	public CommonGetResDto<List<ProductCategoryLdto>> getLdtos(String name, Boolean withParent, Integer parentId, Boolean searchInSubCat, String parentCatName)
	{
		try
		{
			List<ProductCategoryLdto> data = null;
			data = productCategoryDao.getLdtos(name, withParent, parentId, searchInSubCat, parentCatName);
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
	public List<CurrentStockDetHdto> getCurrentStockByCat(Integer catId, Date dateTo, Boolean lowStock)
	{
		List<CurrentStockDetHdto> data = null;
		data = productCategoryDao.getCurrentStockByCat(catId, dateTo, lowStock);

		return data;
	}

	@Transactional
	public List<String> getNames()
	{
		List<String> data = null;
		data = productCategoryDao.getNames();

		return data;
	}

	@Transactional
	public List<ProductCatModel> get()
	{
		List<ProductCatModel> productcategoryModels = null;
		productcategoryModels = productCategoryDao.get();

		return productcategoryModels;
	}

	@Transactional
	public List<ProductCatModel> getForMigration(Integer limit, Integer offset)
	{
		List<ProductCatModel> data = null;
		data = productCategoryDao.getForMigration(limit, offset);

		return data;
	}

	@Transactional
	public boolean delete(ProductCatModel productCategoryModel, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		productCategoryDao.delete(productCategoryModel);

		return true;

	}

	@Transactional
	public boolean delete(int id, StringBuilder errorMsg)
	{
		if (!hasDelPerm(errorMsg))
		{
			return false;
		}

		productCategoryDao.delete(id);

		return true;

	}

	public boolean checkIsValidCreate(ProductCatModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		ProductCatModel productcategoryFound = productCategoryDao.getByName(productcategory.getName());
		if (productcategoryFound != null)
		{
			errorMsg.append("Name already exists");
			return false;
		}

		return true;
	}

	public boolean checkIsValidUpdate(ProductCatModel productcategory, StringBuilder errorMsg)
	{
		if (!checkIsValid(productcategory, errorMsg))
		{
			return false;
		}

		ProductCatModel productcategoryFound = productCategoryDao.getByName(productcategory.getName());
		if (productcategoryFound != null && productcategory.getId() != productcategoryFound.getId())
		{
			errorMsg.append("Name already exists");
			return false;
		}
		return true;
	}

	public boolean checkIsValid(ProductCatModel productcategory, StringBuilder errorMsg)
	{

		if (productcategory == null)
		{
			errorMsg.append("ProductCategory dto is null");
			return false;
		}

		if (productcategory.getName() == null || productcategory.getName().equals(""))
		{
			errorMsg.append("Name is required");
			return false;
		}

		return true;
	}

	private boolean hasDelPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isCatDelete())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean hasEditPerm(StringBuilder errorMsg)
	{
		if (!UserHelper.getUserDetailsImpl().getAccessRolePermHdto().isCatEdit())
		{
			errorMsg.append("You don't have permission");
			return false;
		}

		return true;
	}

	public boolean _hasEditPerm(int id, StringBuilder errorMsg)
	{

		//1.1 hasEditPermNonTx(id, errorMsg);
		return true;

	}
}
