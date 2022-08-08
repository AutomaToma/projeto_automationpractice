package pages;

import core.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePage{

    WebDriver driver = DriverFactory.getDriver();

    public OrderSummaryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "page-heading")
    private WebElement tituloPagina;



    public void validarPagina(){
        esperarElementoEstarVisivel(tituloPagina, 10);
        Assert.assertTrue("Titulo da página incorreto", tituloPagina.getText().contains("ORDER SUMMARY"));
    }



}
