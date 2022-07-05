package pages;

import com.github.javafaker.Faker;
import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    WebDriver driver = DriverFactory.getDriver();
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

//    Mapeamento

    @FindBy(id = "create-account_form")
    private WebElement validarPagina;

    @FindBy (id = "email_create")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccount;

    Faker faker=new Faker();

//    Metodos

    public void validarPagina(){
        Assert.assertTrue(validarPagina.isDisplayed());
    }

    public void preencherEmail(){
        emailCreate.sendKeys(faker.dragonBall().character().trim() + faker.gameOfThrones().dragon().trim() + "@gmail.com");
    }

    public void clicarEmCriar(){
        createAnAccount.click();
    }

}
