package open_newwindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenNewWindow {

    //Open new window

    @Test
    public void openNewTab() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://formy-project.herokuapp.com/");

        Thread.sleep(5000);
        driver.quit();
    }
}
