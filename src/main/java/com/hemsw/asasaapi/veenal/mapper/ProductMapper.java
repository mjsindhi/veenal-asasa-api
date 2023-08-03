package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.ProductReqDto;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;

public class ProductMapper
{

	public static ProductModel toProductModel(ProductReqDto productReqDto)
	{
		ProductModel productModel = new ProductModel()
				.setName(productReqDto.getName())
				.setCode(productReqDto.getCode())
				.setDesc(productReqDto.getDesc())
				.setUnitId(productReqDto.getUnitId())
				.setHsn(productReqDto.getHsn())
				.setPurchasePriceRaw(productReqDto.getPurchasePriceRaw())
				.setPurchasePriceFinished(productReqDto.getPurchasePriceFinished())
				.setCostPrice(productReqDto.getCostPrice())
				.setAdditionalCost(productReqDto.getAdditionalCost())
				.setMinSalesPrice(productReqDto.getMinSalesPrice())
				.setMaxSalesPrice(productReqDto.getMaxSalesPrice())
				.setInternetSalesPrice(productReqDto.getInternetSalesPrice())
				.setMrp(productReqDto.getMrp())
				.setDiscount(productReqDto.getDiscount())
				.setProductCategoryId(productReqDto.getProductCategoryId())
				.setTaxCategoryId(productReqDto.getTaxCategoryId())
				.setTaxId(productReqDto.getTaxId());
		String noteStr = "";
		if (productReqDto.getNote() != null)
		{
			noteStr = productReqDto.getNote();
		}
		productModel.setNote(noteStr)
				.setSold(productReqDto.isSold())
				.setMade(productReqDto.isMade())
				.setMinQty(productReqDto.getMinQty())
				.setReorderQty(productReqDto.getReorderQty())
				.setRawSupplierId(productReqDto.getRawSupplierId())
				.setFinishedSupplierId(productReqDto.getFinishedSupplierId());
		return productModel;
	}
}
