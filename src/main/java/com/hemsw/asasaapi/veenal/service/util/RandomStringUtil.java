package com.hemsw.asasaapi.veenal.service.util;

public class RandomStringUtil {
	// function to generate a random string of length n

	public static String getAlphaNumString(int n, String inputString) {

		if (inputString == null || inputString.isEmpty()) {
			inputString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		}

		// chose a Character random from this String
		String inputStringUcase = inputString.trim().replaceAll(" ", "").concat("0123456789");

		// create StringBuffer size of inputString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to inputString variable length
			int index
					= (int) (inputStringUcase.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(inputStringUcase
					.charAt(index));
		}

		return sb.toString();
	}

	public static String getNumString(int n) {

		// chose a Character random from this String
		String inputStringUcase = "0123456789";

		// create StringBuffer size of inputString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to inputString variable length
			int index
					= (int) (inputStringUcase.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(inputStringUcase
					.charAt(index));
		}

		return sb.toString();
	}
}
