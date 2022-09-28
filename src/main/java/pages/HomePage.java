package pages;

import core.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class HomePage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();
    Utils utils = new Utils();
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // MAPEAMENTO DE ELEMENTO
    @FindBy(id = "header_logo")
    private WebElement logo;
    //    @FindBy(xpath = "//div[@class='header_user_info']//a")
    @FindBy(className = "login")
    private WebElement signIn;
    // MÉTODOS

    public void validarHome() {
        logger.info("Validando Home.");

        Assert.assertTrue(logo.isDisplayed());

        logger.info("Home Validada.");
    }

    public void signIn() {
        logger.info("Clicando no botão signin");

        espera(2);
        esperarElementoEstarVisivel(signIn, 10);
        signIn.click();
        espera(3);
        logger.info("Signin acessado");

    }


}
