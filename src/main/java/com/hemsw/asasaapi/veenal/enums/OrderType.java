package com.hemsw.asasaapi.veenal.enums;

public enum OrderType
{
	PURCHASE(1, "Purchase"),
	SALES(2, "Sales"),;

	private final int id;
	private final String name;

	private OrderType(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public static OrderType getByName(String name)
	{
		for (OrderType orderType : OrderType.values())
		{
			if (orderType.getName().equals(name))
			{
				return orderType;
			}
		}
		return null;
	}

	public static OrderType getById(int id)
	{
		for (OrderType orderType : OrderType.values())
		{
			if (orderType.getId() == id)
			{
				return orderType;
			}
		}
		return null;
	}

}
