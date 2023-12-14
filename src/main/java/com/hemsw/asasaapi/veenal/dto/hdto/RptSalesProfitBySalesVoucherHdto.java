package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class RptSalesProfitBySalesVoucherHdto
{

	@Column(name = "sales_id")
	private int salesId;

	@Column(name = "date")
	private Date date;

	@Column(name = "no")
	private String no;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "prod_cnt")
	private int prodCnt;

	@Column(name = "profit_amt")
	private BigDecimal profitAmt;

	@Column(name = "profit_percent")
	private BigDecimal profitPercent;

	public int getSalesId()
	{
		return salesId;
	}

	public void setSalesId(int salesId)
	{
		this.salesId = salesId;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

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
