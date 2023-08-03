package com.hemsw.asasaapi.veenal.security;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hemsw.asasaapi.veenal.model.app.UserModel;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class UserDetailsImpl implements UserDetails
{

	private static final long serialVersionUID = 1L;

	private UserModel userModel;

//	@JsonIgnore
//	private String password;
	private Collection<? extends GrantedAuthority> authorities;

//	public UserDetailsImpl(int id, String username, String email, String password,
//			Collection<? extends GrantedAuthority> authorities)
//	{
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.authorities = authorities;
//	}
//	public UserDetailsImpl(int id, String username, String password)
//	{
//		this.id = id;
//		this.username = username;
//		this.password = password;
//	}
//	public static UserDetailsImpl build(UserModel userModel)
//	{
////		List<GrantedAuthority> authorities = user.getRoles().stream()
////				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
////				.collect(Collectors.toList());
//
//		return new UserDetailsImpl(
//				userModel.getId(),
//				userModel.getUsername(),
//				userModel.getPassword());
//	}
	public UserDetailsImpl(UserModel userModel)
	{
		this.userModel = userModel;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}

	public UserModel getUserModel()
	{
		return userModel;
	}

	@Override
	public String getPassword()
	{
		return "";
	}

	@Override
	public String getUsername()
	{
		return userModel.getUsername();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, userModel.getId());
	}
}
