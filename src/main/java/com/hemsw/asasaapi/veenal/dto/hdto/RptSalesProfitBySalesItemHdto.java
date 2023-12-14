package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class RptSalesProfitBySalesItemHdto
{

	@Column(name = "sales_item_id")
	private int salesItemId;

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

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "effective_sales_rate")
	private BigDecimal effectiveSalesRate;

	@Column(name = "cost_price")
	private BigDecimal costPrice;

	@Column(name = "profit_amt")
	private BigDecimal profitAmt;

	@Column(name = "profit_percent")
	private BigDecimal profitPercent;

	public int getSalesItemId()
	{
		return salesItemId;
	}

	public void setSalesItemId(int salesItemId)
	{
		this.salesItemId = salesItemId;
	}

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

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
	}

	public BigDecimal getEffectiveSalesRate()
	{
		return effectiveSalesRate;
	}

	public void setEffectiveSalesRate(BigDecimal effectiveSalesRate)
	{
		this.effectiveSalesRate = effectiveSalesRate;
	}

	public BigDecimal getCostPrice()
	{
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice)
	{
		this.costPrice = costPrice;
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
