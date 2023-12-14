package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.PurchaseOrderItemModel;
import com.hemsw.asasaapi.veenal.model.gen.PurchaseOrderModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;

public class PurchaseOrderHoDto
{

	private VoucherModel voucherModel;
	private PurchaseOrderModel purchaseOrderModel;
	private List<PurchaseOrderItemModel> purchaseOrderItemModels;

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public PurchaseOrderModel getPurchaseOrderModel()
	{
		return purchaseOrderModel;
	}

	public void setPurchaseOrderModel(PurchaseOrderModel purchaseOrderModel)
	{
		this.purchaseOrderModel = purchaseOrderModel;
	}

	public List<PurchaseOrderItemModel> getPurchaseOrderItemModels()
	{
		return purchaseOrderItemModels;
	}

	public void setPurchaseOrderItemModels(List<PurchaseOrderItemModel> purchaseOrderItemModels)
	{
		this.purchaseOrderItemModels = purchaseOrderItemModels;
	}

}
