package com.hemsw.asasaapi.veenal.model.gen;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_info")
public class DbInfoModel
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "key")
	private String key;

	@Column(name = "value")
	private String value;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	//
	public enum KeyType
	{
		VERSION("version"),
		UPDATE_STATUS("update_status"),
		UPDATE_TO_VERSION("update_to_version"),
		STEP_UPDATED("step_updated"),
		THIS_MNTH("this_mnth"),;

		private final String name;

		private KeyType(String s)
		{
			name = s;
		}

		public String getName()
		{
			return name;
		}
	}

	public KeyType getKeyType()
	{
		for (KeyType keyType : KeyType.values())
		{
			if (keyType.getName().equals(key))
			{
				return keyType;
			}
		}
		return null;
	}

	public void setKeyType(KeyType keyType)
	{
		key = keyType.getName();
	}
}
