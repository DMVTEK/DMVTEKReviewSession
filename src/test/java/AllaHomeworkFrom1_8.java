package production.DMVTEKReviewSession;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class AllaHomeworkFrom1_8 {

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
    public void req() throws InterruptedException  {
        //Verify homepage loads successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/";
        Assert.assertEquals(actualUrl, expectedUrl);

        //Verify forms and practice form loads successfully
        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsButton.click();
        String expectedHeader = "Please select an item from left to start practice.";
        String formHeader = driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).getText();
        Assert.assertEquals(formHeader, expectedHeader);

        WebElement practiceFormLink = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormLink.click();

        String expectedHeader2 = "Practice Form";
        WebElement practiceFormHeader = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
        String actualPracticeFormHeader = practiceFormHeader.getText();
        Assert.assertEquals(actualPracticeFormHeader, expectedHeader2);

        // Find fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement mobile = driver.findElement(By.id("userNumber"));
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        WebElement address = driver.findElement(By.id("currentAddress"));


        // Fill Fields
        firstName.sendKeys("John");
        lastName.sendKeys("Smith");
        email.sendKeys("john.smith@test.com");
        mobile.sendKeys("9876543210");
        address.sendKeys("123 Test Street, NY");

        subject.sendKeys("Math");
        subject.sendKeys(Keys.ENTER);
        subject.sendKeys("Physics");
        subject.sendKeys(Keys.ENTER);

        dob.click();
        WebElement months = driver.findElement(By.cssSelector("select.react-datepicker__month-select"));
        Select selectMonth = new Select(months);
        selectMonth.selectByVisibleText("August");

        WebElement years = driver.findElement(By.cssSelector("select.react-datepicker__year-select"));
        Select selectYear = new Select(years);
        selectYear.selectByVisibleText("1998");

        WebElement day = driver.findElement(By.cssSelector(".react-datepicker__day--015"));
        day.click();

        //Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitButton);

        //Check result
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement modalTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("example-modal-sizes-title-lg")
                )
        );

        Assert.assertTrue(modalTitle.isDisplayed());
    }
}
