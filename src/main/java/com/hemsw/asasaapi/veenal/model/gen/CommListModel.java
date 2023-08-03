package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comm_list")
public class CommListModel
{

	public enum CommOnType
	{
		CAT(1, "Category"),
		PRODUCT(2, "Product");

		private final int id;
		private final String name;

		private CommOnType(int id, String name)
		{
			this.id = id;
			this.name = name;
		}

		public int getId()
		{
			return id;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "comm_on_id")
	private int commOnId;

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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCommOnId()
	{
		return commOnId;
	}

	public void setCommOnId(int commOnId)
	{
		this.commOnId = commOnId;
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

	// Custom Getter and setters
	public CommOnType getCommOnType()
	{
		for (CommListModel.CommOnType value : CommOnType.values())
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
