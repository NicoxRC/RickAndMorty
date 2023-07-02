package com.uitests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

/**
 * Unit test for simple App.
 */
public class RickAndMortyUITests {
    @Test
    public void searchBarTest() throws InterruptedException {

        String expectedName = "Morty";

        // create a new instance of chrome driver
        WebDriver driver = new ChromeDriver();

        // navigate to google.com
        driver.get("http://localhost:3000/");

        // TODO quitar sleeps y usar waits, y usar asserts mas pros
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expectedName);

        driver.findElement(By.xpath("//button[contains(text(), 'Search')]")).click();

        Thread.sleep(2000);

        List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class, 'card-title')]"));

        names.stream().forEach(name -> {
            Assert.isTrue(name.getText().contains(expectedName), "The name should contain \"" + expectedName + "\"");
        });
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

        // create a new instance of chrome driver
        WebDriver driver = new ChromeDriver();
        // navigate to google.com
        driver.get("http://localhost:3000/");

        Thread.sleep(2000);

        List<WebElement> dropboxes = driver.findElements(By.className("form-select"));

        Select genderSelect = new Select(dropboxes.get(0));
        Select speciesSelect = new Select(dropboxes.get(1));
        Select statusSelect = new Select(dropboxes.get(2));
        Select typeSelect = new Select(dropboxes.get(3));

        genderSelect.selectByValue("Female");
        Thread.sleep(1000);
        speciesSelect.selectByValue("Alien");
        Thread.sleep(1000);
        statusSelect.selectByIndex(1);
        Thread.sleep(1000);
        typeSelect.selectByVisibleText("Cat-Person");
        Thread.sleep(1000);

        List<WebElement> cards = driver.findElements(By.xpath("//div[@class='card text-bg-dark']"));

        Assert.isTrue(cards.size() == 2, "There should be 2 cards");

        List<WebElement> names = driver.findElements(By.xpath("//h2[contains(@class, 'card-title')]"));

        Assert.isTrue(names.get(0).getText().equals(expectedNameOne),
                "The first card should have the name " + expectedNameOne);

        Assert.isTrue(names.get(1).getText().equals(expectedNameTwo),
                "The second card should have the name " + expectedNameTwo);

        Assert.isTrue(
                driver.findElements(By.xpath("//button[contains(text(), 'Go somewhere')]")).size() == 2,
                "There should be 2 buttons");

        List<WebElement> statuses = driver.findElements(By.className("card-text"));

        for (int i = 0; i < statuses.size(); i += 2) {
            Assert.isTrue(statuses.get(i).getText().contains("Alive"), "The status of the card should be \"Alive\"");
        }

        // driver.close();
        driver.quit();
    }
}
