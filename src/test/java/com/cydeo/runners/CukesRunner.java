package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
               // "pretty",
                //'pretty' just print out additional info about scenario is executed
                "html:target/cucumber-report.html",
                //multiple time of reports, 'html' in this case,
                //'target' is our folder in project, then we name the 'html' report
                //when you run this class the 'cucumber-report.html'
                //when I right click on 'cucumber-report.html' file in library and then
                //choose 'open in' browser->Chrome then this will open login.feature as html page
                "rerun:target/rerun.txt",
                //'rerun' will build .txt report if something is failed in test with
                // indication a path where this error is /lines number in feature file/
                //file:src/test/resources/features/webtableOrder.feature:37:39/ in this case
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                //new from pom.xml dependency, create target/cucumber automatically
                //you can open this report in browser separately by clicking:
                // target/cucumber/cucumber-html-reports/overview-features.html

        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        //dryRun turns of the running step_definitions
        //dryRun = true -> do not run my step_definitions(do not run browser)
                           // but only check if any step is missing snippet
        //dryRun = false -> turn off dryRun and our code will run as expected
        tags =  "@smoke" ,              //"wip" -> wip means "work in progress"
                //"@Regression"//named it by custom, as you want, only make sense where you place it
        //can be @smoke, @librarian, @student or @admin which are in login.feature
        //you can even "@librarian or @student" will execute 2 scenarios
        //'or' here is like || in Java, if any true then execute
        //also '@Regression and not @student' will execute everything except @student
        //also '@employee and not @admin' will execute only @librarian
        //@Regression is placed at the top of login.feature to execute whole code
        //if we place @something at the top only one Scenario of login.feature
        // then it will execute only this Scenario
        publish = false
        //'publish' will generate report automatically a public link in a console
        //  you can open it in browser or share this link
)

public class CukesRunner {
}
