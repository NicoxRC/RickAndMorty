package com.uitests.dogopediatests.pages;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uitests.core.Page;
import com.uitests.dogopediatests.components.DogCard;
import com.uitests.dogopediatests.data.Temperaments;

public class CardsPage extends Page {
    final private By loadingHearth = By.cssSelector("div[class='spinner_container']");
    final private By searchBarLocator = By.xpath("//input[@name='Search']");
    // private By searchButtonLocator = By.xpath("//button[contains(text(), 'Search')]");
    final private By temperamentsSelectLocator = By.xpath("//select[@name='filterByTemperament']");
    final private By nameSortButton = By.cssSelector("img[class='nameImage']");
    final private By weightSortButton = By.cssSelector("img[class='weightImage']");
    final private By createDogCardButton = By.cssSelector("button[class='createButton']");
    final private By navigationButtonsLocator = By.xpath("//div[@class='pagination']/button");
    final private By cardsLocator = By.xpath("//div[@class='card']");

    private List<WebElement> navigationButtons;
    private List<DogCard> cards;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public CardsPage(WebDriver driver) {
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

    public void searchDog(String text) {
        WebElement searchBar = findElement(searchBarLocator);
        searchBar.sendKeys(text);
        searchBar.submit();
    }

    public void selectTemperamentByValue(Temperaments temperament) {
        selectByValue(temperamentsSelectLocator, temperament.getValue());
    }

    public void selectTemperamentByVisibleText(Temperaments temperament) {
        selectByVisibleText(temperamentsSelectLocator, temperament.getVisibleText());
    }

    public void selectTemperamentByIndex(int index) {
        selectByIndex(temperamentsSelectLocator, index);
    }

    public void selectTemperamentRandomly() {
        selectRandomly(temperamentsSelectLocator);
    }

    public String getTemperamentValue() {
        return getSelectValue(temperamentsSelectLocator);
    }

    public void clickNameSortButton() {
        findElement(nameSortButton).click();
    }

    public void clickWeightSortButton() {
        findElement(weightSortButton).click();
    }

    public void clickCreateDogCardButton() {
        findElement(createDogCardButton).click();
    }

    public int getAmountOfNavigationButtons() {
        return getNavigationButtons().size();
    }

    public void clickNavigationButton(int index) {
        try {
            getNavigationButtons().get(index).click();
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("The index is out of bounds");
        }
    }

    public void clickNavigationButtonRandomly() {
        int size = getNavigationButtons().size();
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        getNavigationButtons().get(randomIndex).click();
    }

    private List<WebElement> getNavigationButtons() {
        if (navigationButtons == null)
            navigationButtons = findElements(navigationButtonsLocator);
        return navigationButtons;
    }

    public List<DogCard> getAllDogCards() {
        if (cards == null)
            cards = createComponentList(cardsLocator, DogCard.class);
        return cards;
    }

    public DogCard getRandomDogCart() {
        List<DogCard> cards = getAllDogCards();
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        return cards.get(randomIndex);
    }

    public int getNumberOfDogCards() {
        return getAllDogCards().size();
    }
}