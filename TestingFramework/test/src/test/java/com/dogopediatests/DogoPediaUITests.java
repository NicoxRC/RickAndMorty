package com.dogopediatests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dogopediatests.pages.CardsPage;
import com.uitests.pages.CharactersPage;

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
    public void searchBarTest() {
        CardsPage cardsPage;   
    }
}