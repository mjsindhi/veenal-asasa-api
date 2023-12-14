package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class StateLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code_name")
	private String codeName;

	@Column(name = "code_no")
	private String codeNo;

	@Column(name = "country_id")
	private int countryId;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

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

	public String getCodeNo()
	{
		return codeNo;
	}

	public void setCodeNo(String codeNo)
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

	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName)
	{
		this.createdByUserName = createdByUserName;
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
