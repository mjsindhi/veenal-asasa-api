package com.hemsw.asasaapi.veenal.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class NextNoResDto
{

	@JsonProperty("no")
	private String no;

	public NextNoResDto(String no)
	{
		this.no = no;
	}

}
