package com.rohith.pages.flightregistration;

import com.rohith.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearch extends AbstractPage
{
    @FindBy(id = "passengers")
    private WebElement passengerSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsBtn;

    public FlightSearch(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengerSelect));
        return this.passengerSelect.isDisplayed();
    }

    public void selectPassengers(String noOfPassengers)
    {
        Select selectPassengers = new Select(this.passengerSelect);
        selectPassengers.selectByValue(noOfPassengers);
    }

    public void searchFlights() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsBtn));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", searchFlightsBtn);
//        this.searchFlightsBtn.click();
    }
}
