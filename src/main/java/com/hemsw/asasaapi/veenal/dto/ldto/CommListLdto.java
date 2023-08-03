package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.model.gen.CommListModel.CommOnType;
import jakarta.persistence.Column;
import java.util.Date;

public class CommListLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "comm_on_id")
	private int commOnId;

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

	public int getCommOnId()
	{
		return commOnId;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	// Custom Getter and setters
	public CommOnType getCommOnType()
	{
		for (CommOnType value : CommOnType.values())
		{
			if (value.getId() == commOnId)
			{
				return value;
			}
		}
		return null;
	}

	public void setCommOnType(CommOnType commOnType)
	{
		commOnId = commOnType.getId();
	}
}
