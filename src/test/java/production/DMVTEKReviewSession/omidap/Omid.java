import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Omid {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
    }

    @Test
    public void re001() {
        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Page title mismatch");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h5[text()='Elements']")));
        WebElement alertFrameWindowButton = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));

        Assert.assertTrue(element.isDisplayed(), "Elements are not displayed");
        Assert.assertTrue(alertFrameWindowButton.isDisplayed(), "Category cards are not displayed");
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


}
