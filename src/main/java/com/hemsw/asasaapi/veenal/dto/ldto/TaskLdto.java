package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class TaskLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "subject")
	private String subject;

	@Column(name = "parent_type_id")
	private int parentTypeId;

	@Column(name = "lead_name")
	private String leadName;

	@Column(name = "acct_name")
	private String acctName;

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

	public Date getDateTime()
	{
		return dateTime;
	}

	public String getSubject()
	{
		return subject;
	}

	public int getParentTypeId()
	{
		return parentTypeId;
	}

	public String getLeadName()
	{
		return leadName;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public boolean isIsOn()
	{
		return isOn;
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
