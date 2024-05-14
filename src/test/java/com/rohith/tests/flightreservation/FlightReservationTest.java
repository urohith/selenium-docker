package com.rohith.tests.flightreservation;

import com.rohith.pages.flightregistration.*;
import com.rohith.tests.AbstractTest;
import com.rohith.tests.flightreservation.model.FlightPortalTestData;
import com.rohith.util.Config;
import com.rohith.util.Constants;
import com.rohith.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class FlightReservationTest extends AbstractTest
{
    private String noOfPassengers;
    private String expectedPrice;
    private FlightPortalTestData flightPortalTestData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setParameters(String testDataPath) throws IOException {
        this.flightPortalTestData = JsonUtil.getTestData(System.getProperty("user.dir")+testDataPath,FlightPortalTestData.class);
    }

    @Test
    public void userRegistrationTest() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
        this.driver.manage().window().maximize();
        Assert.assertTrue(registrationPage.isAt());
        registrationPage.enterUserDetails(flightPortalTestData.firstName(), flightPortalTestData.lastName());
        registrationPage.enterUserCredentials(flightPortalTestData.email(),flightPortalTestData.password());
        registrationPage.enterUserAddress(flightPortalTestData.street(),flightPortalTestData.city(),flightPortalTestData.zip());
        registrationPage.registerUser();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registerConfirmationTest()
    {
        RegistrationConfirmationPage registerConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registerConfirmationPage.isAt());
        registerConfirmationPage.flightSearch();
    }

    @Test(dependsOnMethods = "registerConfirmationTest")
    public void flightSearch() throws InterruptedException {
        FlightSearch flightSearch = new FlightSearch(driver);
        Assert.assertTrue(flightSearch.isAt());
        flightSearch.selectPassengers(flightPortalTestData.passengersCount());
        flightSearch.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearch")
    public void flightSelectionTest()
    {
        FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage(driver);
        Assert.assertTrue(flightsSelectionPage.isAt());
        flightsSelectionPage.selectFlights();
        flightsSelectionPage.confirmFlights();
    }

    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightReservationConfirmationTest()
    {
        FlightConfirmationPage flighConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flighConfirmationPage.isAt());
        Assert.assertEquals(flighConfirmationPage.getPrice(),flightPortalTestData.expectedPrice());
    }
}
