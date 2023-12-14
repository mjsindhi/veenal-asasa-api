package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class PaymentLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "no")
	private String no;

	@Column(name = "date")
	private Date date;

	@Column(name = "from_acct_name")
	private String fromAcctName;

	@Column(name = "to_acct_name")
	private String toAcctName;

	@Column(name = "note")
	private String note;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "amt_clrd")
	private BigDecimal amtClrd;

	@Column(name = "amt_unclrd")
	private BigDecimal amtUnclrd;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getNo()
	{
		return no;
	}

	public Date getDate()
	{
		return date;
	}

	public String getFromAcctName()
	{
		return fromAcctName;
	}

	public String getToAcctName()
	{
		return toAcctName;
	}

	public String getNote()
	{
		return note;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public BigDecimal getAmtClrd()
	{
		return amtClrd;
	}

	public BigDecimal getAmtUnclrd()
	{
		return amtUnclrd;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}
}
