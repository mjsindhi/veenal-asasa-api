package com.hemsw.asasaapi.veenal.dto.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties
public class LoginReqDto
{

	private String username;
	private String password;
}
