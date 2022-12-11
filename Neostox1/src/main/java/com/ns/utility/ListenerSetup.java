package com.ns.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ns.testBase.TestBaseClass;

public class ListenerSetup extends TestBaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test Execution Started"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Execution Completed"+result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Execution Failed"+result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Execution Skipped"+result.getName());

	}

	

}
