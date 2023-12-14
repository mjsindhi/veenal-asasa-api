package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptIoSummByProdHdto
{

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "qty_in")
	private BigDecimal qtyIn;

	@Column(name = "qty_out")
	private BigDecimal qtyOut;

	public int getProdId()
	{
		return prodId;
	}

	public void setProdId(int prodId)
	{
		this.prodId = prodId;
	}

	public String getProdName()
	{
		return prodName;
	}

	public void setProdName(String prodName)
	{
		this.prodName = prodName;
	}

	public BigDecimal getQtyIn()
	{
		return qtyIn;
	}

	public void setQtyIn(BigDecimal qtyIn)
	{
		this.qtyIn = qtyIn;
	}

	public BigDecimal getQtyOut()
	{
		return qtyOut;
	}

	public void setQtyOut(BigDecimal qtyOut)
	{
		this.qtyOut = qtyOut;
	}

}
