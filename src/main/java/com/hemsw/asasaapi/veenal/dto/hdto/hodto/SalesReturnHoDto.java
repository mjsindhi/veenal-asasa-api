package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.IPusaItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChNonTaxable;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChOnItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChTaxable;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnAgentModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesReturnOthChTaxableModel;
import java.util.Date;
import java.util.List;

public class SalesReturnHoDto
{

	String no;
	Date date;
	private SalesReturnModel salesReturnModel;
	private List<SalesReturnAgentModel> salesReturnAgentModels;
	private List<SalesReturnItemModel> salesReturnItemModels;
	private List<SalesReturnOthChOnItemModel> salesReturnOthChOnItemModels;
	private List<SalesReturnOthChTaxableModel> salesReturnOthChTaxableModels;
	private List<SalesReturnOthChModel> salesReturnOthChNonTaxModels;

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public SalesReturnModel getSalesReturnModel()
	{
		return salesReturnModel;
	}

	public void setSalesReturnModel(SalesReturnModel salesReturnModel)
	{
		this.salesReturnModel = salesReturnModel;
	}

	public List<SalesReturnAgentModel> getSalesReturnAgentModels()
	{
		return salesReturnAgentModels;
	}

	public void setSalesReturnAgentModels(List<SalesReturnAgentModel> salesReturnAgentModels)
	{
		this.salesReturnAgentModels = salesReturnAgentModels;
	}

	public List<SalesReturnItemModel> getSalesReturnItemModels()
	{
		return salesReturnItemModels;
	}

	public void setSalesReturnItemModels(List<SalesReturnItemModel> salesReturnItemModels)
	{
		this.salesReturnItemModels = salesReturnItemModels;
	}

	public List<SalesReturnOthChOnItemModel> getSalesReturnOthChOnItemModels()
	{
		return salesReturnOthChOnItemModels;
	}

	public void setSalesReturnOthChOnItemModels(List<SalesReturnOthChOnItemModel> salesReturnOthChOnItemModels)
	{
		this.salesReturnOthChOnItemModels = salesReturnOthChOnItemModels;
	}

	public List<SalesReturnOthChTaxableModel> getSalesReturnOthChTaxableModels()
	{
		return salesReturnOthChTaxableModels;
	}

	public void setSalesReturnOthChTaxableModels(List<SalesReturnOthChTaxableModel> salesReturnOthChTaxableModels)
	{
		this.salesReturnOthChTaxableModels = salesReturnOthChTaxableModels;
	}

	public List<SalesReturnOthChModel> getSalesReturnOthChNonTaxModels()
	{
		return salesReturnOthChNonTaxModels;
	}

	public void setSalesReturnOthChNonTaxModels(List<SalesReturnOthChModel> salesReturnOthChNonTaxModels)
	{
		this.salesReturnOthChNonTaxModels = salesReturnOthChNonTaxModels;
	}

	public void setPusaItems(List<? extends IPusaItem> iPusaItems)
	{
		this.getSalesReturnItemModels().clear();
		for (IPusaItem iPusaItem : iPusaItems)
		{
			this.getSalesReturnItemModels().add((SalesReturnItemModel) iPusaItem);
		}
	}

	public void setPusaOthChOnItem(List<? extends IPusaOthChOnItem> iPusaOthChOnItems)
	{
		this.getSalesReturnOthChOnItemModels().clear();
		for (IPusaOthChOnItem iPusaOthChOnItem : iPusaOthChOnItems)
		{
			this.getSalesReturnOthChOnItemModels().add((SalesReturnOthChOnItemModel) iPusaOthChOnItem);
		}
	}

	public void setPusaOthChTaxable(List<? extends IPusaOthChTaxable> iPusaOthChTaxables)
	{
		this.getSalesReturnOthChTaxableModels().clear();
		for (IPusaOthChTaxable iPusaOthChTaxable : iPusaOthChTaxables)
		{
			this.getSalesReturnOthChTaxableModels().add((SalesReturnOthChTaxableModel) iPusaOthChTaxable);
		}
	}

	public void setPusaOthChNonTaxable(List<? extends IPusaOthChNonTaxable> iPusaOthChNonTaxables)
	{
		this.getSalesReturnOthChNonTaxModels().clear();
		for (IPusaOthChNonTaxable iPusaOthChNonTaxable : iPusaOthChNonTaxables)
		{
			this.getSalesReturnOthChNonTaxModels().add((SalesReturnOthChModel) iPusaOthChNonTaxable);
		}
	}

}
