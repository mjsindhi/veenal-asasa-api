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
public class LoginResDto
{

	private String accessToken;
	private String tokenType;
	private int expiresIn;
	private String refreshToken;
}
