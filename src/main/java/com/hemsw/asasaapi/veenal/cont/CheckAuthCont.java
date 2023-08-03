package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/check_auth")
@Tag(name = "Authentication")
public class CheckAuthCont
{

	@GetMapping("/check1")
	public String check1()
	{
		return "check1";
	}

	@GetMapping("/check2")
	public String check()
	{

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel userModel = userDetailsImpl.getUserModel();

		System.out.println(userModel.toString());
		return "check2";
	}

	@GetMapping("/check3")
	@PreAuthorize("hasRole('USER')")
	public String check3()
	{
		return "check3";
	}
}
