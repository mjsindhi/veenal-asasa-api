package com.hemsw.asasaapi.veenal;

import java.util.List;

public class SqlHelper
{

	public static String putSelects(List<String> wheres)
	{
		String sql = "SELECT";
		for (int i = 0; i < wheres.size(); i++)
		{
			if (i == 0)
			{
				sql = sql + " " + wheres.get(i);
			}
			else
			{
				sql = sql + ", " + wheres.get(i);
			}
		}
		return sql;
	}

	public static String putOrderBys(List<String> orderBys)
	{
		if (orderBys == null || orderBys.isEmpty())
		{
			return "";
		}

		String sql = " ORDER BY ";
		for (int i = 0; i < orderBys.size(); i++)
		{
			if (i == 0)
			{
				sql = sql + " " + orderBys.get(i);
			}
			else
			{
				sql = sql + ", " + orderBys.get(i);
			}
		}
		return sql;
	}

	public static String putFrom(String from, String sql)
	{
		return sql.trim() + " FROM " + from.trim();
	}

	public static String putGroupBys(List<String> groupBys, String sql)
	{
		int index = 0;
		while (index < groupBys.size())
		{
			String where = groupBys.get(index);

			if (index == 0)
			{
				sql = sql + " GROUP BY " + where;
			}
			else
			{
				sql = sql + " , " + where;
			}

			index++;
		}
		return sql;
	}

	public static String putWheres(List<String> wheres, String sql)
	{
		int index = 0;
		while (index < wheres.size())
		{
			String where = wheres.get(index);

			if (index == 0)
			{
				sql = sql + " WHERE " + where;
			}
			else
			{
				sql = sql + " AND " + where;
			}

			index++;
		}
		return sql;
	}

	public static String putHavings(List<String> wheres, String sql)
	{
		int index = 0;
		while (index < wheres.size())
		{
			String where = wheres.get(index);

			if (index == 0)
			{
				sql = sql + " HAVING " + where;
			}
			else
			{
				sql = sql + " AND " + where;
			}

			index++;
		}
		return sql;
	}

	public static String putOrderBys(List<String> orderBys, String sql)
	{
		int index = 0;
		while (index < orderBys.size())
		{
			String orderBy = orderBys.get(index);

			if (index == 0)
			{
				sql = sql + " ORDER BY " + orderBy;
			}
			else
			{
				sql = sql + ", " + orderBy;
			}

			index++;
		}
		return sql;
	}

	public static String putWhereTrial(String sql, String wheresString)
	{
		if (wheresString == null || wheresString.isEmpty())
		{
			return sql;
		}
		else
		{
			return sql + " WHERE " + wheresString;
		}
	}

	public static String putAnd(List<String> conditions)
	{
		String sql = "";
		int index = 0;
		while (index < conditions.size())
		{
			String where = conditions.get(index);

			if (index == 0)
			{
				sql = where;
			}
			else
			{
				sql = sql + " AND " + where;
			}

			index++;
		}
		return sql.isEmpty() ? "" : "(" + sql + ")";
	}

	public static String putOr(List<String> conditions)
	{
		String sql = "";
		int index = 0;
		while (index < conditions.size())
		{
			String condition = conditions.get(index);

			if (index == 0)
			{
				sql = condition;
			}
			else
			{
				sql = sql + " OR " + condition;
			}

			index++;
		}
		return sql.isEmpty() ? "" : "(" + sql + ")";
	}

	public static String getCsv(List<Integer> integers)
	{
		String csv = "";
		int count = 0;
		for (Integer integer : integers)
		{
			if (count == 0)
			{
				csv += String.valueOf(integer);
			}
			else
			{
				csv += ", " + String.valueOf(integer);
			}
			count++;
		}

		return csv;
	}

	public static String escape(String str)
	{
		str = str.replace("'", "''");
		str = str.replace("\\", "\\\\");
		return str;
	}

}
