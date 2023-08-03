package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.TxType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "journal")
public class JournalModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "tx_type_id")
	private int txTypeId;

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "note")
	private String note;

	@Column(name = "is_add_comm")
	private boolean isAddComm;

	public JournalModel()
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

	public int getTxTypeId()
	{
		return txTypeId;
	}

	public void setTxTypeId(int txTypeId)
	{
		this.txTypeId = txTypeId;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
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

	public boolean isIsAddComm()
	{
		return isAddComm;
	}

	public void setIsAddComm(boolean isAddComm)
	{
		this.isAddComm = isAddComm;
	}

	//Custom Getters setters
	public TxType getTxType()
	{
		for (TxType txType : TxType.values())
		{
			if (txType.getId() == txTypeId)
			{
				return txType;
			}
		}
		return null;
	}

	public void setTxType(TxType txType)
	{
		this.txTypeId = txType.getId();
	}
}
