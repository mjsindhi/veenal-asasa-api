package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.ProductCatReqDto;
import com.hemsw.asasaapi.veenal.model.gen.ProductCatModel;

public class ProductCatMapper
{

	public static ProductCatModel toProductCatModel(ProductCatReqDto productCatReqDto)
	{
		ProductCatModel productCatModel = new ProductCatModel();
		productCatModel.setName(productCatReqDto.getName());
		productCatModel.setNote(productCatReqDto.getNote());
		productCatModel.setParentId(productCatReqDto.getParentId());
		return productCatModel;
	}
}
