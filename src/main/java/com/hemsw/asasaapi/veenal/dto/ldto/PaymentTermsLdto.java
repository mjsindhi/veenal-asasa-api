package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class PaymentTermsLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "value")
	private String value;

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

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
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
