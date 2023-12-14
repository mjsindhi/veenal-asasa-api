package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class ReminderLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "parent_type_id")
	private int parentTypeId;

	@Column(name = "name")
	private String name;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "subject")
	private String subject;

	@Column(name = "is_on")
	private boolean isOn;

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

	public int getParentTypeId()
	{
		return parentTypeId;
	}

	public void setParentTypeId(int parentTypeId)
	{
		this.parentTypeId = parentTypeId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getDateTime()
	{
		return dateTime;
	}

	public void setDateTime(Date dateTime)
	{
		this.dateTime = dateTime;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public boolean isIsOn()
	{
		return isOn;
	}

	public void setIsOn(boolean isOn)
	{
		this.isOn = isOn;
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
