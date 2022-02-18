package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class RestaurantsSystemHooks {

    @Before
    public void beforeDisplayMessage(Scenario scenario){
        System.out.println("Before: " + scenario.getName());
    }

    @After
    public void afterDisplayMessage(Scenario scenario){
        System.out.println("After: " + scenario.getName());
    }
}
