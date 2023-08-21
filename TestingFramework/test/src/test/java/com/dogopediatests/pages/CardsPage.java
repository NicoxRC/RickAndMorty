package com.dogopediatests.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dogopediatests.components.Card;

public class CardsPage {
    private WebDriver driver;
    WebDriverWait wait;

    private By loadingHearth = By.cssSelector("div[class='spinner_container']");
    private By searchBarLocator = By.xpath("//input[@name='Search']");
    // private By searchButtonLocator = By.xpath("//button[contains(text(), 'Search')]");
    private By temperamentsSelectLocator = By.xpath("//select[@name='filterByTemperament']");
    private By nameSortButton = By.cssSelector("img[class='nameImage']");
    private By weightSortButton = By.cssSelector("img[class='weightImage']");
    private By createDogCardButton = By.cssSelector("button[class='createButton']");
    private By navigationButtonsLocator = By.xpath("//div[@class='pagination']/button");
    private By cardsLocator = By.xpath("//div[@class='card']");

    private List<WebElement> navigationButtons;
    private List<Card> cards;

    public enum Temperaments {
        ALL("all", "Filter by temperaments"),
        CURIOUS("Curious", "Curious"),
        STUBBORN("Stubborn", "Stubborn"),
        PLAYFUL("Playful", "Playful"),
        ADVENTUROUS("Adventurous", "Adventurous"),
        ACTIVE("Active", "Active"),
        FUN("Fun-loving", "Fun-loving"),
        ALOOF("Aloof", "Aloof"),
        CLOWNISH("Clownish", "Clownish"),
        DIGNIFIED("Dignified", "Dignified"),
        INDEPENDENT("Independent", "Independent"),
        WILD("Wild", "Wild"),
        HARDWORKING("Hardworking", "Hardworking"),
        DUTIFUL("Dutiful", "Dutiful"),
        OUTGOING("Outgoing", "Outgoing"),
        HAPPY("Happy", "Happy"),
        FRIENDLY("Friendly", "Friendly"),
        ALERT("Alert", "Alert"),
        INTELLIGENT("Intelligent", "Intelligent"),
        CONFIDENT("Confident", "Confident"),
        COURAGEOUS("Courageous", "Courageous"),
        LOYAL("Loyal", "Loyal"),
        BRAVE("Brave", "Brave"),
        DOCILE("Docile", "Docile"),
        RESPONSIVE("Responsive", "Responsive"),
        COMPOSED("Composed", "Composed"),
        RECEPTIVE("Receptive", "Receptive"),
        FAITHFUL("Faithful", "Faithful"),
        LOVING("Loving", "Loving"),
        PROTECTIVE("Protective", "Protective"),
        TRAINABLE("Trainable", "Trainable"),
        RESPONSIBLE("Responsible", "Responsible"),
        ENERGETIC("Energetic", "Energetic"),
        GENTLE("Gentle", "Gentle"),
        AFFECTIONATE("Affectionate", "Affectionate"),
        DEVOTED("Devoted", "Devoted"),
        ASSERTIVE("Assertive", "Assertive"),
        DOMINANT("Dominant", "Dominant"),
        STRONG_WILLED("Strong Willed", "Strong Willed"),
        OBEDIENT("Obedient", "Obedient"),
        RESERVED("Reserved", "Reserved"),
        KIND("Kind", "Kind"),
        SWEET("Sweet-Tempered", "Sweet-Tempered"),
        TENACIOUS("Tenacious", "Tenacious"),
        ATTENTIVE("Attentive", "Attentive"),
        STEADY("Steady", "Steady"),
        BOLD("Bold", "Bold"),
        PROUD("Proud", "Proud"),
        RELIABLE("Reliable", "Reliable"),
        FEARLESS("Fearless", "Fearless"),
        LIVELY("Lively", "Lively"),
        SELF_ASSURED("Self-assured", "Self-assured"),
        CAUTIOUS("Cautious", "Cautious"),
        EAGER("Eager", "Eager"),
        GOOD_NATURED("Good-natured", "Good-natured"),
        SPIRITED("Spirited", "Spirited"),
        COMPANIONABLE("Companionable", "Companionable"),
        EVEN("Even Tempered", "Even Tempered"),
        RUGGED("Rugged", "Rugged"),
        FIERCE("Fierce", "Fierce"),
        REFINED("Refined", "Refined"),
        JOYFUL("Joyful", "Joyful"),
        AGILE("Agile", "Agile"),
        AMIABLE("Amiable", "Amiable"),
        EXCITABLE("Excitable", "Excitable"),
        DETERMINED("Determined", "Determined"),
        SELF_CONFIDENCE("Self-confidence", "Self-confidence"),
        HARDY("Hardy", "Hardy"),
        CALM("Calm", "Calm"),
        GOOD("Good-tempered", "Good-tempered"),
        WATCHFUL("Watchful", "Watchful"),
        HARD("Hard-working", "Hard-working"),
        FEISTY("Feisty", "Feisty"),
        CHEERFUL("Cheerful", "Cheerful"),
        SENSITIVE("Sensitive", "Sensitive"),
        EASYGOING("Easygoing", "Easygoing"),
        ADAPTABLE("Adaptable", "Adaptable"),
        TRUSTING("Trusting", "Trusting"),
        LOVABLE("Lovable", "Lovable"),
        TERRITORIAL("Territorial", "Territorial"),
        KEEN("Keen", "Keen"),
        FAMILIAL("Familial", "Familial"),
        RATIONAL("Rational", "Rational"),
        BRIGHT("Bright", "Bright"),
        QUICK("Quick", "Quick"),
        POWERFUL("Powerful", "Powerful"),
        GAY("Gay", "Gay"),
        STABLE("Stable", "Stable"),
        QUIET("Quiet", "Quiet"),
        INQUISITIVE("Inquisitive", "Inquisitive"),
        STRONG("Strong", "Strong"),
        SOCIABLE("Sociable", "Sociable"),
        PATIENT("Patient", "Patient"),
        SUSPICIOUS("Suspicious", "Suspicious"),
        GREAT("Great-hearted", "Great-hearted"),
        MERRY("Merry", "Merry"),
        VOCAL("Vocal", "Vocal"),
        TOLERANT("Tolerant", "Tolerant"),
        MISCHIEVOUS("Mischievous", "Mischievous"),
        PEOPLE("People-Oriented", "People-Oriented"),
        BOSSY("Bossy", "Bossy"),
        CUNNING("Cunning", "Cunning"),
        ATHLETIC("Athletic", "Athletic"),
        BOISTEROUS("Boisterous", "Boisterous"),
        COOPERATIVE("Cooperative", "Cooperative"),
        TRUSTWORTHY("Trustworthy", "Trustworthy"),
        SELF_IMPORTANT("Self-important", "Self-important"),
        RESPECTFUL("Respectful", "Respectful"),
        THOUGHTFUL("Thoughtful", "Thoughtful"),
        GENEROUS("Generous", "Generous"),
        CAT("Cat-like", "Cat-like"),
        STURDY("Sturdy", "Sturdy"),
        BENEVOLENT("Benevolent", "Benevolent"),
        CLEVER("Clever", "Clever"),
        BUBBLY("Bubbly", "Bubbly"),
        OPINIONATED("Opinionated", "Opinionated"),
        AGGRESSIVE("Aggressive", "Aggressive"),
        EXTROVERTED("Extroverted", "Extroverted"),
        CHARMING("Charming", "Charming"),
        UNFLAPPABLE("Unflappable", "Unflappable"),
        SPUNKY("Spunky", "Spunky"),
        DILIGENT("Diligent", "Diligent"),
        WILLFUL("Willful", "Willful"),
        FAST("Fast", "Fast"),
        VIGILANT("Vigilant", "Vigilant");

