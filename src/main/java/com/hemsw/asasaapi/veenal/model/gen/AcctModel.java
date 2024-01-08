package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.AccountType;
import com.hemsw.asasaapi.veenal.enums.BalanceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Table(name = "acct")
public class AcctModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "acct_type_id")
	private int acctTypeId;

	@Column(name = "can_delete")
	private boolean canDelete;

	@Column(name = "ob_type_id")
	private Integer obTypeId;

	@Column(name = "ob")
	private BigDecimal ob;

	@Column(name = "clear_upto")
	private Date clearUpto;

	@Column(name = "created_by_user_id")
	private int createdByUserId;

	@Transient
	@Column(name = "created_at")
	private Date createdAt;

	public AcctModel()
	{
	}

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

	public boolean isCanDelete()
	{
		return canDelete;
	}

	public int getAcctTypeId()
	{
		return acctTypeId;
	}

	public void setAcctTypeId(int acctTypeId)
	{
		this.acctTypeId = acctTypeId;
	}

	public void setCanDelete(boolean canDelete)
	{
		this.canDelete = canDelete;
	}

	public Integer getObTypeId()
	{
		return obTypeId;
	}

	public void setObTypeId(Integer obTypeId)
	{
		this.obTypeId = obTypeId;
	}

	public BigDecimal getOb()
	{
		return ob;
	}

	public void setOb(BigDecimal ob)
	{
		this.ob = ob;
	}

	public Date getClearUpto()
	{
		return clearUpto;
	}

	public void setClearUpto(Date clearUpto)
	{
		this.clearUpto = clearUpto;
	}

	public int getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId)
	{
		this.createdByUserId = createdByUserId;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	// Custom geter setter
	public AccountType getAcctType()
	{
		for (AccountType value : AccountType.values())
		{
			if (value.getId() == acctTypeId)
			{
				return value;
			}
		}
		return null;
	}

	public void setAcctType(AccountType accountType)
	{
		this.acctTypeId = accountType.getId();
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

	public void setObType(BalanceType obt)
	{
		this.obTypeId = obt == null ? null : obt.getId();
	}

}
