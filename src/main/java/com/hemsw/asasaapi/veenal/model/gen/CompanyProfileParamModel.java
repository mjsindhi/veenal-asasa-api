package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_profile_param")
public class CompanyProfileParamModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "company_profile_id")
	private int companyProfileId;

	@Column(name = "param_id")
	private int paramId;

	@Column(name = "value")
	private String value;

	public CompanyProfileParamModel()
	{
	}

	public CompanyProfileParamModel(int paramId, String value)
	{
		this.paramId = paramId;
		this.value = value == null ? "" : value;
	}

	public CompanyProfileParamModel(int companyProfileId, int paramId, String value)
	{
		this.companyProfileId = companyProfileId;
		this.paramId = paramId;
		this.value = value;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCompanyProfileId()
	{
		return companyProfileId;
	}

	public void setCompanyProfileId(int companyProfileId)
	{
		this.companyProfileId = companyProfileId;
	}

	public int getParamId()
	{
		return paramId;
	}

	public void setParamId(int paramId)
	{
		this.paramId = paramId;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
