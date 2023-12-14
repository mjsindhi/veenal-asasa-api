package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class EstimatePendingProductHdto
{

	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "qty_total")
	private BigDecimal qtyTotal;

	public int getProductId()
	{
		return productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public BigDecimal getQtyTotal()
	{
		return qtyTotal;
	}

}
