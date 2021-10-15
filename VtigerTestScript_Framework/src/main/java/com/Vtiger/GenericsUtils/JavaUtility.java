package com.Vtiger.GenericsUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*
	 * author @ NITIN
	 */
	/**
	 * This method generates random numbers to avoid duplicates
	 * 
	 * @return
	 */
	public static String getRandomData() {
		Random random = new Random();
		int ran = random.nextInt(1000);
		return "" + ran;

	}
	public static String getCurrentDate() {
		Date date = new Date();
		String currentDate = date.toString();
		return currentDate;
	}

}
