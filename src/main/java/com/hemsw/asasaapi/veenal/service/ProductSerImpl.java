package com.hemsw.asasaapi.veenal.service;

import com.hemsw.asasaapi.veenal.dto.req.ProductReqDto;
import com.hemsw.asasaapi.veenal.dto.res.CommonUpsertResDto;
import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.mapper.ProductMapper;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import com.hemsw.asasaapi.veenal.dao.gen.ProductCategoryRepoImpl;
import com.hemsw.asasaapi.veenal.dao.gen.ProductRepo;
import com.hemsw.asasaapi.veenal.dao.gen.ProductRepoImpl;
import com.hemsw.asasaapi.veenal.dao.gen.SupplierDao;
import com.hemsw.asasaapi.veenal.dao.gen.TaxCategoryRepoImpl;
import com.hemsw.asasaapi.veenal.dao.gen.TaxRepoImpl;
import com.hemsw.asasaapi.veenal.dao.gen.UnitRepo;
import com.hemsw.asasaapi.veenal.dao.gen.UnitRepoImpl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSerImpl implements ProductSer
{

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private UnitRepo unitRepo;

	@Autowired
	private UnitRepoImpl unitRepoImpl;

	@Autowired
	private ProductCategoryRepoImpl productCategoryRepoImpl;

	@Autowired
	private TaxCategoryRepoImpl taxCategoryRepoImpl;

	@Autowired
	private TaxRepoImpl taxRepoImpl;

	@Autowired
	private SupplierDao supplierDao;

	@Autowired
	private ProductRepoImpl productRepoImpl;

	public CommonUpsertResDto create(ProductReqDto productReqDto, UserModel userModel)
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

		if (productRepoImpl.isNameExists(productReqDto.getName()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"name_exists",
					"Name already exists",
					"Name already exists"
			));
		}

		if (productRepoImpl.isCodeExists(productReqDto.getCode()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"code_exists",
					"Code already exists",
					"Code already exists"
			));
		}

		if (productReqDto.getUnitId() != null
				&& !unitRepoImpl.isIdExists(productReqDto.getUnitId()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_unit",
					"Invalid unit",
					"Invalid unit"
			));
		}

		if (productReqDto.getProductCategoryId() != null
				&& !productCategoryRepoImpl.isIdExists(productReqDto.getProductCategoryId()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_product_category",
					"Invalid product category",
					"Invalid product category"
			));
		}

		if (productReqDto.getTaxCategoryId() != null
				&& !taxCategoryRepoImpl.isIdExists(productReqDto.getTaxCategoryId()))
		{
			return new CommonUpsertResDto(new ErrorResDto(
					new Date(),
					"invalid_tax_category",
					"Invalid tax category",
					"Invalid tax category"
			));
		}

		if (productReqDto.getTaxId() != null
				&& !taxRepoImpl.isIdExists(productReqDto.getTaxId()))
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

		if (productReqDto.getFinishedSupplierId() != null
				&& !supplierDao.isIdExists(productReqDto.getFinishedSupplierId()))
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
		productRepoImpl.create(productModel);

		return new CommonUpsertResDto(productModel.getId());

	}

}
