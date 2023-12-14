package com.hemsw.asasaapi.veenal.service.gen;

import com.hemsw.asasaapi.veenal.model.app.AccessTokenModel;
import com.hemsw.asasaapi.veenal.model.app.RefreshTokenModel;
import com.hemsw.asasaapi.veenal.service.util.RandomStringUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.hemsw.asasaapi.veenal.repo.app.AccessTokenRepo;
import com.hemsw.asasaapi.veenal.repo.app.RefreshTokenRepo;

public class AuthSerImpl implements AuthSer
{

	@Autowired
	private AccessTokenRepo authRepo;

	@Autowired
	private RefreshTokenRepo refreshTokenRepo;

	@Override
	public void refresh(String oldToken, String refreshToken)
	{
		AccessTokenModel authModel = authRepo.findByToken(oldToken);

		if (authModel == null)
		{
			System.out.println("Invalid token");
		}

		Date nowDate = new Date();

		if (authModel.getExpiryAt().getTime() >= nowDate.getTime())
		{
			System.out.println("Token not yet expired no need to refresh");
		}

		RefreshTokenModel refreshTokenModel = refreshTokenRepo.findByToken(refreshToken);
		if (refreshTokenModel == null)
		{
			System.out.println("Invalid refresh token");
		}

		if (refreshTokenModel.getExpiryAt().getTime() <= nowDate.getTime())
		{
			System.out.println("Refresh token expired");
		}

		if (authModel.getUserId() != refreshTokenModel.getUserId())
		{
			System.out.println("Invalid token combination");
		}

		authModel = new AccessTokenModel()
				.setUserId(refreshTokenModel.getUserId())
				.setToken(RandomStringUtil.getAlphaNumString(100, ""))
				.setCreatedAt(nowDate)
				.setExpiryAt(new Date(nowDate.getTime() + (24 * 60 * 60 * 1000)));

		authRepo.save(authModel);
	}

	@Override
	public void verify(String token)
	{
		AccessTokenModel authModel = authRepo.findByToken(token);

		if (authModel == null)
		{
			System.out.println("Invalid token");
		}

		Date nowDate = new Date();

		if (authModel.getExpiryAt().getTime() < nowDate.getTime())
		{
			System.out.println("Token expired");
		}

	}

}