        private String value;
        private String visibleText;

        Temperaments(String value, String visibleText) {
            this.value = value;
            this.visibleText = visibleText;
        }
    }

    public CardsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void searchDog(String text) {
        WebElement searchBar = driver.findElement(searchBarLocator);
        // WebElement searchButton = driver.findElement(searchButtonLocator);
        // wait.until(ExpectedConditions.visibilityOf(searchBar));
        // wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchBar.sendKeys(text);
        // searchButton.click();
        searchBar.submit();
    }

    public void selectTemperamentByValue(Temperaments temperament) {
        Select select = new Select(driver.findElement(temperamentsSelectLocator));
        select.selectByValue(temperament.value);
    }

    public void selectTemperamentByVisibleText(Temperaments temperament) {
        Select select = new Select(driver.findElement(temperamentsSelectLocator));
        select.selectByVisibleText(temperament.visibleText);
    }

    public void selectTemperamentByIndex(int index) {
        Select select = new Select(driver.findElement(temperamentsSelectLocator));
        try {
            select.selectByIndex(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("The temperament is out of bounds");
        }
    }

    public void selectTemperamentRandomly() {
        List<WebElement> options = (new Select(driver.findElement(temperamentsSelectLocator))).getOptions();
        int randomIndex = (int) (Math.random() * options.size());
        options.get(randomIndex).click();
    }

    public void clickNameSortButton() {
        driver.findElement(nameSortButton).click();
    }

    public void clickWeightSortButton() {
        driver.findElement(weightSortButton).click();
    }

    public void clickCreateDogCardButton() {
        driver.findElement(createDogCardButton).click();
    }

    // TODO select using random index, and other case for not using a wrong index
    public void clickNavigationButton(int index) {
        getNavigationButtons().get(index).click();
    }

    private List<WebElement> getNavigationButtons() {
        if (navigationButtons == null)
            navigationButtons = driver.findElements(navigationButtonsLocator);
        return navigationButtons;
    }

    // public void waitForCardsUpdate(String expectedText) {
    //     wait.until(ExpectedConditions.visibilityOfElementLocated(cardTitlesLocator));
    //     while (true) {
    //         try {
    //             wait.until(ExpectedConditions
    //                     .textToBePresentInElement(driver.findElement(cardTitlesLocator), expectedText));
    //             break;
    //         } catch (TimeoutException e) {
    //             System.out.println("Waiting for the element to load...");
    //         }
    //     }
    // }

    // public void waitForSelectsToLoad() {
    //     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropboxLocator));
    // }

    // public void simpleWaitForCardsUpdate() {
    //     wait.until(ExpectedConditions.visibilityOfElementLocated(cardTitlesLocator));
    // }

    public int getNumberOfCards() {
        return driver.findElements(cardsLocator).size();
    }
}