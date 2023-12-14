package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptIoSummByProdCatHdto
{

	@Column(name = "prod_cat_id")
	private int prodCatId;

	@Column(name = "prod_cat_name")
	private String prodCatName;

	@Column(name = "qty_in")
	private BigDecimal qtyIn;

	@Column(name = "qty_out")
	private BigDecimal qtyOut;

	public int getProdCatId()
	{
		return prodCatId;
	}

	public void setProdCatId(int prodCatId)
	{
		this.prodCatId = prodCatId;
	}

	public String getProdCatName()
	{
		return prodCatName;
	}

	public void setProdCatName(String prodCatName)
	{
		this.prodCatName = prodCatName;
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
