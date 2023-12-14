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
@Table(name = "state")
public class StateModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code_name")
	private String codeName;

	@Column(name = "code_no")
	private int codeNo;

	@Column(name = "country_id")
	private int countryId;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

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

	public String getCodeName()
	{
		return codeName;
	}

	public void setCodeName(String codeName)
	{
		this.codeName = codeName;
	}

	public int getCodeNo()
	{
		return codeNo;
	}

	public void setCodeNo(int codeNo)
	{
		this.codeNo = codeNo;
	}

	public int getCountryId()
	{
		return countryId;
	}

	public void setCountryId(int countryId)
	{
		this.countryId = countryId;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId)
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
