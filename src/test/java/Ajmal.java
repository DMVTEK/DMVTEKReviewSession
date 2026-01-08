import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Ajmal {

    @Test
    public void verifyDemoQATitle() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");


        // Page Title
        String actualTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");

        // Locating of Elements

        List<WebElement> cards = driver.findElements(By.cssSelector(".card-body h5"));


        Assert.assertEquals(cards.size(), 6, "Cards count is not 6");

        String[] expectedTexts = {
                "Elements",
                "Forms",
                "Alerts, Frame & Windows",
                "Widgets",
                "Interactions",
                "Book Store Application"


        };

        for (int i = 0; i < cards.size(); i++) {

            String actualText = cards.get(i).getText();
            Assert.assertEquals(actualText, expectedTexts[i], "Text mismatch at card index: " + i);

            System.out.println("Cards " + (i + 1) + ": " + actualText);

        }




        driver.quit();
    }
}

