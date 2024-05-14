package com.rohith.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage
{
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected JavascriptExecutor executor;
    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
        executor = (JavascriptExecutor)driver;
    }

    public abstract boolean isAt();
}
