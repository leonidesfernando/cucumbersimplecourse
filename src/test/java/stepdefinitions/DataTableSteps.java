package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

    @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> map : data){
            for(Map.Entry<String, String> entry : map.entrySet()){
                System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
            }
        }

        /*List<List<String>> billData = dataTable.asLists();
        billData.stream().forEach(items -> {
            items.stream().forEach(item ->
                    System.out.println(item)
                    );
                }
        );*/
    }

    @When("I generate the bill")
    public void i_generate_the_bill() {
    }

    @Then("a bil for ${int} should be generated")
    public void a_bil_for_$_should_be_generated(Integer int1) {
    }

}
