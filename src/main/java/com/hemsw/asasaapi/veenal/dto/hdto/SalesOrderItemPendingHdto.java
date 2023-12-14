package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class SalesOrderItemPendingHdto
{

	@Column(name = "product_id")
	private int productId;

	@Column(name = "desc")
	private String desc;

	@Column(name = "pending_qty")
	private BigDecimal pendingQty;

	public int getProductId()
	{
		return productId;
	}

	public String getDesc()
	{
		return desc;
	}

	public BigDecimal getPendingQty()
	{
		return pendingQty;
	}

}
