package pages;

import core.DriverFactory;
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

    @FindBy(id = "center_column")
    private WebElement myAccount;

    public void validarMyAccount(){
        esperarElementoEstarVisivel(myAccount,15);
        Assert.assertTrue(myAccount.isDisplayed());
        espera(3);
    }

}
