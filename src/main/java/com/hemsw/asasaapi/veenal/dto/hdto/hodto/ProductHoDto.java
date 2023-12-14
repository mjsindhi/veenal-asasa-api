package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.ClosingStockHdto;
import com.hemsw.asasaapi.veenal.model.gen.OpeningStockModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductBomOthChargeModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductComponentModel;
import com.hemsw.asasaapi.veenal.model.gen.ProductModel;
import java.util.List;

public class ProductHoDto
{

	ProductModel productModel;
	String imagePath;
	List<OpeningStockModel> openingStockModels;
	List<ProductComponentModel> productComponentModels;
	List<ProductComponentModel> productWorkModels;
	List<ProductBomOthChargeModel> productOthChargeModels;
	List<ProductCostingHoDto> productCostingHoDtos;
	ClosingStockHdto closingStockHdto;
	boolean updateRatesInJobs;
	boolean updateRatesInRcvdGoods;

	public ProductModel getProductModel()
	{
		return productModel;
	}

	public void setProductModel(ProductModel productModel)
	{
		this.productModel = productModel;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	public List<OpeningStockModel> getOpeningStockModels()
	{
		return openingStockModels;
	}

	public void setOpeningStockModels(List<OpeningStockModel> openingStockModels)
	{
		this.openingStockModels = openingStockModels;
	}

	public List<ProductComponentModel> getProductComponentModels()
	{
		return productComponentModels;
	}

	public void setProductComponentModels(List<ProductComponentModel> productComponentModels)
	{
		this.productComponentModels = productComponentModels;
	}

	public List<ProductComponentModel> getProductWorkModels()
	{
		return productWorkModels;
	}

	public void setProductWorkModels(List<ProductComponentModel> productWorkModels)
	{
		this.productWorkModels = productWorkModels;
	}

	public List<ProductBomOthChargeModel> getProductOthChargeModels()
	{
		return productOthChargeModels;
	}

	public void setProductOthChargeModels(List<ProductBomOthChargeModel> productOthChargeModels)
	{
		this.productOthChargeModels = productOthChargeModels;
	}

	public List<ProductCostingHoDto> getProductCostingHoDtos()
	{
		return productCostingHoDtos;
	}

	public void setProductCostingHoDtos(List<ProductCostingHoDto> productCostingHoDtos)
	{
		this.productCostingHoDtos = productCostingHoDtos;
	}

	public ClosingStockHdto getClosingStockHdto()
	{
		return closingStockHdto;
	}

	public void setClosingStockHdto(ClosingStockHdto closingStockHdto)
	{
		this.closingStockHdto = closingStockHdto;
	}

	public boolean isUpdateRatesInJobs()
	{
		return updateRatesInJobs;
	}

	public void setUpdateRatesInJobs(boolean updateRatesInJobs)
	{
		this.updateRatesInJobs = updateRatesInJobs;
	}

	public boolean isUpdateRatesInRcvdGoods()
	{
		return updateRatesInRcvdGoods;
	}

	public void setUpdateRatesInRcvdGoods(boolean updateRatesInRcvdGoods)
	{
		this.updateRatesInRcvdGoods = updateRatesInRcvdGoods;
	}

}
