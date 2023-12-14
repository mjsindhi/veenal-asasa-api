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
public class AcctLdto
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

	@Column(name = "clear_upto")
	private Date clearUpto;

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

	public Date getClearUpto()
	{
		return clearUpto;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

//
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
