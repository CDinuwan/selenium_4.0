package capture_screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {

    //Capture screenshot of specific WebElement

    @Test
    public void screenshot() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        File file=logo.getScreenshotAs(OutputType.FILE);

        File destFile=new File("logo.png");
        FileUtils.copyFile(file,destFile);

        driver.quit();
    }
}
