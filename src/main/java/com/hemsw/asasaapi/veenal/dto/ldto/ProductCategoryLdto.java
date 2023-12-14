package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class ProductCategoryLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "note")
	private String note;

	@Column(name = "parent_name")
	private String parentName;

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

	public String getNote()
	{
		return note;
	}

	public String getParentName()
	{
		return parentName;
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
