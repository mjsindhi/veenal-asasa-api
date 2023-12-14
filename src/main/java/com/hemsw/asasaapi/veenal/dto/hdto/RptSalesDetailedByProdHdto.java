package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class RptSalesDetailedByProdHdto
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

	@Column(name = "city")
	private String city;

	@Column(name = "state_id")
	private int stateId;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "prod_cat_id")
	private Integer prodCatId;

	@Column(name = "prod_cat_name")
	private String prodCatName;

	@Column(name = "qty")
	private BigDecimal qty;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "item_val")
	private BigDecimal itemVal;

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

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public int getStateId()
	{
		return stateId;
	}

	public void setStateId(int stateId)
	{
		this.stateId = stateId;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
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

	public Integer getProdCatId()
	{
		return prodCatId;
	}

	public void setProdCatId(Integer prodCatId)
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

	public BigDecimal getItemVal()
	{
		return itemVal;
	}

	public void setItemVal(BigDecimal itemVal)
	{
		this.itemVal = itemVal;
	}

}
