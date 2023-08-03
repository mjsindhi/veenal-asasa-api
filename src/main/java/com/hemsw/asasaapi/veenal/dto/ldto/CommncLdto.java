package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.util.Date;

public class CommncLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "parent_type_id")
	private int parentTypeId;

	@Column(name = "name")
	private String name;

	@Column(name = "is_on")
	private boolean isOn;

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

	public int getParentTypeId()
	{
		return parentTypeId;
	}

	public String getName()
	{
		return name;
	}

	public boolean isIsOn()
	{
		return isOn;
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
