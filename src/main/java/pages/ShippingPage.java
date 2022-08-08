package pages;

import core.DriverFactory;
import helpers.ValidationsHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage{

    // Instancia do webdriver
    WebDriver driver = DriverFactory.getDriver();
    ValidationsHelper helper = new ValidationsHelper();

    // Construtor
    public ShippingPage(){
        PageFactory.initElements(driver, this);
    }

    // Mapeamento

    @FindBy(className = "page-heading")
    private WebElement tituloShippingPage;

    @FindBy(xpath = "//div[@class='delivery_option_price']")
    private WebElement valorFrete;

    @FindBy(id = "cgv")
    private WebElement botaoAceitarTermos;

    @FindBy(name = "processCarrier")
    private WebElement btnProsseguirParaCheckout;

    // Métodos

    public void validarPagina(){
        esperarElementoEstarVisivel(tituloShippingPage, 10);
        Assert.assertEquals("SHIPPING", tituloShippingPage.getText());
    }

    public void validarValorFrete(){
        esperarElementoEstarVisivel(valorFrete, 10);
        float frete = Float.parseFloat(valorFrete.getText().replaceAll("\\$", ""));

        // Validação pica
        Assert.assertTrue("O valor do frete está diferente", helper.getValorFrete() == frete);

        // Validação JR
        /*
        if(helper.getValorFrete() == frete){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
        */
    }

    public void aceitarTermosDeServico(){
        esperarElementoEstarClicavel(botaoAceitarTermos, 10);
        botaoAceitarTermos.click();
        btnProsseguirParaCheckout.click();
    }

}
