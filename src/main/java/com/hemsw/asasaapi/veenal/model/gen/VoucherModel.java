//chit, slip, note, voucher, record, instrument, document, log, page, file
package com.hemsw.asasaapi.veenal.model.gen;

import com.hemsw.asasaapi.veenal.enums.VoucherType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "voucher")
public class VoucherModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "no")
	private String no;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "parent_id2")
	private Integer parentId2;

	@Column(name = "voucher_type_id")
	private int voucherTypeId;

	@Column(name = "acct_id")
	private Integer acctId;

	@Column(name = "created_by_user_id")
	private Integer createdByUserId;

	@Transient
	@Column(name = "created_at")
	private Date createdAt;

	public VoucherModel()
	{
	}

	public VoucherModel(VoucherModel voucherModel, boolean isCopyId)
	{
		if (isCopyId)
		{
			this.id = voucherModel.id;
		}
		this.date = voucherModel.date;
		this.no = voucherModel.no;
		this.parentId = voucherModel.parentId;
		this.parentId2 = voucherModel.parentId2;
		this.voucherTypeId = voucherModel.voucherTypeId;
		this.acctId = voucherModel.acctId;
		this.createdByUserId = voucherModel.createdByUserId;
		this.createdAt = voucherModel.createdAt;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public Integer getParentId2()
	{
		return parentId2;
	}

	public void setParentId2(Integer parentId2)
	{
		this.parentId2 = parentId2;
	}

	public int getVoucherTypeId()
	{
		return voucherTypeId;
	}

	public void setVoucherTypeId(int voucherTypeId)
	{
		this.voucherTypeId = voucherTypeId;
	}

	public Integer getAcctId()
	{
		return acctId;
	}

	public void setAcctId(Integer acctId)
	{
		this.acctId = acctId;
	}

	public Integer getCreatedByUserId()
	{
		return createdByUserId;
	}

	public void setCreatedByUserId(Integer createdByUserId)
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

	//
	public VoucherType getVoucherType()
	{
		for (VoucherType value : VoucherType.values())
		{
			if (voucherTypeId == value.getId())
			{
				return value;
			}
		}
		return null;
	}

	public void setVoucherType(VoucherType voucherType)
	{
		this.voucherTypeId = voucherType.getId();
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 43 * hash + this.id;
		hash = 43 * hash + Objects.hashCode(this.date);
		hash = 43 * hash + Objects.hashCode(this.no);
		hash = 43 * hash + Objects.hashCode(this.parentId);
		hash = 43 * hash + Objects.hashCode(this.parentId2);
		hash = 43 * hash + this.voucherTypeId;
		hash = 43 * hash + Objects.hashCode(this.acctId);
		hash = 43 * hash + Objects.hashCode(this.createdByUserId);
		hash = 43 * hash + Objects.hashCode(this.createdAt);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final VoucherModel other = (VoucherModel) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (this.voucherTypeId != other.voucherTypeId)
		{
			return false;
		}
		if (!Objects.equals(this.no, other.no))
		{
			return false;
		}
		if (!Objects.equals(this.date, other.date))
		{
			return false;
		}
		if (!Objects.equals(this.parentId, other.parentId))
		{
			return false;
		}
		if (!Objects.equals(this.parentId2, other.parentId2))
		{
			return false;
		}
		if (!Objects.equals(this.acctId, other.acctId))
		{
			return false;
		}
		if (!Objects.equals(this.createdByUserId, other.createdByUserId))
		{
			return false;
		}
		if (!Objects.equals(this.createdAt, other.createdAt))
		{
			return false;
		}
		return true;
	}

}
