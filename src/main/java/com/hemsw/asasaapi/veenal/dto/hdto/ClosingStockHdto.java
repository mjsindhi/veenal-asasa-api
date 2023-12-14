package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class ClosingStockHdto
{

	@Column(name = "product_id")
	private int productId;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "amt")
	private BigDecimal amt;

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
	}

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

}
