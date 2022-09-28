package pages;

import core.DriverFactory;
import helpers.ValidationsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends BasePage {
    WebDriver driver = DriverFactory.getDriver();
    ValidationsHelper validations = new ValidationsHelper();
    Logger logger = LogManager.getLogger(this);

    public SummaryPage() {
        PageFactory.initElements(driver, this);
    }

    //    Mapeamento

    @FindBy(id = "cart_title")
    private WebElement txtValidarPagina;

//    @FindBy(xpath = "(//p[@class = 'product-name']/a)[1]")
//    private WebElement txtProduto;

    @FindBy(id = "total_price")
    private WebElement txtPrecoTotal;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    private WebElement btnCheckout;

    //Metodos

    public void validarPagina(){
        logger.info("Validando página resumo pedido");
        Assert.assertTrue(txtValidarPagina.isDisplayed());
        Assert.assertEquals("SHOPPING-CART SUMMARY", txtValidarPagina.getText().substring(0,21).trim());

        logger.info("Página resumo pedido validada");
    }

    public void ValidarCompra(){
        logger.info("Validando total compra");
        espera(3);

        float totalProduto = Float.parseFloat(txtPrecoTotal.getText().replace("$",""));
        float calculoPrecoTotal = validations.calcularTotalDaCompra();

        WebElement txtProduto = driver.findElement(By.xpath("(//p[@class='product-name']//a[contains(text(),'" + validations.getNomeProduto() + "')])[2]"));

        logger.info(calculoPrecoTotal + " tem que ser igual " + totalProduto);

        Assert.assertEquals(validations.getNomeProduto(),txtProduto.getText().trim());
        Assert.assertTrue("Os valores são diferentes",calculoPrecoTotal==totalProduto);

        btnCheckout.click();

        logger.info("Validado cálculo total do pedido: " + validations.calcularTotalDaCompra());

    }
    public void clicarEmProsseguirParaOCheckout(){

        WebElement btnProsseguirParaOCheckout = driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]"));
        esperarElementoEstarVisivel(btnProsseguirParaOCheckout, 5);
        esperarElementoEstarClicavel(btnProsseguirParaOCheckout, 5);
        btnProsseguirParaOCheckout.click();

        logger.info("Validado tela Checkout");
    }

}
