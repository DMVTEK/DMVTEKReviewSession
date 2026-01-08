import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Requrements {

     WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    @AfterMethod
    public void tearDown() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destination = System.getProperty("user.dir")
                    + File.separator
                    + "src"
                    + File.separator
                    + "test"
                    + File.separator
                    + "screenshot"
                    + File.separator
                    + "loginPage_"
                    + timestamp + ".png";

            File destFile = new File(destination);
            destFile.getParentFile().mkdirs(); // ensure folders exist
            FileUtils.copyFile(source, destFile);

            System.out.println("Screenshot saved at: " + destination);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        } finally {
            if (driver != null)
                driver.quit();
        }

    }

    @Test
    public void req001() {
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        WebElement alertFrameWindowButton = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        Assert.assertTrue(elementButton.isDisplayed());
        Assert.assertTrue(alertFrameWindowButton.isDisplayed());

    }

    @Test
    public void req002() {
        WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        WebElement alertFrameWindowButton = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        WebElement WidgetsButton = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        WebElement interactionsButton = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        WebElement bookStoreApplicationButton = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
        Assert.assertTrue(elementButton.isDisplayed());
        Assert.assertTrue(alertFrameWindowButton.isDisplayed());
        Assert.assertTrue(formsButton.isDisplayed());
        Assert.assertTrue(interactionsButton.isDisplayed());
        Assert.assertTrue(WidgetsButton.isDisplayed());
        Assert.assertTrue(bookStoreApplicationButton.isDisplayed());

    }
}
