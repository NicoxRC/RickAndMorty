package com.uitests.core;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    private WebDriver driver;
    protected WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    protected ArrayList<WebElement> singleComponents;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    



    protected abstract void validatePageLoad();

    protected Select selectByValue(By selectLocator, String value) {
        Select select = getSelect(selectLocator);
        select.selectByValue(value);
        return select;
    }

    protected Select selectByVisibleText(By selectLocator, String value) {
        Select select = getSelect(selectLocator);
        select.getOptions().stream()
                .filter(option -> option.getText().contains(value))
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException("The value is not found"));

        return select;
    }

    protected Select selectByIndex(By selectLocator, int index) {
        Select select = getSelect(selectLocator);
        try {
            select.selectByIndex(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("The index is out of bounds");
        }
        return select;
    }

    protected Select selectRandomly(By selectLocator) {
        Select select = getSelect(selectLocator);
        List<WebElement> options = select.getOptions();
        int randomIndex = (int) (Math.random() * (options.size() - 1)) + 1;
        options.get(randomIndex).click();
        return select;
    }

    protected String getWebElementValue(WebElement element) {
        return element.getAttribute("value");
    }

    protected Select getSelect(By locator) {
        return new Select(driver.findElement(locator));
    }

    protected List<WebComponent> createComponentList(By locator) {
        try {
            return driver.findElements(locator)
                    .stream()
                    .map(element -> new WebComponent(this, element))
                    .collect(Collectors.toList());

        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LOGGER.error("Web component not found");
            throw new RuntimeException(e);
        }
    }

    protected WebComponent createComponent(By locator, WebComponent component) {
        try {
            return new WebComponent(this, driver.findElement(locator));
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            LOGGER.error("Web component not found");
            throw new RuntimeException(e);
        }
    }

    protected WebDriver getDriver() {
        return driver;
    }
}