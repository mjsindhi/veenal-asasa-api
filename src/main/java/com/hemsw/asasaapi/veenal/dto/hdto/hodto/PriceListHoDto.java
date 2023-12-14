package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.PriceListModel;
import com.hemsw.asasaapi.veenal.model.gen.PriceListProdModel;
import java.util.ArrayList;
import java.util.List;

public class PriceListHoDto
{

	private PriceListModel priceListModel;
	private List<PriceListProdModel> priceListProdModels;

	public PriceListHoDto()
	{
	}

	public PriceListHoDto(PriceListHoDto priceListHoDto, boolean copyId)
	{
		priceListModel = new PriceListModel(priceListHoDto.getPriceListModel(), false);
		priceListProdModels = new ArrayList<>();
		for (PriceListProdModel priceListProdModel : priceListHoDto.getPriceListProdModels())
		{
			priceListProdModels.add(new PriceListProdModel(priceListProdModel, false));
		}
	}

	public PriceListModel getPriceListModel()
	{
		return priceListModel;
	}

	public void setPriceListModel(PriceListModel priceListModel)
	{
		this.priceListModel = priceListModel;
	}

	public List<PriceListProdModel> getPriceListProdModels()
	{
		return priceListProdModels;
	}

	public void setPriceListProdModels(List<PriceListProdModel> priceListProdModels)
	{
		this.priceListProdModels = priceListProdModels;
	}

}
