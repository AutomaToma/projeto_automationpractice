package pages;

import core.DriverFactory;
import evidences.Evidences;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();
    Evidences evidences = new Evidences();
    Logger logger = LogManager.getLogger(this);


    public CadastroPage() {
        PageFactory.initElements(driver, this);
    }

    //    Mapeamento

    @FindBy(className = "page-heading")
    private WebElement tituloCriarConta;

    @FindBy(id = "id_gender1")
    private WebElement Mr;

    @FindBy(id = "id_gender2")
    private WebElement Mrs;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement passwd;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement years;

    @FindBy(id = "firstname")
    private WebElement addressFirstName;

    @FindBy(id = "lastname")
    private WebElement addressLastName;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement zip;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement cell;

    @FindBy(id = "alias")
    private WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    private WebElement register;

    // MÉTODOS

    public void tituloCriarConta() {
        Assert.assertTrue(tituloCriarConta.isDisplayed());
    }

    public void preencherFormulario(DataTable dataTable) {

        logger.info("Preencher formulário");

        if (getData(dataTable, "Title").equals("Mr.")) {
            Mr.click();
            logger.info("Selecionado Mr.");

        } else if (getData(dataTable, "Title").equals("Mrs.")) {
            Mrs.click();
            logger.info("Selecionado Mrs.");
        }

        logger.info("Dados de login à serem preenchidos");

       firstName.sendKeys(getData(dataTable, "FirstName"));
        lastName.sendKeys(getData(dataTable, "LastName"));
        passwd.sendKeys(getData(dataTable, "Password"));

        logger.info("Primeiro nome " + firstName.getText() + " preenchido");
        logger.info("Último nome " + lastName.getText() + " preenchido");
        logger.info("Senha " + passwd.getText() + " preenchida");

        String[] data=getData(dataTable, "DateOfBirth").split("/");

        selecionarPorValue(days, data[0]);
        selecionarPorValue(months, data[1]);
        selecionarPorValue(years, data[2]);

        logger.info("Data de nascimento " + getData(dataTable, "DateOfBirth") + " preenchida");

        evidences.tirarPrint("Informações inseridas");

        addressFirstName.sendKeys(getData(dataTable, "AddressFirstName"));
        addressLastName.sendKeys(getData(dataTable, "AddressLastName"));
        address.sendKeys(getData(dataTable, "Address"));
        city.sendKeys(getData(dataTable, "City"));
        state.sendKeys(getData(dataTable, "State"));
        zip.sendKeys(getData(dataTable, "Zip"));
        country.sendKeys(getData(dataTable, "Country"));
        cell.sendKeys(getData(dataTable, "MobilePhone"));
        aliasAddress.sendKeys(getData(dataTable, "AddressAlias"));

        logger.info("Primeiro nome destinatário " + getData(dataTable, "AddressFirstName") + " preenchido");
        logger.info("Último nome destinatário " + getData(dataTable, "AddressLastName") + " preenchido");
        logger.info("Endereço " + getData(dataTable, "Address") + " preenchido");
        logger.info("Cidade " + getData(dataTable, "City") + " preenchida");
        logger.info("Estado " + getData(dataTable, "State") + " preenchido");
        logger.info("CEP " + getData(dataTable, "Zip") + " preenchido");
        logger.info("País " + getData(dataTable, "Country") + " preenchido");
        logger.info("Celular " + getData(dataTable, "MobilePhone") + " preenchido");
        logger.info("Apelido destinatário " + getData(dataTable, "AddressAlias") + " preenchido");


        evidences.tirarPrint("Endereço preenchido");

        register.click();

    }


}
