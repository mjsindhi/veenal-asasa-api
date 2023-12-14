package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.dao.gen.ProductCategoryDao;
import com.hemsw.asasaapi.veenal.dao.gen.ProductDao;
import com.hemsw.asasaapi.veenal.dto.req.ProductReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.ProductMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.dao.gen.SupplierDao;
import com.hemsw.asasaapi.veenal.dao.gen.TaxCatDao;
import com.hemsw.asasaapi.veenal.dao.gen.TaxDao;
import com.hemsw.asasaapi.veenal.dao.gen.UnitDao;
import com.hemsw.asasaapi.veenal.dto.hdto.ProdForEstimateHdto;
import com.hemsw.asasaapi.veenal.dto.ldto.ProductLdto;
import com.hemsw.asasaapi.veenal.dto.res.CommonGetResDto;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class ProductSer
{

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UnitDao unitDao;

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private TaxCatDao taxCategoryDao;

	@Autowired
	private TaxDao taxDao;

	@Autowired
	private SupplierDao supplierDao;

	@Transactional
	public CommonUpsertResDto create(ProductReqDto productReqDto, UserModel userModel)
	{

		try
		{
			if (productReqDto == null
					|| productReqDto.getName() == null
					|| productReqDto.getName().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_required",
						"Enter name",
						"Enter name"
				));
			}

			if (productReqDto.getCode() == null
					|| productReqDto.getCode().isEmpty())
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"code_required",
						"Enter code",
						"Enter code"
				));
			}

			if (productReqDto.getUnitId() == null)
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"unit_required",
						"Enter unit",
						"Enter unit"
				));
			}

			if (productDao.isNameExists(productReqDto.getName()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"name_exists",
						"Name already exists",
						"Name already exists"
				));
			}

			if (productDao.isCodeExists(productReqDto.getCode()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"code_exists",
						"Code already exists",
						"Code already exists"
				));
			}

			if (productReqDto.getUnitId() != null
					&& !unitDao.isIdExists(productReqDto.getUnitId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_unit",
						"Invalid unit",
						"Invalid unit"
				));
			}

			if (productReqDto.getProductCatId() != null
					&& !productCategoryDao.isIdExists(productReqDto.getProductCatId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_product_category",
						"Invalid product category",
						"Invalid product category"
				));
			}

			if (productReqDto.getTaxCatId() != null
					&& !taxCategoryDao.isIdExists(productReqDto.getTaxCatId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_tax_category",
						"Invalid tax category",
						"Invalid tax category"
				));
			}

			if (productReqDto.getTaxId() != null
					&& !taxDao.isIdExists(productReqDto.getTaxId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_tax",
						"Invalid tax",
						"Invalid tax"
				));
			}

			if (productReqDto.getRawSupplierId() != null
					&& !supplierDao.isIdExists(productReqDto.getRawSupplierId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_raw_supplier",
						"Invalid raw supplier",
						"Invalid raw supplier"
				));
			}

			if (productReqDto.getPolishedBySupplierId() != null
					&& !supplierDao.isIdExists(productReqDto.getPolishedBySupplierId()))
			{
				return new CommonUpsertResDto(new ErrorResDto(
						new Date(),
						"invalid_finished_supplier",
						"Invalid finished supplier",
						"Invalid finished supplier"
				));
			}

			ProductModel productModel = ProductMapper.toProductModel(productReqDto);
			productModel.setCreatedByUserId(userModel.getId());
			productDao.create(productModel);

			return new CommonUpsertResDto(productModel.getId());
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
	public CommonGetResDto<List<ProductLdto>> getLdtos(String name, Integer unitId, Boolean withCategory, Integer categoryId, Boolean searchInSubCat, String categoryName, Integer taxCatId, Boolean isMfg)
	{
		try
		{

			List<ProductLdto> data = productDao.getLdtos(name, unitId, withCategory, categoryId, searchInSubCat, categoryName, taxCatId, isMfg);
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
	public Map<Integer, ProductModel> getMap(List<Integer> ids
	)
	{
		Map<Integer, ProductModel> data = new HashMap<>();

		List<ProductModel> productModels = productDao.get(null, null, null, null, ids);
		for (ProductModel productModel : productModels)
		{
			data.put(productModel.getId(), productModel);
		}

		return data;
	}

	@Transactional
	public CommonGetResDto<List<ProdForEstimateHdto>> getProdForEstimate()
	{
		try
		{
			List<ProdForEstimateHdto> data = productDao.getProdListForEstimateHdtos();
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
}
