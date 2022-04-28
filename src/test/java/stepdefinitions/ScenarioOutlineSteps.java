package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumbercourse.helper.BillCalculationHelper;
import helper.selenium.SeleniumBootstrap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScenarioOutlineSteps {

    private int initialBillAmount;
    private BigDecimal taxRate;

    @Given("I have a customer")
    public void i_have_a_customer() {
    }

    @Given("user enters initial bill amount as {int}")
    public void user_enters_initial_bill_amount_as(Integer initialBillAmount) {
        this.initialBillAmount = initialBillAmount;
    }

    @Given("Sale Tax Rate is {int} percent")
    public void sale_Tax_Rate_is_percent(Integer taxRate) {
        this.taxRate = new BigDecimal(taxRate);
    }

    @Then("Final bill amount calculate is {int}")
    public void final_bill_amount_calculate_is(Integer expectedValue) {
        BigDecimal expectedValueBigDecimal = BigDecimal.valueOf(expectedValue).setScale(2, RoundingMode.HALF_UP);
        BigDecimal systemCalculatedValue = BillCalculationHelper.calculateBillCustomer(new BigDecimal(initialBillAmount), taxRate)
                .setScale(2, RoundingMode.HALF_UP);
        assertEquals(String.format("The expectedValue(%f) must be equals to systemCalculatedValue(%f)", expectedValueBigDecimal, systemCalculatedValue),
                systemCalculatedValue, expectedValueBigDecimal);
    }

    @Given("Sale Tax Rate is {bigdecimal} percent")
    public void sale_Tax_Rate_is_percent(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Then("Final bill amount calculate is {bigdecimal}")
    public void final_bill_amount_calculate_is(BigDecimal  expectedValue) {
        BigDecimal systemCalculatedValue = BillCalculationHelper.calculateBillCustomer(new BigDecimal(initialBillAmount), taxRate);
        assertEquals(String.format("The expectedValue(%f) must be equals to systemCalculatedValue(%f)", expectedValue, systemCalculatedValue),
                systemCalculatedValue, expectedValue);

        invokeWebPage(expectedValue);
    }

    private void invokeWebPage(BigDecimal expectedValue){
        WebDriver driver = SeleniumBootstrap.setupChrome();
        driver.get("http://localhost:8080/calculator/finalBill");

        WebElement billAmount = driver.findElement(By.id("billAmount"));
        WebElement taxRate = driver.findElement(By.id("taxRate"));
        WebElement btnCalculate = driver.findElement(By.id("btnCalculate"));

        billAmount.clear();
        billAmount.sendKeys(Integer.toString(initialBillAmount));
        taxRate.clear();
        taxRate.sendKeys(this.taxRate.toString());
        btnCalculate.click();

        WebElement finalBillCalculated = driver.findElement(By.id("billCalculated"));

        String finalBillCalculatedSTr = finalBillCalculated.getText();
        driver.quit();
        assertTrue(finalBillCalculatedSTr.contains("" + expectedValue));
    }
}
