package com.uitests.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebComponent {

    private int index;
    private Page parentPage;
    private WebElement contextElement;

    public WebComponent(Page parentPage, WebElement element){//, List<WebElement> list) {
        this.parentPage = parentPage;
        this.contextElement = element;
        // list.add(list.size(), parentPage.getDriver().findElement(element));
        // index = list.size() - 1;
    }

    protected Page getParentPage() {
        return parentPage;
    }

    protected int getIndex() {
        return index;
    }
}
