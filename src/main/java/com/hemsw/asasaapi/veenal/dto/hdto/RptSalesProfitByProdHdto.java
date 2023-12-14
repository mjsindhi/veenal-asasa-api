package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptSalesProfitByProdHdto
{

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "sales_cnt")
	private int salesCnt;

	@Column(name = "customer_cnt")
	private int customerCnt;

	@Column(name = "profit_amt")
	private BigDecimal profitAmt;

	@Column(name = "profit_percent")
	private BigDecimal profitPercent;

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

	public int getSalesCnt()
	{
		return salesCnt;
	}

	public void setSalesCnt(int salesCnt)
	{
		this.salesCnt = salesCnt;
	}

	public int getCustomerCnt()
	{
		return customerCnt;
	}

	public void setCustomerCnt(int customerCnt)
	{
		this.customerCnt = customerCnt;
	}

	public BigDecimal getProfitAmt()
	{
		return profitAmt;
	}

	public void setProfitAmt(BigDecimal profitAmt)
	{
		this.profitAmt = profitAmt;
	}

	public BigDecimal getProfitPercent()
	{
		return profitPercent;
	}

	public void setProfitPercent(BigDecimal profitPercent)
	{
		this.profitPercent = profitPercent;
	}

}
