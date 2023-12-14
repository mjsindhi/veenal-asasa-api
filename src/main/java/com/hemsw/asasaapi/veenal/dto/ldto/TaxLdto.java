package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class TaxLdto
{

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "cgst")
	private BigDecimal cgst;

	@Column(name = "sgst")
	private BigDecimal sgst;

	@Column(name = "igst")
	private BigDecimal igst;

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

	public BigDecimal getCgst()
	{
		return cgst;
	}

	public BigDecimal getSgst()
	{
		return sgst;
	}

	public BigDecimal getIgst()
	{
		return igst;
	}

	public String getNote()
	{
		return note;
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
