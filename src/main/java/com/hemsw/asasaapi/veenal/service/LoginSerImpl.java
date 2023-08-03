package com.hemsw.asasaapi.veenal.service;

import com.hemsw.asasaapi.veenal.model.app.AccessTokenModel;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.repo.app.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hemsw.asasaapi.veenal.repo.app.AccessTokenRepo;

@Service
public class LoginSerImpl implements LoginSer
{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AccessTokenRepo authRepo;

	@Override
	public boolean login(String username, String password, StringBuilder errorMsg)
	{

		if (username == null || username.isEmpty())
		{
			errorMsg.append("Enter username");
			return false;
		}

		if (password == null || password.isEmpty())
		{
			errorMsg.append("Enter password");
			return false;
		}

		UserModel userModel = userRepo.findByUsername(username);

		if (userModel == null)
		{
			errorMsg.append("Invalid username");
			return false;
		}

		if (!userModel.getPassword().equals(password))
		{
			errorMsg.append("Invalid username / password");
			return false;
		}

		AccessTokenModel authModel = new AccessTokenModel();
		authModel.setUserId(userModel.getId());
		authModel.setToken(java.util.UUID.randomUUID().toString());

		authRepo.save(authModel);
		return false;

		// return authModel;
	}

}
