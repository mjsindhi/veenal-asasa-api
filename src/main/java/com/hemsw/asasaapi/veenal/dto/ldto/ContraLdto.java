package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class ContraLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "from_acct_name")
	private String fromAcctName;

	@Column(name = "to_acct_name")
	private String toAcctName;

	@Column(name = "note")
	private String note;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getNo()
	{
		return no;
	}

	public Date getDate()
	{
		return date;
	}

	public String getFromAcctName()
	{
		return fromAcctName;
	}

	public String getToAcctName()
	{
		return toAcctName;
	}

	public String getNote()
	{
		return note;
	}

	public BigDecimal getAmt()
	{
		return amt;
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
