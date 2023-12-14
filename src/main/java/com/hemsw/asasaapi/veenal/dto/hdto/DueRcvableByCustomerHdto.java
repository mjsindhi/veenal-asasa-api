package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class DueRcvableByCustomerHdto
{

	@Column(name = "id")
	private int id;

	//Customer Details
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "credit_days")
	private Integer creditDays;

	@Column(name = "sum_amt")
	private BigDecimal sumAmt;

	public int getId()
	{
		return id;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public String getCity()
	{
		return city;
	}

	public String getStateName()
	{
		return stateName;
	}

	public Integer getCreditDays()
	{
		return creditDays;
	}

	public BigDecimal getSumAmt()
	{
		return sumAmt;
	}

}
