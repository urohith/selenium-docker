package com.rohith.pages.vendorPortal;

import com.rohith.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashBoardPage extends AbstractPage
{
    private static final Logger log = LoggerFactory.getLogger(DashBoardPage.class);
    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualMarginElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(xpath = "//div[@id='dataTable_filter']//input")
    private WebElement searchOrder;

    @FindBy(id = "userDropdown")
    private WebElement userProfilePicture;

    @FindBy(xpath = "//a[@data-target='#logoutModal']")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@id='logoutModal']//a")
    private WebElement modalLogOutButton;

    @FindBy(id = "dataTable_info")
    private WebElement searchResults;
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarningElement));
        return this.monthlyEarningElement.isDisplayed();
    }

    public String getMonthlyEarning()
    {
        return this.monthlyEarningElement.getText();
    }

    public String getAnnualEarning()
    {
        return this.annualMarginElement.getText();
    }

    public String getProfitMargin()
    {
        return this.profitMarginElement.getText();
    }

    public String getAvailableInventory()
    {
        return this.availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword)
    {
        this.searchOrder.sendKeys(keyword);
    }

    public int getSearchResultsCount()
    {
        String resultsText = this.searchResults.getText();
        String[] arr= resultsText.split(" ");
        int count = Integer.parseInt(arr[5]);
        log.info("Results count: {}", count);
        return count;
    }

    public void logOut()
    {
        executor.executeScript("arguments[0].click();",this.userProfilePicture);
//        this.userProfilePicture.click();
        executor.executeScript("arguments[0].click();",this.logOutButton);
//        this.logOutButton.click();
        executor.executeScript("arguments[0].click();",this.modalLogOutButton);
//        this.modalLogOutButton.click();
    }
}
