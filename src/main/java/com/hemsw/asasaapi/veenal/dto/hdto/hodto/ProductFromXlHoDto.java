package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.OpeningStockModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import java.util.List;

public class ProductFromXlHoDto
{

	ProductModel productModel;
	List<OpeningStockModel> openingStockModels;

	public ProductModel getProductModel()
	{
		return productModel;
	}

	public void setProductModel(ProductModel productModel)
	{
		this.productModel = productModel;
	}

	public List<OpeningStockModel> getOpeningStockModels()
	{
		return openingStockModels;
	}

	public void setOpeningStockModels(List<OpeningStockModel> openingStockModels)
	{
		this.openingStockModels = openingStockModels;
	}

}
