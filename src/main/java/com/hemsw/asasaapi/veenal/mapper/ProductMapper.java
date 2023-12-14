package com.hemsw.asasaapi.veenal.mapper;

import com.hemsw.asasaapi.veenal.dto.req.ProductReqDto;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;

public class ProductMapper
{

	public static ProductModel toProductModel(ProductReqDto productReqDto)
	{
		ProductModel productModel = new ProductModel();
		productModel.setName(productReqDto.getName());
		productModel.setCode(productReqDto.getCode());
		productModel.setDesc(productReqDto.getDesc());
		productModel.setUnitId(productReqDto.getUnitId());
		productModel.setHsn(productReqDto.getHsn());
		productModel.setRawPurchasePrice(productReqDto.getRawPurchasePrice());
		productModel.setPolishPrice(productReqDto.getPolishPrice());
		productModel.setCostPrice(productReqDto.getCostPrice());
		productModel.setAdditionalCost(productReqDto.getAdditionalCost());
		productModel.setMinSalesPrice(productReqDto.getMinSalesPrice());
		productModel.setWholesaleSalesPrice(productReqDto.getWholesaleSalesPrice());
		productModel.setMrp(productReqDto.getMrp());
		productModel.setInternetSalesPrice(productReqDto.getInternetSalesPrice());
		productModel.setMaxSalesPrice(productReqDto.getMaxSalesPrice());
		productModel.setDiscount(productReqDto.getDiscount());
		productModel.setCatId(productReqDto.getProductCatId());
		productModel.setTaxCatId(productReqDto.getTaxCatId());
		productModel.setTaxId(productReqDto.getTaxId());
		String noteStr = "";
		if (productReqDto.getNote() != null)
		{
			noteStr = productReqDto.getNote();
		}
		productModel.setNote(noteStr);
		productModel.setIsSold(productReqDto.isSold());
		productModel.setIsMade(productReqDto.isMade());
		productModel.setMinQty(productReqDto.getMinQty());
		productModel.setReorderQty(productReqDto.getReorderQty());
		productModel.setRawSupplierId(productReqDto.getRawSupplierId());
		productModel.setPolishedBySupplierId(productReqDto.getPolishedBySupplierId());
		productModel.setWeight(productReqDto.getWeight());
		return productModel;
	}
}
