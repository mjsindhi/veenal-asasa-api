package com.hemsw.asasaapi.veenal.helper;

public class DaoHelper
{

	public static String SELECT_BY_ID_SQL = "SELECT * FROM %s WHERE id = %s";
	public static String SELECT_BY_NAME_SQL = "SELECT * FROM %s WHERE name = '%s'";
	public static String SELECT_ID_SQL = "SELECT id FROM %s";
	public static String SELECT_NAME_SQL = "SELECT name FROM %s";
	public static String SELECT_SQL = "SELECT * FROM %s";
	public static String DELETE_SQL = "DELETE FROM %s";
	public static String DELETE_BY_ID_SQL = "DELETE FROM %s WHERE id = %s";
}
