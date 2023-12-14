package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class RptEstimatePendingDetHdto
{

	@Column(name = "estimate_id")
	private int estimateId;

	@Column(name = "date")
	private Date date;

	@Column(name = "no")
	private String no;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "current_stock_qty")
	private BigDecimal currentStockQty;

	public int getEstimateId()
	{
		return estimateId;
	}

	public void setEstimateId(int estimateId)
	{
		this.estimateId = estimateId;
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

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public BigDecimal getQty()
	{
		return qty;
	}

	public void setQty(BigDecimal qty)
	{
		this.qty = qty;
	}

	public BigDecimal getCurrentStockQty()
	{
		return currentStockQty;
	}

	public void setCurrentStockQty(BigDecimal currentStockQty)
	{
		this.currentStockQty = currentStockQty;
	}

}
