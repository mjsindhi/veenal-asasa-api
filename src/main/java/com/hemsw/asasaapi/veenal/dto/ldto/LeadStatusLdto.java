package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.util.Date;

public class LeadStatusLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "is_default")
	private boolean isDefault;

	@Column(name = "is_closed")
	private boolean isClosed;

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

	public boolean isIsDefault()
	{
		return isDefault;
	}

	public boolean isIsClosed()
	{
		return isClosed;
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
