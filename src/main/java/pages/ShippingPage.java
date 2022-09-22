package pages;

import core.DriverFactory;
import helpers.ValidationsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage{

    // Instancia do webdriver
    WebDriver driver = DriverFactory.getDriver();
    ValidationsHelper helper = new ValidationsHelper();
    Logger logger = LogManager.getLogger(this);

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

        logger.info("Validando página de frete");
        esperarElementoEstarVisivel(tituloShippingPage, 10);
        Assert.assertEquals("SHIPPING", tituloShippingPage.getText());

        logger.info("Página validada");
    }

    public void validarValorFrete(){

        logger.info("Validando valor frete");
        esperarElementoEstarVisivel(valorFrete, 10);
        float frete = Float.parseFloat(valorFrete.getText().replaceAll("\\$", ""));

        // Validação pica
        Assert.assertTrue("O valor do frete está diferente", helper.getValorFrete() == frete);

        logger.info("Validado valor frete de " + helper.getValorFrete());

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

        logger.info("Validando Termos de Serviço");
        esperarElementoEstarClicavel(botaoAceitarTermos, 10);
        botaoAceitarTermos.click();
        btnProsseguirParaCheckout.click();

        logger.info("Termos de Serviço validado");
    }

}
