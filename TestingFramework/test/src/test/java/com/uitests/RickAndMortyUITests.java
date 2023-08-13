package com.uitests;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class RickAndMortyUITests {
    @Test
    public void searchBarTest() throws InterruptedException {

        String expectedName = "Morty";

        // create a new instance of chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Explicit wait 2 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        // navigate to google.com
        driver.get("http://localhost:3000/");

        WebElement searchBar = driver.findElement(By.xpath("//input[@type='search']"));
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(expectedName);

        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
        List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class, 'card-title')]"));

        Assert.assertTrue(names.size() > 0);

        names.stream().forEach(name -> Assert.assertTrue("The name should contain \"" + expectedName + "\"",
                name.getText().contains(expectedName)));
        driver.quit();
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
    public void droptdownListsTest() throws InterruptedException {
        String expectedNameOne = "Arthricia";
        String expectedNameTwo = "Defiance Squanchette";
        int expectedNumberOfCards = 2;

        // create a new instance of chrome driver
        WebDriver driver = new ChromeDriver();
        // navigate to google.com
        driver.get("http://localhost:3000/");

        // Explicit wait 2 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        List<WebElement> dropboxes = driver.findElements(By.className("form-select"));

        Select genderSelect = new Select(dropboxes.get(0));
        Select speciesSelect = new Select(dropboxes.get(1));
        Select statusSelect = new Select(dropboxes.get(2));
        Select typeSelect = new Select(dropboxes.get(3));

        genderSelect.selectByValue("Female");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
        speciesSelect.selectByValue("Alien");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
        statusSelect.selectByIndex(1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'card-title')]")));
        typeSelect.selectByVisibleText("Cat-Person");

        while (true) {
            try {
                wait.until(ExpectedConditions
                        .textToBePresentInElement(
                                driver.findElement(By.xpath("//h2[contains(@class, 'card-title')]")),
                                "Arthricia"));
                break;
            } catch (TimeoutException e) {
                System.out.println("Waiting for the element to load...");
            }
        }

        List<WebElement> cards = driver.findElements(By.xpath("//div[@class='card text-bg-dark']"));

        Assert.assertEquals("There should be 2 cards", cards.size(), expectedNumberOfCards);

        List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class, 'card-title')]"));

        Assert.assertEquals("The first card should have the name: " + expectedNameOne,
                names.get(0).getText(), expectedNameOne);

        Assert.assertEquals("The second card should have the name " + expectedNameTwo,
                names.get(1).getText(), expectedNameTwo);

        Assert.assertEquals("There should be 2 buttons",
                driver.findElements(By.xpath("//button[contains(text(), 'Go somewhere')]")).size(), 2);

        List<WebElement> statuses = driver.findElements(By.className("card-text"));

        for (int i = 0; i < statuses.size(); i += 2) {
            Assert.assertTrue("The status of the card should be \"Alive\"",
                    statuses.get(i).getText().contains("Alive"));
        }

        driver.quit();
    }
}