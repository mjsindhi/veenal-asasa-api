package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class CdpJournalVouLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "customer_acct_name")
	private String customerAcctName;

	@Column(name = "cdp_acct_name")
	private String cdpAcctName;

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

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getCustomerAcctName()
	{
		return customerAcctName;
	}

	public void setCustomerAcctName(String customerAcctName)
	{
		this.customerAcctName = customerAcctName;
	}

	public String getCdpAcctName()
	{
		return cdpAcctName;
	}

	public void setCdpAcctName(String cdpAcctName)
	{
		this.cdpAcctName = cdpAcctName;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
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
