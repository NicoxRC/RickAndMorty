package com.uitests.core;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebComponent {
    private WebDriverWait wait;
    private int index;
    private Page parentPage;
    private WebElement contextElement;

    public WebComponent(Page parentPage, WebElement contextElement){//, List<WebElement> list) {
        this.parentPage = parentPage;
        this.contextElement = contextElement;
        wait = new WebDriverWait(parentPage.getDriver(), Duration.ofSeconds(5));
        // list.add(list.size(), parentPage.getDriver().findElement(element));
        // index = list.size() - 1;
    }

    protected <T> T waitUntil(final Function<? super WebDriver, T> condition) {
        return wait.until(condition);
    }

    protected WebElement getContextElement() {
        return contextElement;
    }

    protected Page getParentPage() {
        return parentPage;
    }

    protected int getIndex() {
        return index;
    }
}
