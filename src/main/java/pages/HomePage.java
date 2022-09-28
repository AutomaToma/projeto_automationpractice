package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class HomePage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();
    Utils utils = new Utils();

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
        Assert.assertTrue(logo.isDisplayed());
    }

    public void signIn() {
        espera(2);
        esperarElementoEstarVisivel(signIn, 10);
        signIn.click();
        espera(3);
    }


}
