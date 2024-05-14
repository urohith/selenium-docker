package com.rohith.pages.vendorPortal;

import com.rohith.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage
{
    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement userPasswordInput;

    @FindBy(id = "login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.loginBtn));
        return this.loginBtn.isDisplayed();
    }
    public void goTo(String url)
    {
        this.driver.get(url);
    }

    public void login(String userName, String password)
    {
        this.userNameInput.sendKeys(userName);
        this.userPasswordInput.sendKeys(password);
        this.loginBtn.click();
    }
}
