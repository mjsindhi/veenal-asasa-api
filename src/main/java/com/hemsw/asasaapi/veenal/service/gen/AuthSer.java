package com.hemsw.asasaapi.veenal.service.gen;

public interface AuthSer {

	public void verify(String token);

	public void refresh(String oldToken, String refreshToken);

}
