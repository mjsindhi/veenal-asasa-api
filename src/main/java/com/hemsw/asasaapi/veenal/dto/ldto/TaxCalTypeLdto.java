package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class TaxCalTypeLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "rate")
	private BigDecimal rate;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

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

	public BigDecimal getRate()
	{
		return rate;
	}

	public void setRate(BigDecimal rate)
	{
		this.rate = rate;
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
