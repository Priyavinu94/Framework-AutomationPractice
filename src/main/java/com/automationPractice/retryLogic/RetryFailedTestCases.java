package com.automationPractice.retryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.automationPractice.BasePackage.TestBase;

public class RetryFailedTestCases extends TestBase implements IRetryAnalyzer {

	int counter = 1;
	int maxCount = 3;

	@Override
	public boolean retry(ITestResult result) {

		logger.info("Trying failed test case " + counter + " times");

		if (counter < maxCount) {
			counter++;
			return true;
		}
		return false;
	}

}
