package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agent")
public class AgentModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name_to_print")
	private String nameToPrint;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state_id")
	private Integer stateId;

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

	@Column(name = "old_id")
	private Integer oldId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNameToPrint()
	{
		return nameToPrint;
	}

	public void setNameToPrint(String nameToPrint)
	{
		this.nameToPrint = nameToPrint;
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

	public Integer getOldId()
	{
		return oldId;
	}

	public void setOldId(Integer oldId)
	{
		this.oldId = oldId;
	}

}
