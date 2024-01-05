package com.hemsw.asasaapi.veenal.dto.res;

import lombok.Getter;

@Getter
public class TransporterResDto
{

	private String name;
	private String transporterId;

	public TransporterResDto(String name, String transporterId)
	{
		this.name = name;
		this.transporterId = transporterId;
	}

}
