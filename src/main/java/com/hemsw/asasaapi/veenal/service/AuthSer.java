package com.hemsw.asasaapi.veenal.service;

public interface AuthSer {

	public void verify(String token);

	public void refresh(String oldToken, String refreshToken);

}
