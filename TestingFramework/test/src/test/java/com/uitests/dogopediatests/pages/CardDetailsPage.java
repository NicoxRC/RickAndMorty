package com.uitests.dogopediatests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uitests.core.Page;

public class CardDetailsPage extends Page {
    final private By loadingHearth = By.cssSelector("div[class='spinner_container']");
    final private By backButton = By.tagName("button");
    final private By dogNameLocator = By.xpath("//div[@class='dog_details_list']/h1");
    final private By dogWeightLocator = By.xpath("(//div[@class='dog_details_list']/ul/li)[3]");
    final private By dogTemperamentLocator = By.xpath("(//div[@class='dog_details_list']/ul/li)[1]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public CardDetailsPage(WebDriver driver) {
        super(driver);
        validatePageLoad();
    }

    @Override
    protected void validatePageLoad() {
        try {
            waitUntil(ExpectedConditions.invisibilityOf(findElement(loadingHearth)));
        } catch (NoSuchElementException e) {
            LOGGER.warn("Loading hearth not found");
        }
    }

    public void clickBackButton() {
        findElement(backButton).click();
    }

    public String getDogName() {
        return findElement(dogNameLocator).getText();
    }

    public String getDogWeight() {
        return findElement(dogWeightLocator)
                .getText().replace("\n", "")
                .split(":")[1].trim();
    }

    public String getDogTemperament() {
        return findElement(dogTemperamentLocator)
                .getText().replace("\n", "")
                .split(":")[1].replace("\"", "").trim();
    }
}