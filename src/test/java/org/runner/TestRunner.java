package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utility.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",  
                 glue="org.stepdefinition", 
                 stepNotifications=true, 
                 dryRun=false, 
                 monochrome=true,
                 plugin= {"html:src\\test\\resources\\Reports\\HTMLReport\\report.html",
                		 "json:src\\test\\resources\\Reports\\JsonReport\\report.json"})
public class TestRunner {
	@AfterClass
	public static void report() {
		JVMReport.generateJVMReport("src\\test\\resources\\Reports\\JsonReport\\report.json");
		System.out.println("----------Report Generated--------");

	}

}
