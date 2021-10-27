package capture_location;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureLocation {

    //Capture location on Web Element

    @Test
    public void captureLocation() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement logo=driver.findElement(By.xpath("//a[@id='logo']"));

        System.out.println("Height :"+logo.getRect().getDimension().getHeight());
        System.out.println("Width :"+logo.getRect().getDimension().getWidth());
        System.out.println("X Location :"+logo.getRect().getX());
        System.out.println("Y Location :"+logo.getRect().getY());

        driver.quit();
    }
}
