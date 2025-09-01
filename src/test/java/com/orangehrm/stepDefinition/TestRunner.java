package com.orangehrm.stepDefinition;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\kuruv\\eclipse-workspace\\janu\\janu\\pattern\\CGI_AUG2025\\src\\test\\resources\\feature"
,glue= {"com.orangehrm.stepdefinitions"}
,tags ="@smoke"
,dryRun=false
,monochrome=true)


public class TestRunner {


}


