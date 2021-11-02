package openin_secureweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v85.security.Security;
import org.testng.annotations.Test;

public class OpenInsecureWeb {

    @Test
    public void openInSecureWeb() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools=((ChromiumDriver)driver).getDevTools();

        devTools.createSession();

        devTools.send(Security.setIgnoreCertificateErrors(true));

        driver.get("https://formy-project.herokuapp.com/");
    }
}
