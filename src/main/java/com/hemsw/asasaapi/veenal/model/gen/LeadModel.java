package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "lead_data")
public class LeadModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "state_id")
	private Integer stateId;

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

	@Column(name = "lead_src_id")
	private int leadSrcId;

	@Column(name = "lead_status_id")
	private int leadStatusId;

	@Column(name = "created_by_user_id")
	private Integer createdByUserId;

	@Transient
	@Column(name = "created_at")
	private Date createdAt;

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

	public String getContactPersonName()
	{
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName)
	{
		this.contactPersonName = contactPersonName;
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

	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin)
	{
		this.pin = pin;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getContactNo1()
	{
		return contactNo1;
	}

	public void setContactNo1(String contactNo1)
	{
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2()
	{
		return contactNo2;
	}

	public void setContactNo2(String contactNo2)
	{
		this.contactNo2 = contactNo2;
	}

	public String getContactNo3()
	{
		return contactNo3;
	}

	public void setContactNo3(String contactNo3)
	{
		this.contactNo3 = contactNo3;
	}

	public String getCompanyDetails()
	{
		return companyDetails;
	}

	public void setCompanyDetails(String companyDetails)
	{
		this.companyDetails = companyDetails;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public int getLeadSrcId()
	{
		return leadSrcId;
	}

	public void setLeadSrcId(int leadSrcId)
	{
		this.leadSrcId = leadSrcId;
	}

	public int getLeadStatusId()
	{
		return leadStatusId;
	}

	public void setLeadStatusId(int leadStatusId)
	{
		this.leadStatusId = leadStatusId;
	}

	public Integer getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(Integer createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

}
