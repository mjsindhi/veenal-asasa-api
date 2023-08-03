package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.TxType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "acct_journal")
public class AcctJournalModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "acct_id")
	private int acctId;

	@Column(name = "voucher_id")
	private Integer voucherId;

	@Column(name = "tx_type_id")
	private int txTypeId;

	@Column(name = "dr")
	private BigDecimal dr;

	@Column(name = "cr")
	private BigDecimal cr;

	public AcctJournalModel()
	{
	}

	public int getId()
	{
		return id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public int getAcctId()
	{
		return acctId;
	}

	public void setAcctId(int acctId)
	{
		this.acctId = acctId;
	}

	public Integer getVoucherId()
	{
		return voucherId;
	}

	public void setVoucherId(Integer voucherId)
	{
		this.voucherId = voucherId;
	}

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

	public BigDecimal getDr()
	{
		return dr;
	}

	public void setDr(BigDecimal dr)
	{
		this.dr = dr;
	}

	public BigDecimal getCr()
	{
		return cr;
	}

	public void setCr(BigDecimal cr)
	{
		this.cr = cr;
	}

}
