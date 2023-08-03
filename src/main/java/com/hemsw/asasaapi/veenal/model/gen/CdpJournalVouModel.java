package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cdp_journal_vou")
public class CdpJournalVouModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer_acct_id")
	private int customerAcctId;

	@Column(name = "cdp_acct_id")
	private int cdpAcctId;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "note")
	private String note;

	public CdpJournalVouModel()
	{
		note = "";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCustomerAcctId()
	{
		return customerAcctId;
	}

	public void setCustomerAcctId(int customerAcctId)
	{
		this.customerAcctId = customerAcctId;
	}

	public int getCdpAcctId()
	{
		return cdpAcctId;
	}

	public void setCdpAcctId(int cdpAcctId)
	{
		this.cdpAcctId = cdpAcctId;
	}

	public BigDecimal getAmt()
	{
		return amt;
	}

	public void setAmt(BigDecimal amt)
	{
		this.amt = amt;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

}
