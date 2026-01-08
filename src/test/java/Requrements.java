import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Requrements {

     WebDriver driver;

    @BeforeMethod
    public void setUp() {
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
        elementButton.click();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current url is:      " + currentURL);
        boolean result = false;
        if (currentURL.contains("elements")){
            result = true;
        }else {
            result = false;
        }
        Assert.assertTrue(result);
    }

    @Test
    public void req004() {

        WebElement formsButton = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsButton.click();
        String expectedHeader = "Please select an item from left to start practice.";
        String formHeader = driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).getText();
        Assert.assertEquals(formHeader, expectedHeader );

        WebElement practiceFormLink = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormLink.click();

        String expectedHeader2 = "Practice Form";
        WebElement practiceFormHeader = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
        String actualPracticeFormHeader = practiceFormLink.getText();
        Assert.assertEquals(actualPracticeFormHeader, expectedHeader2);
    }

}
