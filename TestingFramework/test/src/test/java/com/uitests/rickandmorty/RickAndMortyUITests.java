package com.uitests.rickandmorty;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uitests.rickandmorty.pages.CharactersPage;

/**
 * Unit test for simple App.
 */
public class RickAndMortyUITests {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchBarTest() {
        String expectedName = "Morty";

        CharactersPage charactersPage = new CharactersPage(driver);
        charactersPage.searchCharacter(expectedName);

        charactersPage.waitForCardsUpdate(expectedName);
        List<String> cardsName = charactersPage.getCardTitles();
        Assert.assertTrue(cardsName.size() > 0);

        cardsName.stream().forEach(
                name -> Assert.assertTrue("The name should contain \"" + expectedName + "\"",
                        name.contains(expectedName)));
    }

    /**
     * <p> Este test prueba todas las listas desplegables del sitio web.</p>
     * 
     * <p> Pasos de prueba:</p>
     * <ol>
     *  <li>Cambia opciones en todas las listas desplegables</li>
     *  <li>Verifica que se muestren los personajes correctos</li>
     *  <li>Verifica que se muestren los botones correctos</li>
     *  <li>Verifica que se muestren los estados correctos</li>
     * </ol>
     */
    @Test
    public void droptdownListsTest() {
        String expectedNameOne = "Arthricia";
        String expectedNameTwo = "Defiance Squanchette";
        int expectedNumberOfCards = 2;

        CharactersPage charactersPage = new CharactersPage(driver);

        charactersPage.simpleWaitForCardsUpdate();
        charactersPage.selectCharacterGender("Female", "value");
        charactersPage.selectCharacterSpecies("Alien", "value");
        charactersPage.selectCharacterStatus(1, "index");
        charactersPage.selectCharacterType("Cat-Person", "visibleText");
        charactersPage.waitForCardsUpdate(expectedNameOne);

        Assert.assertEquals("There should be 2 cards", charactersPage.getNumberOfCards(), expectedNumberOfCards);

        List<String> cardsName = charactersPage.getCardTitles();
        Assert.assertEquals("The first card should have the name: " + expectedNameOne,
                cardsName.get(0), expectedNameOne);

        Assert.assertEquals("The second card should have the name " + expectedNameTwo,
                cardsName.get(1), expectedNameTwo);

        Assert.assertEquals("There should be 2 buttons", charactersPage.getAmountOfCardButtons(), 2);

        List<String> statuses = charactersPage.getCardTexts();

        for (int i = 0; i < statuses.size(); i += 2) {
            Assert.assertTrue("The status of the card should be \"Alive\"", statuses.get(i).contains("Alive"));
        }
    }
}