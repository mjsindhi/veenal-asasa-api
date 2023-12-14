package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class OrderPendingByProductHdto
{

	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "acct_cnt")
	private Integer acctCnt;

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

	public Integer getAcctCnt()
	{
		return acctCnt;
	}

	public BigDecimal getQtyTotal()
	{
		return qtyTotal;
	}

}
