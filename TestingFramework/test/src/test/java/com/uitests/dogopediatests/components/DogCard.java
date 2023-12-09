package com.uitests.dogopediatests.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uitests.core.Page;
import com.uitests.core.WebComponent;
import com.uitests.dogopediatests.pages.CardDetailsPage;

import lombok.Getter;

public class DogCard extends WebComponent {
    final private By dogNameLocator = By.className("name_dog_card");
    final private By dogWeightLocator = By.className("weight_dog_card");
    final private By dogTemperamentLocator = By.className("temperament_dog_card");

    @Getter
    String savedDogName;
    @Getter
    String savedDogWeight;
    @Getter
    String savedDogTemperament;

    public DogCard(Page parentPage, WebElement contextElement){
        super(parentPage, contextElement);
    }

    public CardDetailsPage clickCard(WebDriver driver) {
        waitUntil(ExpectedConditions.elementToBeClickable(getContextElement()));
        getContextElement().click();
        return new CardDetailsPage(driver);
    }

    public void saveDogInfo() {
        savedDogName = getDogName();
        savedDogWeight = getDogWeight();
        savedDogTemperament = getDogTemperament();
    }
    
    public String getDogName() {
        return getContextElement().findElement(dogNameLocator).getText();
    }

    public String getDogWeight() {
        return getContextElement().findElement(dogWeightLocator)
        .getText().replace("\n", "")
        .split(":")[1].trim();
    }

    public String getDogTemperament() {
        return getContextElement().findElement(dogTemperamentLocator)
        .getText().replace("\n", "")
        .split(":")[1].replace("\"", "").trim();
    }
}
