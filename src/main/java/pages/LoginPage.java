package pages;

import com.github.javafaker.Faker;
import core.DriverFactory;
import static core.TestDataReader.*;
import evidences.Evidences;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    Logger logger = LogManager.getLogger(this);
    Evidences evidences = new Evidences();

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
        logger.info("Validando página.");

        Assert.assertTrue(validarPagina.isDisplayed());

        logger.info("Página validada.");
    }

    public void preencherEmail(){
        String email = faker.dragonBall().character().replaceAll(" ","") + faker.gameOfThrones().dragon().replaceAll(" ","") + "@gmail.com";

        logger.info("Email a ser preenchido: " + email);

        emailCreate.sendKeys(email);

        evidences.tirarPrint("Email preenchido");
        logger.info("Email preenchido");
    }

    public void clicarEmCriar(){
        logger.info("Clicando em 'criar conta'.");

        createAnAccount.click();

        logger.info("'Criar conta' acessado.");
    }

    public void logar(DataTable dataTable ){
        logger.info("Preenchendo dados: " + getData(dataTable, "Email"));
        logger.info("Preenchendo dados: " + getData(dataTable, "Password"));

        emailAddress.sendKeys(getData(dataTable, "Email"));
        password.sendKeys(getData(dataTable,"Password"));

        evidences.tirarPrint("Email e Password preenchidos");
        signIn.click();
        espera(2);

        logger.info("Dados preenchidos, acessado signin.");
    }

    public void logar(){
        logger.info("Preenchendo com dados da planilha - Email: " + getDt("in_email"));
        logger.info("Preenchendo com dados da planilha - Senha: " + getDt("in_senha"));
        emailAddress.sendKeys(getDt("in_email"));
        password.sendKeys(getDt("in_senha"));
        signIn.click();
        espera(2);
    }

}
