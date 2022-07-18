package pages;

import com.github.javafaker.Faker;
import core.DriverFactory;
import io.cucumber.datatable.DataTable;
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
    Faker faker=new Faker();

//    Mapeamento

    @FindBy(id = "create-account_form")
    private WebElement validarPagina;

    @FindBy (id = "email_create")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccount;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signIn;

//    Metodos

    public void validarPagina(){
        Assert.assertTrue(validarPagina.isDisplayed());
    }

    public void preencherEmail(){
        emailCreate.sendKeys(faker.dragonBall().character().replaceAll(" ","") + faker.gameOfThrones().dragon().replaceAll(" ","") + "@gmail.com");
    }

    public void clicarEmCriar(){
        createAnAccount.click();
    }

    public void logar(DataTable dataTable ){
        emailAddress.sendKeys(getData(dataTable, "Email"));
        password.sendKeys(getData(dataTable,"Password"));
        signIn.click();
        espera(2);
    }
}
