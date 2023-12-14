package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.IPusaItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChNonTaxable;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChOnItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChTaxable;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;
import java.util.Objects;

public class SalesOrderHoDto
{

	private VoucherModel voucherModel;
	private SalesOrderModel salesOrderModel;
	private List<SalesOrderItemModel> salesOrderItemModels;
	private List<SalesOrderOthChOnItemModel> salesOrderOthChOnItemModels;
	private List<SalesOrderOthChTaxableModel> salesOrderOthChTaxableModels;
	private List<SalesOrderOthChModel> salesOrderOthChNonTaxModels;

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public SalesOrderModel getSalesOrderModel()
	{
		return salesOrderModel;
	}

	public void setSalesOrderModel(SalesOrderModel salesOrderModel)
	{
		this.salesOrderModel = salesOrderModel;
	}

	public List<SalesOrderItemModel> getSalesOrderItemModels()
	{
		return salesOrderItemModels;
	}

	public void setSalesOrderItemModels(List<SalesOrderItemModel> salesOrderItemModels)
	{
		this.salesOrderItemModels = salesOrderItemModels;
	}

	public List<SalesOrderOthChOnItemModel> getSalesOrderOthChOnItemModels()
	{
		return salesOrderOthChOnItemModels;
	}

	public void setSalesOrderOthChOnItemModels(List<SalesOrderOthChOnItemModel> salesOrderOthChOnItemModels)
	{
		this.salesOrderOthChOnItemModels = salesOrderOthChOnItemModels;
	}

	public List<SalesOrderOthChTaxableModel> getSalesOrderOthChTaxableModels()
	{
		return salesOrderOthChTaxableModels;
	}

	public void setSalesOrderOthChTaxableModels(List<SalesOrderOthChTaxableModel> salesOrderOthChTaxableModels)
	{
		this.salesOrderOthChTaxableModels = salesOrderOthChTaxableModels;
	}

	public List<SalesOrderOthChModel> getSalesOrderOthChNonTaxModels()
	{
		return salesOrderOthChNonTaxModels;
	}

	public void setSalesOrderOthChNonTaxModels(List<SalesOrderOthChModel> salesOrderOthChNonTaxModels)
	{
		this.salesOrderOthChNonTaxModels = salesOrderOthChNonTaxModels;
	}

	public void setPusaItems(List<? extends IPusaItem> iPusaItems)
	{
		this.getSalesOrderItemModels().clear();
		for (IPusaItem iPusaItem : iPusaItems)
		{
			this.getSalesOrderItemModels().add((SalesOrderItemModel) iPusaItem);
		}
	}

	public void setPusaOthChOnItem(List<? extends IPusaOthChOnItem> iPusaOthChOnItems)
	{
		this.getSalesOrderOthChOnItemModels().clear();
		for (IPusaOthChOnItem iPusaOthChOnItem : iPusaOthChOnItems)
		{
			this.getSalesOrderOthChOnItemModels().add((SalesOrderOthChOnItemModel) iPusaOthChOnItem);
		}
	}

	public void setPusaOthChTaxable(List<? extends IPusaOthChTaxable> iPusaOthChTaxables)
	{
		this.getSalesOrderOthChTaxableModels().clear();
		for (IPusaOthChTaxable iPusaOthChTaxable : iPusaOthChTaxables)
		{
			this.getSalesOrderOthChTaxableModels().add((SalesOrderOthChTaxableModel) iPusaOthChTaxable);
		}
	}

	public void setPusaOthChNonTaxable(List<? extends IPusaOthChNonTaxable> iPusaOthChNonTaxables)
	{
		this.getSalesOrderOthChNonTaxModels().clear();
		for (IPusaOthChNonTaxable iPusaOthChNonTaxable : iPusaOthChNonTaxables)
		{
			this.getSalesOrderOthChNonTaxModels().add((SalesOrderOthChModel) iPusaOthChNonTaxable);
		}
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 43 * hash + Objects.hashCode(this.voucherModel);
		hash = 43 * hash + Objects.hashCode(this.salesOrderModel);
		hash = 43 * hash + Objects.hashCode(this.salesOrderItemModels);
		hash = 43 * hash + Objects.hashCode(this.salesOrderOthChOnItemModels);
		hash = 43 * hash + Objects.hashCode(this.salesOrderOthChTaxableModels);
		hash = 43 * hash + Objects.hashCode(this.salesOrderOthChNonTaxModels);
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
		final SalesOrderHoDto other = (SalesOrderHoDto) obj;
		if (!Objects.equals(this.voucherModel, other.voucherModel))
		{
			return false;
		}
		if (!Objects.equals(this.salesOrderModel, other.salesOrderModel))
		{
			return false;
		}
		if (!Objects.equals(this.salesOrderItemModels, other.salesOrderItemModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesOrderOthChOnItemModels, other.salesOrderOthChOnItemModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesOrderOthChTaxableModels, other.salesOrderOthChTaxableModels))
		{
			return false;
		}
		if (!Objects.equals(this.salesOrderOthChNonTaxModels, other.salesOrderOthChNonTaxModels))
		{
			return false;
		}
		return true;
	}

}
