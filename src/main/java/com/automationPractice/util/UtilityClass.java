package com.automationPractice.util;

public class UtilityClass {

	public static void staticWait(long timeInMillisec) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
