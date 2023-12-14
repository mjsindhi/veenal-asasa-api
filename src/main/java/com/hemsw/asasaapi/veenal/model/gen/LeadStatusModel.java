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
@Table(name = "lead_status")
public class LeadStatusModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "is_default")
	private boolean isDefault;

	@Column(name = "is_closed")
	private boolean isClosed;

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

	public boolean isIsDefault()
	{
		return isDefault;
	}

	public void setIsDefault(boolean isDefault)
	{
		this.isDefault = isDefault;
	}

	public boolean isIsClosed()
	{
		return isClosed;
	}

	public void setIsClosed(boolean isClosed)
	{
		this.isClosed = isClosed;
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
