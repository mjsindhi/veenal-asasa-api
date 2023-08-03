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

	@JsonProperty("access_token")
	private String accessToken;
        
	@JsonProperty("token_type")
	private String tokenType;
        
	@JsonProperty("expires_in")
	private int expiresIn;
        
	@JsonProperty("refresh_token")
	private String refreshToken;
}
