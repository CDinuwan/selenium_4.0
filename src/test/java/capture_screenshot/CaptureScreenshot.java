package capture_screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {

    //Capture screenshot of specific WebElement

    @Test
    public void webElementScreenshot() throws IOException {
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

    //Capture screenshot of page

    @Test
    public void screenShotOfaPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();

        TakesScreenshot ts=(TakesScreenshot) driver;

        File src=ts.getScreenshotAs(OutputType.FILE);

        File target=new File("Homepage.png");

        FileUtils.copyFile(src,target);

        driver.quit();
    }

    //Capture screenshot of a section in page

    @Test
    public void screenshotOfSectionInPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement pageSection=driver.findElement(By.xpath("//div[@class='jumbotron-fluid']"));

        File src=pageSection.getScreenshotAs(OutputType.FILE);

        File trg=new File("FeatureProd.png");
        FileUtils.copyFile(src,trg);

        driver.close();
    }

    //HighLight Element

    @Test
    public void highlightElementAndCaptureScreenshot() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        WebElement pageSection=driver.findElement(By.xpath("//div[@class='jumbotron-fluid']"));

        js.executeScript("arguments[0].style.border='2px solid red'",pageSection);


        File src=pageSection.getScreenshotAs(OutputType.FILE);

        File trg=new File("HighLightedSection.png");
        FileUtils.copyFile(src,trg);

        driver.close();
    }
}
