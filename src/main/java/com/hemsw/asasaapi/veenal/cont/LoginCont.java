package com.hemsw.asasaapi.veenal.cont;

import com.hemsw.asasaapi.veenal.dto.res.ErrorResDto;
import com.hemsw.asasaapi.veenal.dto.req.LoginReqDto;
import com.hemsw.asasaapi.veenal.dto.res.LoginResDto;
import com.hemsw.asasaapi.veenal.model.app.AccessTokenModel;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.repo.app.UserRepo;
import com.hemsw.asasaapi.veenal.service.gen.LoginSer;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hemsw.asasaapi.veenal.repo.app.AccessTokenRepo;

//@RequestMapping(path = "/login")
@RestController
@Tag(name = "Login")
public class LoginCont
{

	@Autowired
	LoginSer loginSer;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AccessTokenRepo authRepo;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginReqDto loginReqDto)
	{

		if (loginReqDto == null)
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto()
							.setCode("username_required")
							.setMessage("Enter username/phone number")
							.setDetails("Enter username/phone number")
					);
		}

		if (loginReqDto.getUsername() == null || loginReqDto.getUsername().isEmpty())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto()
							.setCode("username_required")
							.setMessage("Enter username/phone number")
							.setDetails("Enter username/phone number")
					);
		}

		if (loginReqDto.getPassword() == null || loginReqDto.getPassword().isEmpty())
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto()
							.setCode("password_required")
							.setMessage("Enter password")
							.setDetails("Enter password")
					);
		}

		UserModel userModel = userRepo.findByUsername(loginReqDto.getUsername());

		if (userModel == null)
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto()
							.setCode("username_not_found")
							.setMessage("Enter registered username/phone number")
							.setDetails("Enter registered username/phone number")
					);
		}

		if (!userModel.getPassword().equals(loginReqDto.getPassword()))
		{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResDto()
							.setCode("username_not_found")
							.setMessage("Enter registered username/phone number")
							.setDetails("Enter registered username/phone number")
					);
		}

		AccessTokenModel authModel = new AccessTokenModel();
		authModel.setUserId(userModel.getId());
		authModel.setToken(java.util.UUID.randomUUID().toString().replace("-", ""));

		authRepo.save(authModel);

		return ResponseEntity
				.ok(new LoginResDto()
						.setTokenType("bearer")
						.setAccessToken(authModel.getToken())
						.setExpiresIn(3600)
						.setRefreshToken(authModel.getToken())
				);

	}

}
