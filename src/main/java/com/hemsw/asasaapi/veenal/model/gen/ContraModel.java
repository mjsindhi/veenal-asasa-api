package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "contra")
public class ContraModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "from_acct_id")
	private int fromAcctId;

	@Column(name = "to_acct_id")
	private int toAcctId;

	@Column(name = "note")
	private String note;

	@Column(name = "date")
	private Date date;

	@Column(name = "amt")
	private BigDecimal amt;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getFromAcctId()
	{
		return fromAcctId;
	}

	public void setFromAcctId(int fromAcctId)
	{
		this.fromAcctId = fromAcctId;
	}

	public int getToAcctId()
	{
		return toAcctId;
	}

	public void setToAcctId(int toAcctId)
	{
		this.toAcctId = toAcctId;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

}
