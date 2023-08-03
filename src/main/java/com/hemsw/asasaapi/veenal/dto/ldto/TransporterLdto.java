package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import org.springframework.data.annotation.Immutable;

@Entity
@Immutable
public class TransporterLdto
{

	@Id
	private int id;

	private String name;

	private String transporterId;

	private String createdByUserName;

	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getTransporterId()
	{
		return transporterId;
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
