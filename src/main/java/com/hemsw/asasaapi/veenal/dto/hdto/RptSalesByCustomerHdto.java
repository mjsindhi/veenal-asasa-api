package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class RptSalesByCustomerHdto
{

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_cnt")
	private Integer customerCnt;

	@Column(name = "city_cnt")
	private Integer cityCnt;

	@Column(name = "state_cnt")
	private Integer stateCnt;

	@Column(name = "agent_cnt")
	private Integer agentCnt;

	@Column(name = "year_cnt")
	private Integer yearCnt;

	@Column(name = "month_cnt")
	private Integer monthCnt;

	@Column(name = "day_cnt")
	private Integer dayCnt;

	@Column(name = "sales_cnt")
	private Integer salesCnt;

	@Column(name = "prod_cnt")
	private Integer prodCnt;

	@Column(name = "sum_qty")
	private BigDecimal sumQty;

	@Column(name = "sum_item_val")
	private BigDecimal sumItemVal;

	@Column(name = "sum_amt_payable")
	private BigDecimal sumAmtPayable;

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

	public Integer getCustomerCnt()
	{
		return customerCnt;
	}

	public void setCustomerCnt(Integer customerCnt)
	{
		this.customerCnt = customerCnt;
	}

	public Integer getCityCnt()
	{
		return cityCnt;
	}

	public void setCityCnt(Integer cityCnt)
	{
		this.cityCnt = cityCnt;
	}

	public Integer getStateCnt()
	{
		return stateCnt;
	}

	public void setStateCnt(Integer stateCnt)
	{
		this.stateCnt = stateCnt;
	}

	public Integer getAgentCnt()
	{
		return agentCnt;
	}

	public void setAgentCnt(Integer agentCnt)
	{
		this.agentCnt = agentCnt;
	}

	public Integer getYearCnt()
	{
		return yearCnt;
	}

	public void setYearCnt(Integer yearCnt)
	{
		this.yearCnt = yearCnt;
	}

	public Integer getMonthCnt()
	{
		return monthCnt;
	}

	public void setMonthCnt(Integer monthCnt)
	{
		this.monthCnt = monthCnt;
	}

	public Integer getDayCnt()
	{
		return dayCnt;
	}

	public void setDayCnt(Integer dayCnt)
	{
		this.dayCnt = dayCnt;
	}

	public Integer getSalesCnt()
	{
		return salesCnt;
	}

	public void setSalesCnt(Integer salesCnt)
	{
		this.salesCnt = salesCnt;
	}

	public Integer getProdCnt()
	{
		return prodCnt;
	}

	public void setProdCnt(Integer prodCnt)
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

	public BigDecimal getSumAmtPayable()
	{
		return sumAmtPayable;
	}

	public void setSumAmtPayable(BigDecimal sumAmtPayable)
	{
		this.sumAmtPayable = sumAmtPayable;
	}

}
