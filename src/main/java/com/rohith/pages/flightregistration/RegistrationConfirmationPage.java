package com.rohith.pages.flightregistration;

import com.rohith.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage
{
    @FindBy(xpath = "//div[@id='registration-confirmation-section']//h2")
    private WebElement registrationConfirmation;

    @FindBy(id = "go-to-flights-search")
    private WebElement flightSearchButton;

    public RegistrationConfirmationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightSearchButton));
        return this.flightSearchButton.isDisplayed();
    }

    public void flightSearch()
    {
        this.flightSearchButton.click();
    }
}
