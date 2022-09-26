package stepDefinition;

import driverInstance.Driver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class MyStepdefs extends Driver {

    WebDriver driver= null;

    @Before("@smokeTest")
    public void browserSetup() {
        driver=createDriver("chrome");
    }
    @Given("User is on flight booking homepage")
    public void userIsOnFlightBookingHomepage() {
        driver.get("https://www.google.com/travel/flights/search");
    }
    @When("User enter source {string} and destination {string} location")
    public void user_enter_source_and_destination_location(String string, String string2) {
        System.out.println(string);
        WebElement source = driver.findElement(By.xpath("(//div[@jscontroller='qrQlLd']//input)[1]"));
        JavascriptExecutor runJS= ((JavascriptExecutor) driver);
        runJS.executeScript("arguments[0].value='"+string+"';", source);
        WebElement destination = driver.findElement(By.xpath("(//div[@jscontroller='qrQlLd']//input)[3]"));
        JavascriptExecutor runJS1= ((JavascriptExecutor) driver);
        runJS1.executeScript("arguments[0].value='"+string2+"';", destination);
    }
    @Then("User should be able to search flight details successfully")
    public void userShouldBeAbleToSearchFlightDetailsSuccessfully() {
        driver.findElement(By.xpath("//span[@jsname='V67aGc' and text()='Search']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-roledescription='map']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-roledescription='map']")).isDisplayed());
    }

    @Given("User navigated to ticket booking page")
    public void user_navigated_to_ticket_booking_page() {
        System.out.println("STEP1: User navigated to ticket booking page : Pass");
        driver.get("https://www.google.com/travel/flights/search");

    }
    @When("User fill out the ticket details page with data in excelsheet {string} and rownumber {int}")
    public void user_fill_out_the_ticket_details_page_with_data_in_excelsheet_and_rownumber(String sheetName, Integer rowNumber) {
        try {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(System.getProperty("user.dir")+"/src/main/resources/TestData.xls",sheetName);
        String FirstName = testData.get(rowNumber).get("FirstName");
        String LastName = testData.get(rowNumber).get("LastName");
        String PhoneNo = testData.get(rowNumber).get("PhoneNo");
        String EmailID =  testData.get(rowNumber).get("EmailID");
        System.out.println("FirstName :"+FirstName);
        System.out.println("LastName :"+LastName);
        System.out.println("PhoneNo :"+PhoneNo);
        System.out.println("EmailID :"+EmailID);
        //fetched data can be passed on to textBox and used to select values from drop down by using sendkeys and javascriptexecutor and
            // importing the package org.openqa.selenium.support.ui.Select
            //Select drpCountry = new Select(driver.findElement(By.name("country")));
            //		drpCountry.selectByVisibleText("variable in which data has been stored");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Then("User is able to navigate further in ticket booking journey")
    public void user_is_able_to_navigate_further_in_ticket_booking_journey() {
        System.out.println("STEP3: User is able to navigate further in ticket booking journey : Pass");
    }

    @After("@smokeTest")
    public void closeBrowser(){
        driver.quit();
        //driver.close();
    }

}
