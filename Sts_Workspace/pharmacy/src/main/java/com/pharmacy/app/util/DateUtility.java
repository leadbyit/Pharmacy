package com.pharmacy.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	private static String DATE_FORMAT = "yyyy-MM-dd";

	public static Date convertToDate(String date) {
		Date formattedDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		if (null != date) {
			try {
				formattedDate = dateFormat.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return formattedDate;
	}

	public static String convertToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String formattedDate = null;
		if (null != date) {
			formattedDate = dateFormat.format(date);
		}
		return formattedDate;
	}
}
