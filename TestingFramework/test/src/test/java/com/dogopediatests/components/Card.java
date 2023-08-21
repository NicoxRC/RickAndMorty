package com.dogopediatests.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

public class Card {
    
    public List<String> getCardTitles() {
        List<WebElement> names = driver.findElements(cardTitlesLocator);
        return names.stream().map(name -> name.getText()).collect(Collectors.toList());
    }

    public List<String> getCardTexts() {
        List<WebElement> texts = driver.findElements(cardTextLocator);
        return texts.stream().map(text -> text.getText()).collect(Collectors.toList());
    }
}
