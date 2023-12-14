package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.IPusaItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChNonTaxable;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChOnItem;
import com.hemsw.asasaapi.veenal.dto.hdto.IPusaOthChTaxable;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnOthChOnItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseReturnOthChTaxableModel;
import java.util.Date;
import java.util.List;

public class PurchaseReturnHoDto
{

	String no;
	Date date;
	private PurchaseReturnModel purchaseReturnModel;
	private List<PurchaseReturnItemModel> purchaseReturnItemModels;
	private List<PurchaseReturnOthChOnItemModel> purchaseReturnOthChOnItemModels;
	private List<PurchaseReturnOthChTaxableModel> purchaseReturnOthChTaxableModels;
	private List<PurchaseReturnOthChModel> purchaseReturnOthChNonTaxModels;

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

	public PurchaseReturnModel getPurchaseReturnModel()
	{
		return purchaseReturnModel;
	}

	public void setPurchaseReturnModel(PurchaseReturnModel purchaseReturnModel)
	{
		this.purchaseReturnModel = purchaseReturnModel;
	}

	public List<PurchaseReturnItemModel> getPurchaseReturnItemModels()
	{
		return purchaseReturnItemModels;
	}

	public void setPurchaseReturnItemModels(List<PurchaseReturnItemModel> purchaseReturnItemModels)
	{
		this.purchaseReturnItemModels = purchaseReturnItemModels;
	}

	public List<PurchaseReturnOthChOnItemModel> getPurchaseReturnOthChOnItemModels()
	{
		return purchaseReturnOthChOnItemModels;
	}

	public void setPurchaseReturnOthChOnItemModels(List<PurchaseReturnOthChOnItemModel> purchaseReturnOthChOnItemModels)
	{
		this.purchaseReturnOthChOnItemModels = purchaseReturnOthChOnItemModels;
	}

	public List<PurchaseReturnOthChTaxableModel> getPurchaseReturnOthChTaxableModels()
	{
		return purchaseReturnOthChTaxableModels;
	}

	public void setPurchaseReturnOthChTaxableModels(List<PurchaseReturnOthChTaxableModel> purchaseReturnOthChTaxableModels)
	{
		this.purchaseReturnOthChTaxableModels = purchaseReturnOthChTaxableModels;
	}

	public List<PurchaseReturnOthChModel> getPurchaseReturnOthChNonTaxModels()
	{
		return purchaseReturnOthChNonTaxModels;
	}

	public void setPurchaseReturnOthChNonTaxModels(List<PurchaseReturnOthChModel> purchaseReturnOthChNonTaxModels)
	{
		this.purchaseReturnOthChNonTaxModels = purchaseReturnOthChNonTaxModels;
	}

	public void setPusaItems(List<? extends IPusaItem> iPusaItems)
	{
		this.getPurchaseReturnItemModels().clear();
		for (IPusaItem iPusaItem : iPusaItems)
		{
			this.getPurchaseReturnItemModels().add((PurchaseReturnItemModel) iPusaItem);
		}
	}

	public void setPusaOthChOnItem(List<? extends IPusaOthChOnItem> iPusaOthChOnItems)
	{
		this.getPurchaseReturnOthChOnItemModels().clear();
		for (IPusaOthChOnItem iPusaOthChOnItem : iPusaOthChOnItems)
		{
			this.getPurchaseReturnOthChOnItemModels().add((PurchaseReturnOthChOnItemModel) iPusaOthChOnItem);
		}
	}

	public void setPusaOthChTaxable(List<? extends IPusaOthChTaxable> iPusaOthChTaxables)
	{
		this.getPurchaseReturnOthChTaxableModels().clear();
		for (IPusaOthChTaxable iPusaOthChTaxable : iPusaOthChTaxables)
		{
			this.getPurchaseReturnOthChTaxableModels().add((PurchaseReturnOthChTaxableModel) iPusaOthChTaxable);
		}
	}

	public void setPusaOthChNonTaxable(List<? extends IPusaOthChNonTaxable> iPusaOthChNonTaxables)
	{
		this.getPurchaseReturnOthChNonTaxModels().clear();
		for (IPusaOthChNonTaxable iPusaOthChNonTaxable : iPusaOthChNonTaxables)
		{
			this.getPurchaseReturnOthChNonTaxModels().add((PurchaseReturnOthChModel) iPusaOthChNonTaxable);
		}
	}

}
