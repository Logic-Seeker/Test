package com.brick.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrickUtils {
	public static String numToken = "[\\p{Digit}]+";
	public static String regx_date_validator = "\\d{4}-\\d{2}-\\d{2}";

	public static String getCurrentDate() {
		Date currDate = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("date " + dateFormat.format(currDate));
		return dateFormat.format(currDate);

	}

	public static  boolean validateFormat(String date) {
		return date.matches(BrickUtils.regx_date_validator);
	}
}
