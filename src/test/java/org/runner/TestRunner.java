package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="org.stepdefinition", stepNotifications=true, 
dryRun=false, monochrome=true,plugin= {"html:src\\test\\resources\\Report\\HTMLReport\\report.html"})
public class TestRunner {

}
