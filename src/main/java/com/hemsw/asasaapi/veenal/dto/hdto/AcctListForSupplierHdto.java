package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;

public class AcctListForSupplierHdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "name_to_print")
	private String nameToPrint;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "pin")
	private String pin;

	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "credit_days")
	private Integer creditDays;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNameToPrint()
	{
		return nameToPrint;
	}

	public void setNameToPrint(String nameToPrint)
	{
		this.nameToPrint = nameToPrint;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Integer getStateId()
	{
		return stateId;
	}

	public void setStateId(Integer stateId)
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

	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin)
	{
		this.pin = pin;
	}

	public String getGstNo()
	{
		return gstNo;
	}

	public void setGstNo(String gstNo)
	{
		this.gstNo = gstNo;
	}

	public Integer getCreditDays()
	{
		return creditDays;
	}

	public void setCreditDays(Integer creditDays)
	{
		this.creditDays = creditDays;
	}

}
