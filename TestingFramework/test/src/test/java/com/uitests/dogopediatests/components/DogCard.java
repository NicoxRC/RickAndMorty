package com.uitests.dogopediatests.components;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uitests.dogopediatests.pages.CardDetailsPage;

import lombok.Getter;

public class DogCard {

    final private WebElement root;
    private WebDriverWait wait;

    // By.xpath("./td")
    final private By dogNameLocator = By.className("name_dog_card");
    final private By dogWeightLocator = By.className("weight_dog_card");
    final private By dogTemperamentLocator = By.className("temperament_dog_card");

    @Getter
    String savedDogName;
    @Getter
    String savedDogWeight;
    @Getter
    String savedDogTemperament;

    public DogCard(WebElement card, WebDriver driver) {
        this.root = card;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public CardDetailsPage clickCard(WebDriver driver) {
        wait.until(ExpectedConditions.elementToBeClickable(root));
        root.click();
        return new CardDetailsPage(driver);
    }

    public void saveDogInfo() {
        savedDogName = getDogName();
        savedDogWeight = getDogWeight();
        savedDogTemperament = getDogTemperament();
    }
    
    public String getDogName() {
        return root.findElement(dogNameLocator).getText();
    }

    public String getDogWeight() {
        return root.findElement(dogWeightLocator)
        .getText().replace("\n", "")
        .split(":")[1].trim();
    }

    public String getDogTemperament() {
        return root.findElement(dogTemperamentLocator)
        .getText().replace("\n", "")
        .split(":")[1].replace("\"", "").trim();
    }
}
