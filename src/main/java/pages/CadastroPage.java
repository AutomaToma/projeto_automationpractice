package pages;

import core.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();

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
        if (getData(dataTable, "Title").equals("Mr.")) {
            Mr.click();
        } else if (getData(dataTable, "Title").equals("Mrs.")) {
            Mrs.click();
        }

       firstName.sendKeys(getData(dataTable, "FirstName"));
        lastName.sendKeys(getData(dataTable, "LastName"));
        passwd.sendKeys(getData(dataTable, "Password"));

        String[] data=getData(dataTable, "DateOfBirth").split("/");

        selecionarPorValue(days, data[0]);
        selecionarPorValue(months, data[1]);
        selecionarPorValue(years, data[2]);

        addressFirstName.sendKeys(getData(dataTable, "AddressFirstName"));
        addressLastName.sendKeys(getData(dataTable, "AddressLastName"));
        address.sendKeys(getData(dataTable, "Address"));
        city.sendKeys(getData(dataTable, "City"));
        state.sendKeys(getData(dataTable, "State"));
        zip.sendKeys(getData(dataTable, "Zip"));
        country.sendKeys(getData(dataTable, "Country"));
        cell.sendKeys(getData(dataTable, "MobilePhone"));
        aliasAddress.sendKeys(getData(dataTable, "AddressAlias"));
        register.click();

    }


}
