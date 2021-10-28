package relative_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RelativeLocators {

    //Relative Locators: below(),toLeftOf(),toRightOf(),above(),near()

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://automationbookstore.dev/");
        driver.manage().window().maximize();
    }

    //Test Book 5 is left of Book 6 & below Book1

    @Test
    public void testBook5() {
        WebElement book5 = driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));

        String id = book5.getAttribute("id");
        System.out.println(id);
        Assert.assertEquals("pid5",id);
    }

    //Test Book2 is above Book6 & right of Book1

    @Test
    public void testBook2() {
        WebElement book2 = driver.findElement(RelativeLocator.with(By.tagName("li")).toRightOf(By.id("pid1")).above(By.id("pid6")));

        String id = book2.getAttribute("id");
        System.out.println(id);
        Assert.assertEquals("pid2",id);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
