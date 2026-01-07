import org.testng.Assert;
import org.testng.annotations.Test;

public class test {


    @Test(description = "test description")
    public void testName() {
        Assert.assertTrue(true, "String message");

    }
}
