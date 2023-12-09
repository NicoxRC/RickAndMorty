package com.uitests.dogopediatests;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.assertj.core.api.Assertions.assertThat;

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
import com.uitests.dogopediatests.pojo.DogCardPojo;

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

        int expectedNumberOfCards = 8;
        int actualNumberOfcards = cardsPage.getNumberOfDogCards();

        Assert.assertEquals(expectedNumberOfCards, actualNumberOfcards);
    }

    @Test
    public void testCardDetailsPage() {
        CardsPage cardsPage = new CardsPage(driver);

        DogCard card = cardsPage.getRandomDogCart();
        DogCardPojo cardPojo = card.saveDogInfo();

        CardDetailsPage detailsPage = card.clickCard(driver);

        Assert.assertEquals(cardPojo.getDogName(), detailsPage.getDogName());
        Assert.assertEquals(cardPojo.getDogWeight(), detailsPage.getDogWeight());
        // Assert.assertEquals(card.getSavedDogTemperament(), detailsPage.getDogTemperament());
        assertThat(cardPojo.getDogTemperament())
                .describedAs("The temperament of the dog is not as expected")
                .isEqualTo(detailsPage.getDogTemperament());
    }

    @Test
    public void testTemperamentFilter() {
        final CardsPage cardsPage = new CardsPage(driver);

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