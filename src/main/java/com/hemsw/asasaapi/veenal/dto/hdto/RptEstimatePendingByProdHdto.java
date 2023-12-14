package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptEstimatePendingByProdHdto
{

	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "cnt_estimate")
	private Integer cntEstimate;

	@Column(name = "cnt_customer")
	private Integer cntCustomer;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "current_stock_qty")
	private BigDecimal currentStockQty;

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public Integer getCntEstimate()
	{
		return cntEstimate;
	}

	public void setCntEstimate(Integer cntEstimate)
	{
		this.cntEstimate = cntEstimate;
	}

	public Integer getCntCustomer()
	{
		return cntCustomer;
	}

	public void setCntCustomer(Integer cntCustomer)
	{
		this.cntCustomer = cntCustomer;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
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
