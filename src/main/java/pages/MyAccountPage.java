package pages;

import core.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }
    Logger logger = LogManager.getLogger(this);

    @FindBy(id = "center_column")
    private WebElement myAccount;

    public void validarMyAccount(){
        logger.info("Validando página My Account");

        esperarElementoEstarVisivel(myAccount,15);
        Assert.assertTrue(myAccount.isDisplayed());
        espera(3);

        logger.info("Página My Account validada");
    }

}
