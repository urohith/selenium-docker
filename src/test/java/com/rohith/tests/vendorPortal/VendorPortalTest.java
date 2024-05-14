package com.rohith.tests.vendorPortal;

import com.rohith.pages.vendorPortal.DashBoardPage;
import com.rohith.pages.vendorPortal.LoginPage;
import com.rohith.tests.AbstractTest;
import com.rohith.tests.vendorPortal.model.VendorPortalTestData;
import com.rohith.util.Config;
import com.rohith.util.Constants;
import com.rohith.util.JsonUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class VendorPortalTest extends AbstractTest
{
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) throws IOException {
        this.loginPage = new LoginPage(driver);
        this.dashBoardPage = new DashBoardPage(driver);
        this.testData = JsonUtil.getTestData(System.getProperty("user.dir")+testDataPath,VendorPortalTestData.class);
    }

    @Test
    public void LoginTest()
    {
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.username(), testData.password());
    }

    @Test
    public void dashBoardTest()
    {
        Assert.assertTrue(dashBoardPage.isAt());
//        Finance Metrics
        Assert.assertEquals(dashBoardPage.getMonthlyEarning(),testData.monthlyEarning());
        Assert.assertEquals(dashBoardPage.getAnnualEarning(),testData.annualEarning());
        Assert.assertEquals(dashBoardPage.getProfitMargin(),testData.profitMargin());
        Assert.assertEquals(dashBoardPage.getAvailableInventory(),testData.availableInventory());
//        Order history search
        dashBoardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashBoardPage.getSearchResultsCount(),testData.searchResultsCount());
    }

    @Test(dependsOnMethods = "dashBoardTest")
    public void logOutPage()
    {
        dashBoardPage.logOut();
        Assert.assertTrue(loginPage.isAt());
    }

}
