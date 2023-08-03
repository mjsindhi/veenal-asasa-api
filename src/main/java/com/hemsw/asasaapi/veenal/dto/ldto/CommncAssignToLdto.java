package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;

public class CommncAssignToLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	public int getId()
	{
		return id;
	}

	public int getUserId()
	{
		return userId;
	}

	public String getUserName()
	{
		return userName;
	}

}
