package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class RptSalesDetailedByVoucherHdto
{

	@Column(name = "sales_id")
	private int salesId;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

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

	@Column(name = "prod_cnt")
	private int prodCnt;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "sum_item_val")
	private BigDecimal sumItemVal;

	@Column(name = "amt_payable")
	private BigDecimal amtPayable;

	public int getSalesId()
	{
		return salesId;
	}

	public void setSalesId(int salesId)
	{
		this.salesId = salesId;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
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

	public int getProdCnt()
	{
		return prodCnt;
	}

	public void setProdCnt(int prodCnt)
	{
		this.prodCnt = prodCnt;
	}

	public BigDecimal getSumQty()
	{
		return sumQty;
	}

	public void setSumQty(BigDecimal sumQty)
	{
		this.sumQty = sumQty;
	}

	public BigDecimal getSumItemVal()
	{
		return sumItemVal;
	}

	public void setSumItemVal(BigDecimal sumItemVal)
	{
		this.sumItemVal = sumItemVal;
	}

	public BigDecimal getAmtPayable()
	{
		return amtPayable;
	}

	public void setAmtPayable(BigDecimal amtPayable)
	{
		this.amtPayable = amtPayable;
	}

}
