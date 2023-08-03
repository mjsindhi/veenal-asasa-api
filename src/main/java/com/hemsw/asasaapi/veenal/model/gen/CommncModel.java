package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "commnc")
public class CommncModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "parent_type_id")
	private int parentTypeId;

	@Column(name = "lead_id")
	private Integer leadId;

	@Column(name = "acct_id")
	private Integer acctId;

	@Column(name = "is_on")
	private boolean isOn;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

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

	public int getParentTypeId()
	{
		return parentTypeId;
	}

	public void setParentTypeId(int parentTypeId)
	{
		this.parentTypeId = parentTypeId;
	}

	public Integer getLeadId()
	{
		return leadId;
	}

	public void setLeadId(Integer leadId)
	{
		this.leadId = leadId;
	}

	public Integer getAcctId()
	{
		return acctId;
	}

	public void setAcctId(Integer acctId)
	{
		this.acctId = acctId;
	}

	public boolean isIsOn()
	{
		return isOn;
	}

	public void setIsOn(boolean isOn)
	{
		this.isOn = isOn;
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
