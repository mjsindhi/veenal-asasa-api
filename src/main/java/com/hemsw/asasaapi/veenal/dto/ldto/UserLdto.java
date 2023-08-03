package com.hemsw.asasaapi.veenal.dto.ldto;

import jakarta.persistence.Column;
import java.util.Date;
import java.util.Objects;

public class UserLdto
{

	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "email")
	private String email;

	@Column(name = "access_role_name")
	private String accessRoleName;

	@Column(name = "created_by_user_name")
	private String createdByUserName;

	@Column(name = "created_at")
	private Date createdAt;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getContactNo()
	{
		return contactNo;
	}

	public void setContactNo(String contactNo)
	{
		this.contactNo = contactNo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAccessRoleName()
	{
		return accessRoleName;
	}

	public void setAccessRoleName(String accessRoleName)
	{
		this.accessRoleName = accessRoleName;
	}

	public String getCreatedByUserName()
	{
		return createdByUserName;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 89 * hash + this.id;
		hash = 89 * hash + Objects.hashCode(this.name);
		hash = 89 * hash + Objects.hashCode(this.username);
		hash = 89 * hash + Objects.hashCode(this.password);
		hash = 89 * hash + Objects.hashCode(this.contactNo);
		hash = 89 * hash + Objects.hashCode(this.email);
		hash = 89 * hash + Objects.hashCode(this.accessRoleName);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final UserLdto other = (UserLdto) obj;
		if (this.id != other.id)
		{
			return false;
		}
		if (!Objects.equals(this.name, other.name))
		{
			return false;
		}
		if (!Objects.equals(this.username, other.username))
		{
			return false;
		}
		if (!Objects.equals(this.password, other.password))
		{
			return false;
		}
		if (!Objects.equals(this.contactNo, other.contactNo))
		{
			return false;
		}
		if (!Objects.equals(this.email, other.email))
		{
			return false;
		}
		if (!Objects.equals(this.accessRoleName, other.accessRoleName))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "UserLdto{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", contactNo=" + contactNo + ", email=" + email + ", accessRoleName=" + accessRoleName + '}';
	}

}
