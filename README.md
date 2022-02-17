# cucumbersimplecourse
Simple project to show how to use Cucumber in a Java project. Managing background, hooks, dataTable, scenario outline, and using Selenium WebDriver. 

##Requirements
    . Java 1.8+
    . Maven

### Plugins
    . Lombok

## The project
This project is based at this [Linkedin course](https://www.linkedin.com/learning/cucumber-essential-training/) with some customizations, such as SpringBoot application to serve an app to be used on Selenium example. And the way to setup the Seleinum WebDriver. 

There is only one test runner, the `testrunners.MenuManagementTest`

There is only one test to use Selenium WebDriver, configurated on the ScenarioOutlineExample.feature and identified by the tag @ScenarioOutlineExample.
All the others tests just use cucumber.

###To run the test with Selenium you must:
1. if you want to run only this test that uses Selenium, go to the `testrunners.MenuManagementTest` and put the tag @ScenarioOutlineExample to be executed
2. start the _SpringBoot application_ running the `SpringBootJspApplication` class
3. run the `testrunners.MenuManagementTest` test runner