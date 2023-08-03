package com.hemsw.asasaapi.veenal.enums;

import java.util.ArrayList;
import java.util.List;

public enum UnitOperatorType
{
	DIVIDE(1, "Divide", "/"),
	MULTIPLY(2, "Multiply", "X");

	private final int id;
	private final String name;
	private final String symbol;

	UnitOperatorType(final int id, final String name, final String symbol)
	{
		this.id = id;
		this.name = name;
		this.symbol = symbol;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public static UnitOperatorType getById(int id)
	{
		for (UnitOperatorType txType : UnitOperatorType.values())
		{
			if (txType.id == id)
			{
				return txType;
			}
		}

		return null;
	}

	public static UnitOperatorType getByName(String name)
	{
		for (UnitOperatorType txType : UnitOperatorType.values())
		{
			if (txType.name.equals(name))
			{
				return txType;
			}
		}

		return null;
	}

	public static UnitOperatorType getBySymbol(String symbol)
	{
		for (UnitOperatorType txType : UnitOperatorType.values())
		{
			if (txType.symbol.equals(symbol))
			{
				return txType;
			}
		}
		return null;
	}

	public static List<String> getSymbols()
	{
		List<String> symbols = new ArrayList<>();
		for (UnitOperatorType txType : UnitOperatorType.values())
		{
			symbols.add(txType.getSymbol());
		}
		return symbols;
	}

}
