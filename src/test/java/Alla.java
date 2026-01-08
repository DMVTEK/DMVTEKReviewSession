import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Alla {

    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void req001() {
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        WebElement alertFrameWindowButton = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        Assert.assertTrue(elementButton.isDisplayed());
        Assert.assertTrue(alertFrameWindowButton.isDisplayed());
    }

    @Test
    public void req002() {
        WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        WebElement alertFrameWindowButton = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        WebElement widgetsButton = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        WebElement interactionsButton = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        WebElement bookStoreApplicationButton = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));

        Assert.assertTrue(elementButton.isDisplayed());
        Assert.assertTrue(formsButton.isDisplayed());
        Assert.assertTrue(alertFrameWindowButton.isDisplayed());
        Assert.assertTrue(widgetsButton.isDisplayed());
        Assert.assertTrue(interactionsButton.isDisplayed());
        Assert.assertTrue(bookStoreApplicationButton.isDisplayed());
    }
}
