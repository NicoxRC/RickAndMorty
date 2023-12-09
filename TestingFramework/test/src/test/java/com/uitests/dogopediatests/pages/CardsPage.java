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
        selectByValue(temperamentsSelectLocator, temperament.value);
    }

    public void selectTemperamentByVisibleText(Temperaments temperament) {
        selectByVisibleText(temperamentsSelectLocator, temperament.visibleText);
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