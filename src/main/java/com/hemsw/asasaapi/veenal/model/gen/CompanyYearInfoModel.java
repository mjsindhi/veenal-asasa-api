package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info")
public class CompanyYearInfoModel
{

	public enum Key
	{
		CompanyName("company_name"),
		BusiInfo("busi_info"),
		PersonName("person_name"),
		Address("address"),
		City("city"),
		StateId("state_id"),
		Pin("pin"),
		ContactNo("contact_no"),
		Email("email"),
		GSTNo("gst_no"),
		TnC("tnc"),
		BankDetails("bank_details"),
		Info("info"),
		LogoPath("logo_path"),
		LogoPath2("logo_path2");

		private final String name;

		private Key(String s)
		{
			name = s;
		}

		public String getName()
		{
			return name;
		}

		public boolean equalsName(String otherName)
		{
			// (otherName == null) check is not needed because name.equals(null) returns false 
			return name.equals(otherName);
		}

		@Override
		public String toString()
		{
			return this.name;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "info_key")
	private String infoKey;

	@Column(name = "info_value")
	private String infoValue;

	public int getId()
	{
		return id;
	}

	public String getInfoKey()
	{
		return infoKey;
	}

	public String getInfoValue()
	{
		return infoValue;
	}

	public void setInfoValue(String infoValue)
	{
		this.infoValue = infoValue;
	}

	public Key getKey()
	{
		for (CompanyYearInfoModel.Key key : Key.values())
		{
			if (infoKey.equals(key.getName()))
			{
				return key;
			}
		}
		return null;
	}

	public void setKey(Key key)
	{
		infoKey = key.getName();
	}
}
