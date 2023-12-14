package com.hemsw.asasaapi.veenal.dto.ldto;

import com.hemsw.asasaapi.veenal.enums.BalanceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class BankLdto
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

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "ifsc")
	private String ifsc;

	@Column(name = "branch")
	private String branch;

	@Column(name = "note")
	private String note;

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

	public String getContactNo()
	{
		return contactNo;
	}

	public String getIfsc()
	{
		return ifsc;
	}

	public String getBranch()
	{
		return branch;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public String getNote()
	{
		return note;
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
