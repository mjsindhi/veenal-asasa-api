package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.dto.hdto.SalesOrderItemPendingHdto;
import com.hemsw.asasaapi.veenal.model.gen.SalesOrderModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;

public class SalesOrderPendingItemHoDto
{

	private VoucherModel voucherModel;
	private SalesOrderModel salesOrderModel;
	private List<SalesOrderItemPendingHdto> salesOrderItemPendingHdtos;

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

	public List<SalesOrderItemPendingHdto> getSalesOrderItemPendingHdtos()
	{
		return salesOrderItemPendingHdtos;
	}

	public void setSalesOrderItemPendingHdtos(List<SalesOrderItemPendingHdto> salesOrderItemPendingHdtos)
	{
		this.salesOrderItemPendingHdtos = salesOrderItemPendingHdtos;
	}

}
