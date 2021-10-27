package open_newtab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenNewTab {

    //Open new tab on browser

    @Test
    public void openNewTab() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://formy-project.herokuapp.com/");

        Thread.sleep(5000);
        driver.quit();
    }
}
