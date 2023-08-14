package com.uitests.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CharactersPage {

    private WebDriver driver;
    WebDriverWait wait;

    private By searchBarLocator = By.xpath("//input[@type='search']");
    private By searchButtonLocator = By.xpath("//button[contains(text(), 'Search')]");
    private By dropboxLocator = By.className("form-select");
    private By cardsLocator = By.xpath("//div[@class='card text-bg-dark']");
    private By cardTitlesLocator = By.xpath("//h2[contains(@class, 'card-title')]");
    private By cardButtonsLocator = By.xpath("//button[contains(text(), 'Go somewhere')]");
    private By cardTextLocator = By.className("card-text");

    List<WebElement> dropboxes;

    public CharactersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void searchCharacter(String text) {
        WebElement searchBar = driver.findElement(searchBarLocator);
        WebElement searchButton = driver.findElement(searchButtonLocator);
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchBar.sendKeys(text);
        searchButton.click();
    }

    public void waitForCardsUpdate(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardTitlesLocator));
        while (true) {
            try {
                wait.until(ExpectedConditions
                        .textToBePresentInElement(driver.findElement(cardTitlesLocator), expectedText));
                break;
            } catch (TimeoutException e) {
                System.out.println("Waiting for the element to load...");
            }
        }
    }

    public List<String> getCardTitles() {
        List<WebElement> names = driver.findElements(cardTitlesLocator);
        return names.stream().map(name -> name.getText()).collect(Collectors.toList());
    }

    public List<String> getCardTexts() {
        List<WebElement> texts = driver.findElements(cardTextLocator);
        return texts.stream().map(text -> text.getText()).collect(Collectors.toList());
    }

    // public void waitForSelectsToLoad() {
    //     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropboxLocator));
    // }

    public <T> void selectCharacterGender(T value, String method) {
        if (dropboxes == null)
            dropboxes = driver.findElements(dropboxLocator);

        Select select = new Select(dropboxes.get(0));
        useSelect(value, method, select);
    }

    public <T> void selectCharacterSpecies(T value, String method) {
        if (dropboxes == null)
            dropboxes = driver.findElements(dropboxLocator);

        Select select = new Select(dropboxes.get(1));
        useSelect(value, method, select);
    }

    public <T> void selectCharacterStatus(T value, String method) {
        if (dropboxes == null)
            dropboxes = driver.findElements(dropboxLocator);

        Select select = new Select(dropboxes.get(2));
        useSelect(value, method, select);
    }

    public <T> void selectCharacterType(T value, String method) {
        if (dropboxes == null)
            dropboxes = driver.findElements(dropboxLocator);

        Select select = new Select(dropboxes.get(3));
        useSelect(value, method, select);
    }

    private <T> void useSelect(T value, String method, Select select) {
        switch (method) {
            case "value":
                select.selectByValue(String.valueOf(value));
                break;
            case "index":
                select.selectByIndex((Integer) value);
                break;
            case "visibleText":
                select.selectByVisibleText(String.valueOf(value));
                break;
        }
        simpleWaitForCardsUpdate();
    }

    public void simpleWaitForCardsUpdate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardTitlesLocator));
    }

    // genderSelect.selectByValue("Female");
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
    // speciesSelect.selectByValue("Alien");
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
    // statusSelect.selectByIndex(1);
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
    // typeSelect.selectByVisibleText("Cat-Person");

    public int getNumberOfCards() {
        return driver.findElements(cardsLocator).size();
    }

    public int getAmountOfCardButtons() {
        return driver.findElements(cardButtonsLocator).size();
    }
}
