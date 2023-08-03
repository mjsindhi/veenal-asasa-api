package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.util.Date;

public class LeadLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "contact_person_name")
	private String contactPersonName;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "pin")
	private String pin;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_no_1")
	private String contactNo1;

	@Column(name = "contact_no_2")
	private String contactNo2;

	@Column(name = "contact_no_3")
	private String contactNo3;

	@Column(name = "company_details")
	private String companyDetails;

	@Column(name = "note")
	private String note;

	@Column(name = "lead_src_name")
	private String leadSrcName;

	@Column(name = "lead_status_name")
	private String leadStatusName;

	@Column(name = "is_commnc_on")
	private boolean isCommncOn;

	@Column(name = "last_remark")
	private String lastRemark;

	@Column(name = "last_remark_date")
	private Date lastRemarkDate;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getContactPersonName()
	{
		return contactPersonName;
	}

	public String getAddress()
	{
		return address;
	}

	public String getCity()
	{
		return city;
	}

	public String getStateName()
	{
		return stateName;
	}

	public String getPin()
	{
		return pin;
	}

	public String getEmail()
	{
		return email;
	}

	public String getContactNo1()
	{
		return contactNo1;
	}

	public String getContactNo2()
	{
		return contactNo2;
	}

	public String getContactNo3()
	{
		return contactNo3;
	}

	public String getCompanyDetails()
	{
		return companyDetails;
	}

	public String getNote()
	{
		return note;
	}

	public String getLeadSrcName()
	{
		return leadSrcName;
	}

	public String getLeadStatusName()
	{
		return leadStatusName;
	}

	public boolean isIsCommncOn()
	{
		return isCommncOn;
	}

	public String getLastRemark()
	{
		return lastRemark;
	}

	public Date getLastRemarkDate()
	{
		return lastRemarkDate;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

}
