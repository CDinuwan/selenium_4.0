package chrome_devtools;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.AddHasNetworkConditions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.mobile.NetworkConnection;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v85.network.Network.emulateNetworkConditions;

public class ChromeDevToolsDemo {

    WebDriver driver;

    @Test
    public void enableNetworkOffline() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        DevTools devTools=((ChromiumDriver)driver).getDevTools();

        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000),Optional.empty(),Optional.empty()));

        devTools.send(emulateNetworkConditions(true,100,1000,2000,Optional.of(ConnectionType.WIFI)));

        driver.get("https://formy-project.herokuapp.com/");
    }

    @Test(description = "Get console logs")
    public void generateConsoleLogs() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        DevTools devTools=((ChromiumDriver)driver).getDevTools();

        devTools.createSession();

        devTools.send(Log.enable());
//        devTools.addListener(Log.entryAdded(),entry -> System.out.println(entry.asSeleniumLogEntry()));

        driver.get("https://formy-project.herokuapp.com/");
    }
}
