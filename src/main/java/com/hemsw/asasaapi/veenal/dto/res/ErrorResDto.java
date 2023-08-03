package com.hemsw.asasaapi.veenal.dto.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import lombok.ToString;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResDto
{

	private Date timestamp;
	private String code;
	private String message;
	private String details;

	public ErrorResDto(Date timestamp, String code, String message, String details)
	{
		this.timestamp = timestamp;
		this.code = code;
		this.message = message;
		this.details = details;
	}

}
