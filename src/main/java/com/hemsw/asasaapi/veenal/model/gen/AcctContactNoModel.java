package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "acct_contact_no")
public class AcctContactNoModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seq_no")
	private int seqNo;

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "name")
	private String name;

	@Column(name = "no")
	private String no;

	@Column(name = "is_whatsapp")
	private boolean isWhatsapp;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSeqNo()
	{
		return seqNo;
	}

	public void setSeqNo(int seqNo)
	{
		this.seqNo = seqNo;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public boolean isIsWhatsapp()
	{
		return isWhatsapp;
	}

	public void setIsWhatsapp(boolean isWhatsapp)
	{
		this.isWhatsapp = isWhatsapp;
	}

}
