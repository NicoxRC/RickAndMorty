package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        // configure web driver for chrome
        System.setProperty("webdriver.chrome.driver", "D:\\Proyectos\\RickAndMorty\\TestingFramework\\src\\chromedriver.exe");
        // create a new instance of chrome driver
        WebDriver driver = new ChromeDriver();
        // navigate to google.com
        driver.get("http://localhost:3000/");

        Thread.sleep(2000);

        WebElement elemento = driver.findElement(By.className("form-select"));

        elemento.click();

        driver.quit();
        driver.close();
    }
}
