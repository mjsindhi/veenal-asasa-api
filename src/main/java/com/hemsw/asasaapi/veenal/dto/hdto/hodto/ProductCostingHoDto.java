package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.ProductCostingComponentModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductCostingModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductCostingOthChargeModel;
import java.util.List;

public class ProductCostingHoDto
{

	ProductCostingModel productCostingModel;
	List<ProductCostingComponentModel> productCostingComponentModels;
	List<ProductCostingComponentModel> productCostingWorkModels;
	List<ProductCostingOthChargeModel> productCostingOthChargeModels;

	public ProductCostingModel getProductCostingModel()
	{
		return productCostingModel;
	}

	public void setProductCostingModel(ProductCostingModel productCostingModel)
	{
		this.productCostingModel = productCostingModel;
	}

	public List<ProductCostingComponentModel> getProductCostingComponentModels()
	{
		return productCostingComponentModels;
	}

	public void setProductCostingComponentModels(List<ProductCostingComponentModel> productCostingComponentModels)
	{
		this.productCostingComponentModels = productCostingComponentModels;
	}

	public List<ProductCostingComponentModel> getProductCostingWorkModels()
	{
		return productCostingWorkModels;
	}

	public void setProductCostingWorkModels(List<ProductCostingComponentModel> productCostingWorkModels)
	{
		this.productCostingWorkModels = productCostingWorkModels;
	}

	public List<ProductCostingOthChargeModel> getProductCostingOthChargeModels()
	{
		return productCostingOthChargeModels;
	}

	public void setProductCostingOthChargeModels(List<ProductCostingOthChargeModel> productCostingOthChargeModels)
	{
		this.productCostingOthChargeModels = productCostingOthChargeModels;
	}

}
