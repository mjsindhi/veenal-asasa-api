package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class DayBookLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "no")
	private String no;

	@Column(name = "voucher_type_id")
	private Integer voucherTypeId;

	@Column(name = "acct_name")
	private String acctName;

	@Column(name = "amt")
	private BigDecimal amt;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public Date getDate()
	{
		return date;
	}

	public String getNo()
	{
		return no;
	}

	public Integer getVoucherTypeId()
	{
		return voucherTypeId;
	}

	public String getAcctName()
	{
		return acctName;
	}

	public BigDecimal getAmt()
	{
		return amt;
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
