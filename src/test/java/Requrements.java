import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
public class Requrements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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

    @Test
    public void req003() {
        WebElement elementButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", elementButton);
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current url is:      " + currentURL);
        boolean result = false;
        if (currentURL.contains("elements")) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertTrue(result);
    }


    @Test
    public void req004() {

        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", formsButton);
        String expectedHeader = "Please select an item from left to start practice.";
        String formHeader = driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).getText();
        Assert.assertEquals(formHeader, expectedHeader);

        WebElement practiceFormLink = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormLink.click();

        String expectedHeader2 = "Practice Form";
        WebElement practiceFormHeader = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
        String actualPracticeFormHeader = practiceFormLink.getText();
        Assert.assertEquals(actualPracticeFormHeader, expectedHeader2);
    }

    @Test
    public void req005() {

        WebElement WidgetsButton = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", WidgetsButton);

        WebElement practiceFormLink = driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']"));
        String expectedWidgetHeader = practiceFormLink.getText();
        String actualWidgetHeader = practiceFormLink.getText();
        Assert.assertEquals(actualWidgetHeader, expectedWidgetHeader);

        WebElement accordianButton = driver.findElement(By.xpath("//span[text()='Accordian']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", accordianButton);
        WebElement accordianHeader = driver.findElement(By.xpath("//h1[text()='Accordian']"));

        String expectedAccordianHeader = "Accordian";
        String actualAccordianHeader = accordianHeader.getText();
        Assert.assertEquals(actualAccordianHeader, expectedAccordianHeader);


    }

    @Test
    public void req006() {

        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsButton.click();

        String expectedRrl = "forms";
        String actualUrl = driver.getCurrentUrl();
        boolean result = false;
        if (actualUrl.contains(expectedRrl)) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertTrue(result);
        driver.navigate().back();

        WebElement seleniumImage = driver.findElement(By.xpath("//img[@class='banner-image']"));
        boolean imageIsPresent = seleniumImage.isDisplayed();
        Assert.assertTrue(imageIsPresent);

    }

    @Test
    public void req007() {
        WebElement logo =  driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void req008() throws InterruptedException {

        WebElement interactionsButton = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        interactionsButton.click();

        WebElement intractionsHeader = driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(intractionsHeader.isDisplayed());
        WebElement logo =  driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
        logo.click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://demoqa.com/");

    }

}
