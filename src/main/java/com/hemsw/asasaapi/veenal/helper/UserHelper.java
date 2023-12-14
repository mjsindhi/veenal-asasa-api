package com.hemsw.asasaapi.veenal.helper;

import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserHelper
{

	public static UserDetailsImpl getUserDetailsImpl()
	{
		return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
