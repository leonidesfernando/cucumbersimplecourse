package stepdefinitions;

import cucumber.api.java.da.Men;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import linkedinlearning.cucumbercourse.RestaurantMenu;
import linkedinlearning.cucumbercourse.RestaurantMenuItem;

import java.util.Collections;

import static linkedinlearning.cucumbercourse.RestaurantMenu.DUPLICATE_MESSAGE_EXCEPTION;
import static org.junit.Assert.assertEquals;

public class MenuManagementSteps {

    RestaurantMenuItem newMenuItem;
    RestaurantMenu locationMenu = new RestaurantMenu();

    public MenuManagementSteps(){
        System.out.println("Constructor");
    }

    @Given("I have a menu item with a name \"([^\"]+)\" and price ([$]*)(\\d)+")
    public void i_have_a_menu_item_with_a_name_and_price(String newMenuItemName, String currencyType, int price) {

        newMenuItem = new RestaurantMenuItem(newMenuItemName, newMenuItemName, price);
        System.out.println("Step 1");
    }
    @When("I add that menu item")
    public void i_add_that_menu_item() {
        try {
            locationMenu.addMenuItem(newMenuItem);
        }catch (IllegalArgumentException e){
            // do nothing
        }
        System.out.println("Step 2");
    }
    @Then("Menu item with name {string} should be added")
    public void menu_item_with_name_should_be_added(String string) {
        System.out.println("Step 3 " + locationMenu.doesExistis(newMenuItem));
    }

    @Then("I should see an error message with value {string}")
    public void i_should_see_an_error_message_with_value(String errorMessage) {
        assertEquals(DUPLICATE_MESSAGE_EXCEPTION, errorMessage);
    }
}
