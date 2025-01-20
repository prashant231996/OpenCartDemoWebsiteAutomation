package com.cart.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	public int maxRetryCount=2;
    public int count=0;

	@Override
	public boolean retry(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			if(count<maxRetryCount)
			{
				result.setStatus(ITestResult.FAILURE);
				count++;
				return true;
			}
			else
			{
				result.setStatus(ITestResult.FAILURE);
				count=0;
				return false;
			}
		}
		return false;
	}
}
