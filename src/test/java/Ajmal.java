import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ajmal {


    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement Form = driver.findElement(By.xpath("//h5[text()='Forms']"));
        Form.click();
        WebElement PracticeForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        PracticeForm.click();
        WebElement FirstName = driver.findElement(By.id("firstName"));
        FirstName.sendKeys("Ali");
        WebElement LastName = driver.findElement(By.id("lastName"));
        LastName.sendKeys("Gul");
        WebElement Email = driver.findElement(By.id("userEmail"));
        Email.sendKeys("Ali.gul@test.com");

            WebElement dobField = driver.findElement(By.id("dateOfBirthInput"));
            dobField.click();
            Select month = new Select(
                    driver.findElement(By.className("react-datepicker__month-select")));
            month.selectByVisibleText("August");
            Select year = new Select(
                    driver.findElement(By.className("react-datepicker__year-select")));
            year.selectByVisibleText("1998");
            driver.findElement(By.xpath(
                            "//div[contains(@class,'react-datepicker__day') and text()='15']"))
                    .click();
            String actualDate = dobField.getAttribute("value");
            Assert.assertEquals(actualDate, "15 Aug 1998",
                    "Date of Birth is not selected correctly");


        WebElement Gender = driver.findElement(By.id("gender-radio-1"));
        Gender.isSelected();
        WebElement Mobile = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        Mobile.sendKeys("8042323231");
        WebElement Subjects = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        Subjects.sendKeys("Maths");
        WebElement Hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        Hobbies.isSelected();
        WebElement CurrentAddress = driver.findElement(By.id("currentAddress"));
        CurrentAddress.sendKeys("2344 Henrico");
        WebElement SubmitButton = driver.findElement(By.id("//button[@class='btn btn-primary']"));
        SubmitButton.click();












    }
}
