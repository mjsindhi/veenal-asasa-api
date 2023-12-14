package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.IPusaItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChNonTaxable;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChOnItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChTaxable;
import com.hemsw.asasaapi.veenal.model.gen.EstimateItemModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.EstimateOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;
import java.util.Objects;

public class EstimateHoDto
{

	private VoucherModel voucherModel;
	private EstimateModel estimateModel;
	private List<EstimateItemModel> estimateItemModels;
	private List<EstimateOthChOnItemModel> estimateOthChOnItemModels;
	private List<EstimateOthChTaxableModel> estimateOthChTaxableModels;
	private List<EstimateOthChModel> estimateOthChNonTaxModels;

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public EstimateModel getEstimateModel()
	{
		return estimateModel;
	}

	public void setEstimateModel(EstimateModel estimateModel)
	{
		this.estimateModel = estimateModel;
	}

	public List<EstimateItemModel> getEstimateItemModels()
	{
		return estimateItemModels;
	}

	public void setEstimateItemModels(List<EstimateItemModel> estimateItemModels)
	{
		this.estimateItemModels = estimateItemModels;
	}

	public List<EstimateOthChOnItemModel> getEstimateOthChOnItemModels()
	{
		return estimateOthChOnItemModels;
	}

	public void setEstimateOthChOnItemModels(List<EstimateOthChOnItemModel> estimateOthChOnItemModels)
	{
		this.estimateOthChOnItemModels = estimateOthChOnItemModels;
	}

	public List<EstimateOthChTaxableModel> getEstimateOthChTaxableModels()
	{
		return estimateOthChTaxableModels;
	}

	public void setEstimateOthChTaxableModels(List<EstimateOthChTaxableModel> estimateOthChTaxableModels)
	{
		this.estimateOthChTaxableModels = estimateOthChTaxableModels;
	}

	public List<EstimateOthChModel> getEstimateOthChNonTaxModels()
	{
		return estimateOthChNonTaxModels;
	}

	public void setEstimateOthChNonTaxModels(List<EstimateOthChModel> estimateOthChNonTaxModels)
	{
		this.estimateOthChNonTaxModels = estimateOthChNonTaxModels;
	}

	public void setPusaItems(List<? extends IPusaItem> iPusaItems)
	{
		this.getEstimateItemModels().clear();
		for (IPusaItem iPusaItem : iPusaItems)
		{
			this.getEstimateItemModels().add((EstimateItemModel) iPusaItem);
		}
	}

	public void setPusaOthChOnItem(List<? extends IPusaOthChOnItem> iPusaOthChOnItems)
	{
		this.getEstimateOthChOnItemModels().clear();
		for (IPusaOthChOnItem iPusaOthChOnItem : iPusaOthChOnItems)
		{
			this.getEstimateOthChOnItemModels().add((EstimateOthChOnItemModel) iPusaOthChOnItem);
		}
	}

	public void setPusaOthChTaxable(List<? extends IPusaOthChTaxable> iPusaOthChTaxables)
	{
		this.getEstimateOthChTaxableModels().clear();
		for (IPusaOthChTaxable iPusaOthChTaxable : iPusaOthChTaxables)
		{
			this.getEstimateOthChTaxableModels().add((EstimateOthChTaxableModel) iPusaOthChTaxable);
		}
	}

	public void setPusaOthChNonTaxable(List<? extends IPusaOthChNonTaxable> iPusaOthChNonTaxables)
	{
		this.getEstimateOthChNonTaxModels().clear();
		for (IPusaOthChNonTaxable iPusaOthChNonTaxable : iPusaOthChNonTaxables)
		{
			this.getEstimateOthChNonTaxModels().add((EstimateOthChModel) iPusaOthChNonTaxable);
		}
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 43 * hash + Objects.hashCode(this.voucherModel);
		hash = 43 * hash + Objects.hashCode(this.estimateModel);
		hash = 43 * hash + Objects.hashCode(this.estimateItemModels);
		hash = 43 * hash + Objects.hashCode(this.estimateOthChOnItemModels);
		hash = 43 * hash + Objects.hashCode(this.estimateOthChTaxableModels);
		hash = 43 * hash + Objects.hashCode(this.estimateOthChNonTaxModels);
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
		final EstimateHoDto other = (EstimateHoDto) obj;
		if (!Objects.equals(this.voucherModel, other.voucherModel))
		{
			return false;
		}
		if (!Objects.equals(this.estimateModel, other.estimateModel))
		{
			return false;
		}
		if (!Objects.equals(this.estimateItemModels, other.estimateItemModels))
		{
			return false;
		}
		if (!Objects.equals(this.estimateOthChOnItemModels, other.estimateOthChOnItemModels))
		{
			return false;
		}
		if (!Objects.equals(this.estimateOthChTaxableModels, other.estimateOthChTaxableModels))
		{
			return false;
		}
		if (!Objects.equals(this.estimateOthChNonTaxModels, other.estimateOthChNonTaxModels))
		{
			return false;
		}
		return true;
	}

}
