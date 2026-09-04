import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ZipCodeTest {
    @Test
    public void checkZipCodeDigits() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error_message"))).getText();
        Assert.assertEquals("Oops, error on page. ZIP code should have 5 digits", errorText);

        driver.quit();
    }
}
