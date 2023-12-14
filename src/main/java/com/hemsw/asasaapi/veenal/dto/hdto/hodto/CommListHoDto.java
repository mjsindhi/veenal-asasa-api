package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.CommListCatModel;
import com.hemsw.asasaapi.veenal.model.gen.CommListModel;
import com.hemsw.asasaapi.veenal.model.gen.CommListProdModel;
import java.util.List;

public class CommListHoDto
{

	CommListModel commListModel;
	List<CommListCatModel> commListCatModels;
	List<CommListProdModel> commListProdModels;

	public CommListModel getCommListModel()
	{
		return commListModel;
	}

	public void setCommListModel(CommListModel commListModel)
	{
		this.commListModel = commListModel;
	}

	public List<CommListCatModel> getCommListCatModels()
	{
		return commListCatModels;
	}

	public void setCommListCatModels(List<CommListCatModel> commListCatModels)
	{
		this.commListCatModels = commListCatModels;
	}

	public List<CommListProdModel> getCommListProdModels()
	{
		return commListProdModels;
	}

	public void setCommListProdModels(List<CommListProdModel> commListProdModels)
	{
		this.commListProdModels = commListProdModels;
	}

}
