package com.hemsw.asasaapi.veenal.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;

public class Util
{

	public enum Formats
	{
		APP_DATE("dd-MM-yyyy"),
		APP_DATE_LOOSE("d-M-y"),
		APP_DATE_LOOSE_SLASH("d/M/y"),
		APP_DATE_LOOSE_DOT("d.M.y"),
		APP_DATETIME("dd-MM-yyyy hh:mm:ss a"),
		DB_DATE("yyyy-MM-dd"),
		DB_DATETIME("yyyy-MM-dd HH:mm:ss"),
		US_SL("MM/dd/yy"),
		US_LOOSE("M/d/y"),
		US_DASH("M-d-y"),
		MSHO("dd MMM, yyyy");

		private final String name;

		private Formats(String s)
		{
			name = s;
		}

		@Override
		public String toString()
		{
			return this.name;
		}
	}

	public static String dateToString(Date date, Formats format)
	{
		return new SimpleDateFormat(format.toString()).format(date);
	}

	public static Date stringToDate(String date, Formats format)
	{
		try
		{
			Date objDate = new SimpleDateFormat(format.toString()).parse(date);
			return objDate;
		}
		catch (Exception ex)
		{
			//logger.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}

	public static LocalDate getLocalDate(Date date)
	{
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date getDate(LocalDate localDate)
	{
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		return date;
	}

	public static Date getDate(LocalDate localDate, String hour, String min, String ampm)
	{
		String dateString = String.valueOf(localDate.getDayOfMonth())
				+ "-" + String.valueOf(localDate.getMonthValue())
				+ "-" + String.valueOf(localDate.getYear())
				+ " " + String.valueOf(hour)
				+ ":" + String.valueOf(min)
				+ ":00"
				+ " " + ampm;

		return stringToDate(dateString, Formats.APP_DATETIME);
	}

	public static String getMonthName(int month)
	{
		String[] monthNames = new String[]
		{
			"Jan",
			"Feb",
			"Mar",
			"Apr",
			"May",
			"Jun",
			"Jul",
			"Aug",
			"Sep",
			"Oct",
			"Nov",
			"Dec",
		};

		if (month < 0 || month > 12)
		{
			return "";
		}

		return monthNames[month - 1];

	}

	public static String getMonthFullName(int month)
	{
		String[] monthNames = new String[]
		{
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December",
		};

		if (month < 0 || month > 12)
		{
			return "";
		}

		return monthNames[month - 1];

	}

	public static boolean mIsNetConnected(String vUrl)
	{
		try
		{
			URL url = new URL(vUrl);
			//System.out.println(url.getHost());
			HttpURLConnection con = (HttpURLConnection) url
					.openConnection();
			con.connect();
			if (con.getResponseCode() == 200)
			{
				//System.out.println("Connection established!!");
				return true;
			}

			return false;
		}
		catch (Exception ex)
		{
			//logger.log(Level.SEVERE, ex.getMessage(), ex);
			return false;
		}
	}

	public static boolean mIsNetConnected()
	{
		return Util.mIsNetConnected("https://www.google.com");
	}

	public static boolean isNumeric(String s)
	{
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	public static String readFile(String filePath) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public static boolean writeFile(String dataToBeWritten, String filePath) throws IOException
	{

		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		writer.write(dataToBeWritten);
		writer.close();

		return true;
	}

	public static List<String> readLinesFromFile(String filePath) throws IOException
	{
		return Files.readAllLines(Paths.get(filePath));
	}

	public static boolean isDouble(String s)
	{
		try
		{
			Double.parseDouble(s);
			return true;
		}
		catch (Exception e)
		{
		}

		return false;
	}

	public static boolean isInt(String str)
	{
		return str.matches("-?\\d+");
	}

	public static boolean isPositiveIntSigned(String str)
	{
		return str.matches("[+]?\\d+");
	}

	public static boolean isPositiveIntUnsigned(String str)
	{
		return str.matches("\\d+");
	}

	public static void copyFileUsingStream(File source, File dest) throws IOException
	{
		InputStream is = null;
		OutputStream os = null;
		try
		{
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0)
			{
				os.write(buffer, 0, length);
			}
		}
		finally
		{
			is.close();
			os.close();
		}
	}

	public static String formatString(String pattern, Map arguments)
	{
		Map<String, Object> entries = arguments;
		for (Map.Entry<String, Object> entry : entries.entrySet())
		{
			pattern = pattern.replace("{" + entry.getKey() + "}", String.valueOf(entry.getValue()));
		}

		return pattern;
	}

	public static String formatStringWithTag(String pattern, Map arguments)
	{
		Map<String, Object> entries = arguments;
		for (Map.Entry<String, Object> entry : entries.entrySet())
		{
			pattern = pattern.replace("<" + entry.getKey() + ">", String.valueOf(entry.getValue()));
		}

		return pattern;
	}

	public static String getCSV(int[] data)
	{
		String ids = "";
		int i = 0;
		while (i < data.length)
		{
			int no = data[i];
			if (i == 0)
			{
				ids = ids + String.valueOf(no);
			}
			else
			{
				ids = ids + ", " + String.valueOf(no);
			}
			i++;
		}

		return ids;
	}

	public static String getCSV(Integer[] data)
	{
		String ids = "";
		int i = 0;
		while (i < data.length)
		{
			int no = data[i];
			if (i == 0)
			{
				ids = ids + String.valueOf(no);
			}
			else
			{
				ids = ids + ", " + String.valueOf(no);
			}
			i++;
		}

		return ids;
	}

	public static String getCSV(List<String> data)
	{
		String ids = "";
		int i = 0;
		while (i < data.size())
		{
			String str = data.get(i);
			if (i == 0)
			{
				ids = ids + str;
			}
			else
			{
				ids = ids + ", " + str;
			}
			i++;
		}

		return ids;
	}

	public static String getCSVFromInt(List<Integer> data)
	{
		String ids = "";
		int i = 0;
		while (i < data.size())
		{
			int str = data.get(i);
			if (i == 0)
			{
				ids = ids + String.valueOf(str);
			}
			else
			{
				ids = ids + ", " + String.valueOf(str);
			}
			i++;
		}
		return ids;
	}

	public static int calculateAge(LocalDate birthDate)
	{
		LocalDate currentDate = LocalDate.now();
		if ((birthDate != null) && (currentDate != null))
		{
			return Period.between(birthDate, currentDate).getYears();
		}
		else
		{
			return 0;
		}
	}

	public static int getHour(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR);
		hour = hour == 0 ? 12 : hour;
		return hour;
	}

	public static int getMin(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int min = c.get(Calendar.MINUTE);
		return min;
	}

	public static String getAMPM(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String ampm = c.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
		return ampm;
	}

	public static int getRandomNumberInRange(int min, int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static int[] toArray(List<Integer> integerList)
	{
		int[] intArr = new int[integerList.size()];
		for (int i = 0; i < integerList.size(); i++)
		{
			intArr[i] = integerList.get(i);
		}
		return intArr;
	}

	public static String[] toStrArray(List<String> lst)
	{
		String[] strArr = new String[lst.size()];
		for (int i = 0; i < lst.size(); i++)
		{
			strArr[i] = lst.get(i);
		}
		return strArr;
	}

	/**
	 * Resizes an image to a absolute width and height (the image may not be
	 * proportional)
	 *
	 * @param inputImagePath Path of the original image
	 * @param outputImagePath Path to save the resized image
	 * @param scaledHeight	absolute height in pixels
	 * @throws IOException
	 */
	public static void resize(String inputImagePath,
			String outputImagePath, int scaledHeight)
			throws IOException
	{

		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);

		int scaledWidth;

		scaledWidth = inputImage.getWidth(null) * scaledHeight / inputImage.getHeight(null);

		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);

		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		//below three lines are for RenderingHints for better image quality at cost of higher processing time
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();

		// extracts extension of output file
		String formatName = outputImagePath.substring(outputImagePath
				.lastIndexOf(".") + 1);

		// writes to output file
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}

	public static File[] findFile(String dirName, String ext)
	{
		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter()
		{
			public boolean accept(File dir, String filename)
			{
				return filename.endsWith(ext);
			}
		});
	}

	public static final boolean compare(BigDecimal one, BigDecimal other)
	{
		if (one == null && other == null)
		{
			return true;
		}
		if (one != null && other != null)
		{
			if (one.scale() != other.scale())
			{
				if (one.scale() < other.scale())
				{
					return one.setScale(other.scale(), RoundingMode.HALF_UP).compareTo(other) == 0;
				}
				else
				{
					return one.compareTo(other.setScale(one.scale(), RoundingMode.HALF_UP)) == 0;
				}
			}
			else
			{
				return one.compareTo(other) == 0;
			}
		}
		return false;
	}

}
