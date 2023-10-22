package com.uitests.dogopediatests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uitests.core.Page;

public class CardDetailsPage extends Page {
    private WebDriver driver;

    final private By loadingHearth = By.cssSelector("div[class='spinner_container']");
    final private By backButton = By.tagName("button");
    final private By dogNameLocator = By.xpath("//div[@class='dog_details_list']/h1");
    final private By dogWeightLocator = By.xpath("(//div[@class='dog_details_list']/ul/li)[3]");
    final private By dogTemperamentLocator = By.xpath("(//div[@class='dog_details_list']/ul/li)[1]");

    public CardDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    protected void validatePageLoad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validatePageLoad'");
    }

    public CardDetailsPage waitForPageLoad() {
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(loadingHearth));
        return this;
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public String getDogName() {
        return driver.findElement(dogNameLocator).getText();
    }

    public String getDogWeight() {
        return driver.findElement(dogWeightLocator)
                .getText().replace("\n", "")
                .split(":")[1].trim();
    }

    public String getDogTemperament() {
        return driver.findElement(dogTemperamentLocator)
                .getText().replace("\n", "")
                .split(":")[1].replace("\"", "").trim();
    }
}