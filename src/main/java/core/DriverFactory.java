package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    //varialvel do tipo WebDriver
    private static WebDriver driver = null;

    //variaval String que vai receber o caminho do arquivo chromedriver
    private static String chromePath = "src/test/resources/webdrivers/chromedriver.exe";

    //criar um método que sempre cria o webdriver
    public static WebDriver getDriver() {

        //criar instancia do webdriver -> Chrome
        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", chromePath);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            //configurar para abrir o navegador em tela cheia
            driver.manage().window().maximize();

            //configurar a espera implicita
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

            //ir para o site
            driver.get("https://automationpractice.com/index.php");
        }

        return driver;
    }

    //criar um método que encerra a execução do webdriver
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
