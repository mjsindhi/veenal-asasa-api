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
@Table(name = "reminder")
public class ReminderModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "commnc_id")
	private int commncId;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "subject")
	private String subject;

	@Column(name = "is_on")
	private boolean isOn;

	@Column(name = "created_by_user_id")
	private Integer createdByUserId;

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

	public int getCommncId()
	{
		return commncId;
	}

	public void setCommncId(int commncId)
	{
		this.commncId = commncId;
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

	public Integer getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(Integer createdByUserId)
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
