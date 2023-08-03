package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "inv_adjust")
public class InvAdjustModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "adjust_type_id")
	private int adjustTypeId;

	@Column(name = "note")
	private String note;

	@Column(name = "in_amt")
	private BigDecimal inAmt;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getAdjustTypeId()
	{
		return adjustTypeId;
	}

	public void setAdjustTypeId(int adjustTypeId)
	{
		this.adjustTypeId = adjustTypeId;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public BigDecimal getInAmt()
	{
		return inAmt;
	}

	public void setInAmt(BigDecimal inAmt)
	{
		this.inAmt = inAmt;
	}

	//
	public AdjustType getAdjustType()
	{
		for (AdjustType adjustType : AdjustType.values())
		{
			if (adjustType.getId() == adjustTypeId)
			{
				return adjustType;
			}
		}
		return null;
	}

	public void setType(AdjustType adjustType)
	{
		this.adjustTypeId = adjustType.getId();
	}

	public enum AdjustType
	{
		STOCK(1, "Stock"),
		MFG(2, "Manufacturing");

		private final int id;
		private final String name;

		private AdjustType(int id, String name)
		{
			this.id = id;
			this.name = name;
		}

		public int getId()
		{
			return id;
		}

		public String getName()
		{
			return name;
		}

		public static AdjustType getByName(String name)
		{
			for (AdjustType adjustType : AdjustType.values())
			{
				if (name.equals(adjustType.getName()))
				{
					return adjustType;
				}
			}
			return null;
		}

		public static AdjustType getById(int id)
		{
			for (AdjustType adjustType : AdjustType.values())
			{
				if (id == adjustType.getId())
				{
					return adjustType;
				}
			}
			return null;
		}

	}

}
