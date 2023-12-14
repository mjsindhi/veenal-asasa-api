package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.PurchaseItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseOthChModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseOthChTaxableModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;

public class PurchaseHoDto
{

	private VoucherModel voucherModel;
	private PurchaseModel purchaseModel;
	private List<PurchaseItemModel> purchaseItemModels;
	private List<PurchaseOthChTaxableModel> purchaseOthChTaxableModels;
	private List<PurchaseOthChModel> purchaseOthChNonTaxModels;

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public PurchaseModel getPurchaseModel()
	{
		return purchaseModel;
	}

	public void setPurchaseModel(PurchaseModel purchaseModel)
	{
		this.purchaseModel = purchaseModel;
	}

	public List<PurchaseItemModel> getPurchaseItemModels()
	{
		return purchaseItemModels;
	}

	public void setPurchaseItemModels(List<PurchaseItemModel> purchaseItemModels)
	{
		this.purchaseItemModels = purchaseItemModels;
	}

	public List<PurchaseOthChTaxableModel> getPurchaseOthChTaxableModels()
	{
		return purchaseOthChTaxableModels;
	}

	public void setPurchaseOthChTaxableModels(List<PurchaseOthChTaxableModel> purchaseOthChTaxableModels)
	{
		this.purchaseOthChTaxableModels = purchaseOthChTaxableModels;
	}

	public List<PurchaseOthChModel> getPurchaseOthChNonTaxModels()
	{
		return purchaseOthChNonTaxModels;
	}

	public void setPurchaseOthChNonTaxModels(List<PurchaseOthChModel> purchaseOthChNonTaxModels)
	{
		this.purchaseOthChNonTaxModels = purchaseOthChNonTaxModels;
	}

}
