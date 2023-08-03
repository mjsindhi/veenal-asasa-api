package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.enums.BalanceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import lombok.ToString;
import org.springframework.data.annotation.Immutable;

@ToString
@Entity
@Immutable
public class CustomerLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "acct_type_name")
	private String acctTypeName;

	@Column(name = "ob_type_id")
	private Integer obTypeId;

	@Column(name = "ob")
	private BigDecimal ob;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

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

	@Column(name = "pref_trans_name")
	private String prefTransName;

	@Column(name = "pref_agent_name")
	private String prefAgentName;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getAcctTypeName()
	{
		return acctTypeName;
	}

	public Integer getObTypeId()
	{
		return obTypeId;
	}

	public BigDecimal getOb()
	{
		return ob;
	}

	public String getAddress()
	{
		return address;
	}

	public String getCity()
	{
		return city;
	}

	public String getStateName()
	{
		return stateName;
	}

	public String getPin()
	{
		return pin;
	}

	public String getEmail()
	{
		return email;
	}

	public String getGstNo()
	{
		return gstNo;
	}

	public String getBankName()
	{
		return bankName;
	}

	public String getBankBranchName()
	{
		return bankBranchName;
	}

	public String getBankAcctName()
	{
		return bankAcctName;
	}

	public String getBankAcctNo()
	{
		return bankAcctNo;
	}

	public String getBankIfsc()
	{
		return bankIfsc;
	}

	public Integer getCreditDays()
	{
		return creditDays;
	}

	public BigDecimal getCreditAmtLimit()
	{
		return creditAmtLimit;
	}

	public String getPrefTransName()
	{
		return prefTransName;
	}

	public String getPrefAgentName()
	{
		return prefAgentName;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public BalanceType getObType()
	{
		if (obTypeId != null)
		{
			for (BalanceType value : BalanceType.values())
			{
				if (value.getId() == obTypeId)
				{
					return value;
				}
			}
		}
		return null;
	}

}
