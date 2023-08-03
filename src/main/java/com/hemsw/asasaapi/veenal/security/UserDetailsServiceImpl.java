package com.hemsw.asasaapi.veenal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hemsw.asasaapi.veenal.model.app.AccessTokenModel;
import com.hemsw.asasaapi.veenal.model.app.UserModel;
import com.hemsw.asasaapi.veenal.repo.app.AccessTokenRepo;
import com.hemsw.asasaapi.veenal.repo.app.UserRepo;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	AccessTokenRepo accessTokenRepo;

	@Autowired
	UserRepo userRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException
	{
		AccessTokenModel accessTokenModel = accessTokenRepo.findByToken(token);

		Optional<UserModel> userModel = userRepo.findById(accessTokenModel.getUserId());

		return new UserDetailsImpl(userModel.get());
	}

}
