package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.IPusaItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChNonTaxable;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChOnItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChTaxable;
import com.hemsw.asasaapi.veenal.model.gen.SalesAgentModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOthChTaxableModel;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SalesHoDto
{

	String no;
	Date date;
	private SalesModel salesModel;
	private List<SalesAgentModel> salesAgentModels;
	private List<SalesItemModel> salesItemModels;
	private List<SalesOthChOnItemModel> salesOthChOnItemModels;
	private List<SalesOthChTaxableModel> salesOthChTaxableModels;
	private List<SalesOthChModel> salesOthChNonTaxModels;

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

	public SalesModel getSalesModel()
	{
		return salesModel;
	}

	public void setSalesModel(SalesModel salesModel)
	{
		this.salesModel = salesModel;
	}

	public List<SalesAgentModel> getSalesAgentModels()
	{
		return salesAgentModels;
	}

	public void setSalesAgentModels(List<SalesAgentModel> salesAgentModels)
	{
		this.salesAgentModels = salesAgentModels;
	}

	public List<SalesItemModel> getSalesItemModels()
	{
		return salesItemModels;
	}

	public void setSalesItemModels(List<SalesItemModel> salesItemModels)
	{
		this.salesItemModels = salesItemModels;
	}

	public List<SalesOthChOnItemModel> getSalesOthChOnItemModels()
	{
		return salesOthChOnItemModels;
	}

	public void setSalesOthChOnItemModels(List<SalesOthChOnItemModel> salesOthChOnItemModels)
	{
		this.salesOthChOnItemModels = salesOthChOnItemModels;
	}

	public List<SalesOthChTaxableModel> getSalesOthChTaxableModels()
	{
		return salesOthChTaxableModels;
	}

	public void setSalesOthChTaxableModels(List<SalesOthChTaxableModel> salesOthChTaxableModels)
	{
		this.salesOthChTaxableModels = salesOthChTaxableModels;
	}

	public List<SalesOthChModel> getSalesOthChNonTaxModels()
	{
		return salesOthChNonTaxModels;
	}

	public void setSalesOthChNonTaxModels(List<SalesOthChModel> salesOthChNonTaxModels)
	{
		this.salesOthChNonTaxModels = salesOthChNonTaxModels;
	}

	public void setPusaItems(List<? extends IPusaItem> iPusaItems)
	{
		this.getSalesItemModels().clear();
		for (IPusaItem iPusaItem : iPusaItems)
		{
			this.getSalesItemModels().add((SalesItemModel) iPusaItem);
		}
	}

	public void setPusaOthChOnItem(List<? extends IPusaOthChOnItem> iPusaOthChOnItems)
	{
		this.getSalesOthChOnItemModels().clear();
		for (IPusaOthChOnItem iPusaOthChOnItem : iPusaOthChOnItems)
		{
			this.getSalesOthChOnItemModels().add((SalesOthChOnItemModel) iPusaOthChOnItem);
		}
	}

	public void setPusaOthChTaxable(List<? extends IPusaOthChTaxable> iPusaOthChTaxables)
	{
		this.getSalesOthChTaxableModels().clear();
		for (IPusaOthChTaxable iPusaOthChTaxable : iPusaOthChTaxables)
		{
			this.getSalesOthChTaxableModels().add((SalesOthChTaxableModel) iPusaOthChTaxable);
		}
	}

	public void setPusaOthChNonTaxable(List<? extends IPusaOthChNonTaxable> iPusaOthChNonTaxables)
	{
		this.getSalesOthChNonTaxModels().clear();
		for (IPusaOthChNonTaxable iPusaOthChNonTaxable : iPusaOthChNonTaxables)
		{
			this.getSalesOthChNonTaxModels().add((SalesOthChModel) iPusaOthChNonTaxable);
		}
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.no);
		hash = 37 * hash + Objects.hashCode(this.date);
		hash = 37 * hash + Objects.hashCode(this.salesModel);
		hash = 37 * hash + Objects.hashCode(this.salesAgentModels);
		hash = 37 * hash + Objects.hashCode(this.salesItemModels);
		hash = 37 * hash + Objects.hashCode(this.salesOthChOnItemModels);
		hash = 37 * hash + Objects.hashCode(this.salesOthChTaxableModels);
		hash = 37 * hash + Objects.hashCode(this.salesOthChNonTaxModels);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final SalesHoDto other = (SalesHoDto) obj;
		if (!Objects.equals(this.no, other.no))
		{
			return false;
		}
		if (!Objects.equals(this.date, other.date))
		{
			return false;
		}
		if (!Objects.equals(this.salesModel, other.salesModel))
		{
			return false;
		}
		if (!Objects.equals(this.salesAgentModels, other.salesAgentModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesItemModels, other.salesItemModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesOthChOnItemModels, other.salesOthChOnItemModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesOthChTaxableModels, other.salesOthChTaxableModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesOthChNonTaxModels, other.salesOthChNonTaxModels))
		{
			return false;
		}
		return true;
	}

}
