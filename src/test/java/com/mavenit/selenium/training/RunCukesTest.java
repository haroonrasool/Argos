package com.mavenit.selenium.training;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", dryRun = false, strict = true, tags = "@regression")
public class RunCukesTest {
}
