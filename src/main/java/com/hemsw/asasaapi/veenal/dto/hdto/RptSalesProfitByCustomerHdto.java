package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptSalesProfitByCustomerHdto
{

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "sales_cnt")
	private int salesCnt;

	@Column(name = "prod_cnt")
	private int prodCnt;

	@Column(name = "profit_amt")
	private BigDecimal profitAmt;

	@Column(name = "profit_percent")
	private BigDecimal profitPercent;

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public int getSalesCnt()
	{
		return salesCnt;
	}

	public void setSalesCnt(int salesCnt)
	{
		this.salesCnt = salesCnt;
	}

	public int getProdCnt()
	{
		return prodCnt;
	}

	public void setProdCnt(int prodCnt)
	{
		this.prodCnt = prodCnt;
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
