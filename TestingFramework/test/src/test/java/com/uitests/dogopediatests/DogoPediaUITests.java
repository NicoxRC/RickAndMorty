package com.uitests.dogopediatests;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uitests.dogopediatests.components.DogCard;
import com.uitests.dogopediatests.pages.CardDetailsPage;
import com.uitests.dogopediatests.pages.CardsPage;

public class DogoPediaUITests {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dogopedia.vercel.app/home");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAmountOfCards() {
        CardsPage cardsPage = new CardsPage(driver);
        cardsPage.waitForPageLoad();

        int expectedNumberOfCards = 8;
        int actualNumberOfcards = cardsPage.getNumberOfDogCards();

        Assert.assertEquals(expectedNumberOfCards, actualNumberOfcards);
    }

    @Test
    public void testCardDetailsPage() {
        CardsPage cardsPage = new CardsPage(driver);
        cardsPage.waitForPageLoad();

        DogCard card = cardsPage.getRandomDogCart();
        card.saveDogInfo();
        card.clickCard();

        CardDetailsPage detailsPage = new CardDetailsPage(driver);
        detailsPage.waitForPageLoad();

        Assert.assertEquals(card.getSavedDogName(), detailsPage.getDogName());
        Assert.assertEquals(card.getSavedDogWeight(), detailsPage.getDogWeight());
        Assert.assertEquals(card.getSavedDogTemperament(), detailsPage.getDogTemperament());
    }

    @Test
    public void testTemperamentFilter() {
        final CardsPage cardsPage = new CardsPage(driver);
        cardsPage.waitForPageLoad();

        cardsPage.selectTemperamentRandomly();
        final String expectedTemperament = cardsPage.getTemperamentValue();
        final int NumberOfPages = cardsPage.getAmountOfNavigationButtons();

        assertSoftly(softly -> {
            for (int i = 0; i < NumberOfPages; i++) {
                CardsPage navigationCardsPage = new CardsPage(driver);
                navigationCardsPage.clickNavigationButton(i);
                
                List<DogCard> cards = navigationCardsPage.getAllDogCards();
                cards.forEach(card -> {
                    softly.assertThat(card.getDogTemperament())
                            .describedAs("The temperament of the dog " + card.getDogName() +
                                    " should be " + expectedTemperament + " but was " + card.getDogTemperament())
                            .containsIgnoringCase(expectedTemperament);
                });
            }
        });
    }
}