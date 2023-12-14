package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class PicklistItemHdto
{

	@Column(name = "product_id")
	private int productId;

	@Column(name = "order_qty")
	private BigDecimal orderQty;

	@Column(name = "order_unit_id")
	private int orderUnitId;

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public BigDecimal getOrderQty()
	{
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty)
	{
		this.orderQty = orderQty;
	}

	public int getOrderUnitId()
	{
		return orderUnitId;
	}

	public void setOrderUnitId(int orderUnitId)
	{
		this.orderUnitId = orderUnitId;
	}

}
