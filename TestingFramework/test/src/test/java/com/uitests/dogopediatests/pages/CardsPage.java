package com.uitests.dogopediatests.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uitests.dogopediatests.components.DogCard;

public class CardsPage {
    private WebDriver driver;
    WebDriverWait wait;

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
    private Select temperamentSelect;

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitForPageLoad()  {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingHearth)));

    }
    // public void waitForCardsToBeVisible() throws InterruptedException {
    //     wait.until(ExpectedConditions.(cardsLocator));
    // }

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
        Select select = getTemperamentSelect();
        select.selectByValue(temperament.value);
    }

    public void selectTemperamentByVisibleText(Temperaments temperament) {
        Select select = getTemperamentSelect();
        select.selectByVisibleText(temperament.visibleText);
    }

    public void selectTemperamentByIndex(int index) {
        Select select = getTemperamentSelect();
        try {
            select.selectByIndex(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("The temperament is out of bounds");
        }
    }

    public void selectTemperamentRandomly() {
        List<WebElement> options = getTemperamentSelect().getOptions();
        // int randomIndex = (int) (Math.random() * options.size());
        // same but index 0 ommitted
        int randomIndex = (int) (Math.random() * (options.size() - 1)) + 1;
        options.get(randomIndex).click();
    }

    public String getTemperamentValue() {
        Select select = getTemperamentSelect();
        return select.getFirstSelectedOption().getText();
    }

    private Select getTemperamentSelect() {
        if (temperamentSelect == null)
            temperamentSelect = new Select(driver.findElement(temperamentsSelectLocator));
        return temperamentSelect;
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

    public List<DogCard> getAllDogCards() {
        if (cards == null)
            cards = driver.findElements(cardsLocator)
                    .stream()
                    .map(card -> new DogCard(card, driver))
                    .collect(Collectors.toList());
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