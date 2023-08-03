package com.hemsw.asasaapi.veenal.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil
{

	public static String getString(Exception ex)
	{
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public static String getString(Throwable ex)
	{
		StringWriter sw = new StringWriter();
		ex.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
}
