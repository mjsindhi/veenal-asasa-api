package com.hemsw.asasaapi.veenal.dto.hdto.hodto;

import com.hemsw.asasaapi.veenal.model.gen.OrderAdjustItemModel;
import com.hemsw.asasaapi.veenal.model.gen.OrderAdjustModel;
import com.hemsw.asasaapi.veenal.model.gen.VoucherModel;
import java.util.List;

public class OrderAdjustHoDto
{

	private VoucherModel voucherModel;
	private OrderAdjustModel orderAdjustModel;
	private List<OrderAdjustItemModel> orderAdjustItemModels;

	public VoucherModel getVoucherModel()
	{
		return voucherModel;
	}

	public void setVoucherModel(VoucherModel voucherModel)
	{
		this.voucherModel = voucherModel;
	}

	public OrderAdjustModel getOrderAdjustModel()
	{
		return orderAdjustModel;
	}

	public void setOrderAdjustModel(OrderAdjustModel orderAdjustModel)
	{
		this.orderAdjustModel = orderAdjustModel;
	}

	public List<OrderAdjustItemModel> getOrderAdjustItemModels()
	{
		return orderAdjustItemModels;
	}

	public void setOrderAdjustItemModels(List<OrderAdjustItemModel> orderAdjustItemModels)
	{
		this.orderAdjustItemModels = orderAdjustItemModels;
	}

}
