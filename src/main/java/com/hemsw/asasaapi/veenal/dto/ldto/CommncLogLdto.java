package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.util.Date;

public class CommncLogLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "remark")
	private String remark;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public Date getDateTime()
	{
		return dateTime;
	}

	public String getRemark()
	{
		return remark;
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
