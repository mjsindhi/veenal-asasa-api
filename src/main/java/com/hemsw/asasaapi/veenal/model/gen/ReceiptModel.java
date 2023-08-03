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
@Table(name = "receipt")
public class ReceiptModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "from_acct_id")
	private int fromAcctId;

	@Column(name = "to_acct_id")
	private int toAcctId;

	@Column(name = "date")
	private Date date;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "note")
	private String note;

	@Column(name = "is_against_sales")
	private boolean isAgainstSales;

	@Column(name = "sales_id")
	private Integer salesId;

	public ReceiptModel()
	{
	}

	public ReceiptModel(ReceiptModel receiptModel, boolean copyId)
	{
		if (copyId)
		{
			this.id = receiptModel.id;
		}
		this.fromAcctId = receiptModel.fromAcctId;
		this.toAcctId = receiptModel.toAcctId;
		this.date = receiptModel.date;
		this.amount = receiptModel.amount;
		this.note = receiptModel.note;
		this.isAgainstSales = receiptModel.isAgainstSales;
		this.salesId = receiptModel.salesId;
	}

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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public boolean isIsAgainstSales()
	{
		return isAgainstSales;
	}

	public void setIsAgainstSales(boolean isAgainstSales)
	{
		this.isAgainstSales = isAgainstSales;
	}

	public Integer getSalesId()
	{
		return salesId;
	}

	public void setSalesId(Integer salesId)
	{
		this.salesId = salesId;
	}

}
