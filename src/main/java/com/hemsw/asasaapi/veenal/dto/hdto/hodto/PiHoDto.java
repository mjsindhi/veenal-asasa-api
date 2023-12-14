package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.IPusaItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChNonTaxable;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChOnItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChTaxable;
import com.hemsw.asasaapi.veenal.model.gen.PiItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PiModel;
import com.hemsw.asasaapi.veenal.model.gen.PiOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.PiOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PiOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;

public class PiHoDto
{

	private PiModel piModel;
	private VoucherModel voucherModel;
	private List<PiItemModel> piItemModels;
	private List<PiOthChOnItemModel> piOthChOnItemModels;
	private List<PiOthChTaxableModel> piOthChTaxableModels;
	private List<PiOthChModel> piOthChNonTaxModels;

	public PiModel getPiModel()
	{
		return piModel;
	}

	public void setPiModel(PiModel piModel)
	{
		this.piModel = piModel;
	}

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public List<PiItemModel> getPiItemModels()
	{
		return piItemModels;
	}

	public void setPiItemModels(List<PiItemModel> piItemModels)
	{
		this.piItemModels = piItemModels;
	}

	public List<PiOthChOnItemModel> getPiOthChOnItemModels()
	{
		return piOthChOnItemModels;
	}

	public void setPiOthChOnItemModels(List<PiOthChOnItemModel> piOthChOnItemModels)
	{
		this.piOthChOnItemModels = piOthChOnItemModels;
	}

	public List<PiOthChTaxableModel> getPiOthChTaxableModels()
	{
		return piOthChTaxableModels;
	}

	public void setPiOthChTaxableModels(List<PiOthChTaxableModel> piOthChTaxableModels)
	{
		this.piOthChTaxableModels = piOthChTaxableModels;
	}

	public List<PiOthChModel> getPiOthChNonTaxModels()
	{
		return piOthChNonTaxModels;
	}

	public void setPiOthChNonTaxModels(List<PiOthChModel> piOthChNonTaxModels)
	{
		this.piOthChNonTaxModels = piOthChNonTaxModels;
	}

	public void setPusaItems(List<? extends IPusaItem> iPusaItems)
	{
		this.getPiItemModels().clear();
		for (IPusaItem iPusaItem : iPusaItems)
		{
			this.getPiItemModels().add((PiItemModel) iPusaItem);
		}
	}

	public void setPusaOthChOnItem(List<? extends IPusaOthChOnItem> iPusaOthChOnItems)
	{
		this.getPiOthChOnItemModels().clear();
		for (IPusaOthChOnItem iPusaOthChOnItem : iPusaOthChOnItems)
		{
			this.getPiOthChOnItemModels().add((PiOthChOnItemModel) iPusaOthChOnItem);
		}
	}

	public void setPusaOthChTaxable(List<? extends IPusaOthChTaxable> iPusaOthChTaxables)
	{
		this.getPiOthChTaxableModels().clear();
		for (IPusaOthChTaxable iPusaOthChTaxable : iPusaOthChTaxables)
		{
			this.getPiOthChTaxableModels().add((PiOthChTaxableModel) iPusaOthChTaxable);
		}
	}

	public void setPusaOthChNonTaxable(List<? extends IPusaOthChNonTaxable> iPusaOthChNonTaxables)
	{
		this.getPiOthChNonTaxModels().clear();
		for (IPusaOthChNonTaxable iPusaOthChNonTaxable : iPusaOthChNonTaxables)
		{
			this.getPiOthChNonTaxModels().add((PiOthChModel) iPusaOthChNonTaxable);
		}
	}

}
