package com.company.jmixserenitykotlin

//// JUNIT 4
//import io.cucumber.junit.CucumberOptions
//import net.serenitybdd.cucumber.CucumberWithSerenity
//import org.junit.runner.RunWith
//
//
//@RunWith(CucumberWithSerenity::class)
//@CucumberOptions(
//    plugin = ["pretty", "html:target/cucumber-html-report", "junit:target/junit-report.xml"],
//    monochrome = false,
//    //glue = ["", ""],
//    features = ["classpath:features"]
//)
//class RunSerenityTest


// JUNIT 5

import io.cucumber.junit.platform.engine.Constants
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, summary, json:build/cucumber/cucumber.json, html:build/cucumber/report.html")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.OBJECT_FACTORY_PROPERTY_NAME, value = "cucumber.runtime.SerenityObjectFactory") // spring
class RunSerenityTest {
    @SpringBootTest(classes = [JmixSerenityKotlinApplicationTests::class])
    @ActiveProfiles(value = ["features"])
    @CucumberContextConfiguration
    internal class FeatureSpringConfig
}
