package com.rohith.pages.flightregistration;

import com.rohith.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsSelectionPage extends AbstractPage
{
    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightButton;

    public FlightsSelectionPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightButton));
        return this.confirmFlightButton.isDisplayed();
    }

    public void selectFlights()
    {
        int random = ThreadLocalRandom.current().nextInt(0,departureFlightOptions.size());
//        this.departureFlightOptions.get(random).click();
        executor.executeScript("arguments[0].click();",this.departureFlightOptions.get(random));
//        this.arrivalFlightOptions.get(random).click();
        executor.executeScript("arguments[0].click();",this.arrivalFlightOptions.get(random));

    }

    public void confirmFlights()
    {
        executor.executeScript("arguments[0].click();",this.confirmFlightButton);
//        this.confirmFlightButton.click();
    }
}
