package com.hemsw.asasaapi.veenal.dto.hdto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class AcctListForCustomerHdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "pin")
	private String pin;

	@Column(name = "email")
	private String email;

	@Column(name = "gst_no")
	private String gstNo;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_branch_name")
	private String bankBranchName;

	@Column(name = "bank_acct_name")
	private String bankAcctName;

	@Column(name = "bank_acct_no")
	private String bankAcctNo;

	@Column(name = "bank_ifsc")
	private String bankIfsc;

	@Column(name = "credit_days")
	private Integer creditDays;

	@Column(name = "credit_amt_limit")
	private BigDecimal creditAmtLimit;

	@Column(name = "disc")
	private BigDecimal disc;

	@Column(name = "pref_trans_id")
	private Integer prefTransId;

	@Column(name = "pref_trans_name")
	private String prefTransName;

	@Column(name = "note")
	private String note;

	@Column(name = "overdue_days")
	private Integer overdueDays;

	@Column(name = "overdue_amt")
	private BigDecimal overdueAmt;

	@Column(name = "sum_debit")
	private BigDecimal sumDebit;

	@Column(name = "sum_credit")
	private BigDecimal sumCredit;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Integer getStateId()
	{
		return stateId;
	}

	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;
	}

	public String getStateName()
	{
		return stateName;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin)
	{
		this.pin = pin;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getGstNo()
	{
		return gstNo;
	}

	public void setGstNo(String gstNo)
	{
		this.gstNo = gstNo;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getBankBranchName()
	{
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName)
	{
		this.bankBranchName = bankBranchName;
	}

	public String getBankAcctName()
	{
		return bankAcctName;
	}

	public void setBankAcctName(String bankAcctName)
	{
		this.bankAcctName = bankAcctName;
	}

	public String getBankAcctNo()
	{
		return bankAcctNo;
	}

	public void setBankAcctNo(String bankAcctNo)
	{
		this.bankAcctNo = bankAcctNo;
	}

	public String getBankIfsc()
	{
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc)
	{
		this.bankIfsc = bankIfsc;
	}

	public Integer getCreditDays()
	{
		return creditDays;
	}

	public void setCreditDays(Integer creditDays)
	{
		this.creditDays = creditDays;
	}

	public BigDecimal getCreditAmtLimit()
	{
		return creditAmtLimit;
	}

	public void setCreditAmtLimit(BigDecimal creditAmtLimit)
	{
		this.creditAmtLimit = creditAmtLimit;
	}

	public BigDecimal getDisc()
	{
		return disc;
	}

	public void setDisc(BigDecimal disc)
	{
		this.disc = disc;
	}

	public Integer getPrefTransId()
	{
		return prefTransId;
	}

	public void setPrefTransId(Integer prefTransId)
	{
		this.prefTransId = prefTransId;
	}

	public String getPrefTransName()
	{
		return prefTransName;
	}

	public void setPrefTransName(String prefTransName)
	{
		this.prefTransName = prefTransName;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Integer getOverdueDays()
	{
		return overdueDays;
	}

	public void setOverdueDays(Integer overdueDays)
	{
		this.overdueDays = overdueDays;
	}

	public BigDecimal getOverdueAmt()
	{
		return overdueAmt;
	}

	public void setOverdueAmt(BigDecimal overdueAmt)
	{
		this.overdueAmt = overdueAmt;
	}

	public BigDecimal getSumDebit()
	{
		return sumDebit;
	}

	public void setSumDebit(BigDecimal sumDebit)
	{
		this.sumDebit = sumDebit;
	}

	public BigDecimal getSumCredit()
	{
		return sumCredit;
	}

	public void setSumCredit(BigDecimal sumCredit)
	{
		this.sumCredit = sumCredit;
	}

}
