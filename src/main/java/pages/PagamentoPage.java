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

public class PagamentoPage extends BasePage {
    //Instancias
    WebDriver driver = DriverFactory.getDriver();
    ValidationsHelper helper = new ValidationsHelper();
    Logger logger = LogManager.getLogger(this);

    //Construtor
    public PagamentoPage() {
        PageFactory.initElements(driver, this);
    }

    //Mapeamento

    @FindBy(className = "page-heading")
    private WebElement tituloPagina;

    @FindBy(xpath = "//p[@class='product-name']//a")
    private WebElement nomeProduto;

    @FindBy(xpath = "//small//a[contains(text(),'Color')]")
    private WebElement corETamanho;

    @FindBy(xpath = "//span[contains(@id,'product_price_')]//span")
    private WebElement valorUnitario;

    @FindBy(xpath = "//*[contains(@class,'cart_quantity')]")
    private WebElement quantidade;

    @FindBy(xpath = "//td[@class='cart_total']//span")
    private WebElement valorTotalProduto;

    @FindBy(id = "total_shipping")
    private WebElement valorTotalFrete;

    @FindBy(id = "total_price")
    private WebElement valorTotalDaCompra;

    // Métodos

    public void validarPagina() {
        logger.info("Validando página " + tituloPagina.getText());
        esperarElementoEstarVisivel(tituloPagina, 10);
        Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", tituloPagina.getText());

        logger.info("Página validada.");
    }

    public void validarInformacoesDaCompra() {

        logger.info("Validando informações da compra");
        Assert.assertEquals(helper.getNomeProduto(), nomeProduto.getText());
        Assert.assertTrue("Não contém a cor correta do produto", corETamanho.getText().contains(helper.getCor()));
        Assert.assertTrue("Não contém o tamanho correto do produto", corETamanho.getText().contains(helper.getTamanho()));

        float valorUnit = Float.parseFloat(valorUnitario.getText().replaceAll("\\$", ""));
        Assert.assertTrue("O valor unitário não está correto", helper.getValorUnitario() == valorUnit);

        int qtd = Integer.parseInt(quantidade.getText());
        Assert.assertTrue("A quantidade está incorreta", helper.getQuantidade() == qtd);

        float totalProd = Float.parseFloat(valorTotalProduto.getText().replaceAll("\\$", ""));
        Assert.assertTrue("Total do produto diferente", helper.calcularTotalDoProduto(helper.getValorUnitario(), helper.getQuantidade()) == totalProd);

        float totalFrt = Float.parseFloat(valorTotalFrete.getText().replaceAll("\\$", ""));
        Assert.assertTrue("Valor do frete diferente", helper.getValorFrete() == totalFrt);

        float totalCompraNaPagina = Float.parseFloat(valorTotalDaCompra.getText().replaceAll("\\$", ""));
        Assert.assertTrue("Valor total da compra diferente", helper.calcularTotalDaCompra() == totalCompraNaPagina);

        logger.info("Informações validadas com sucesso.");

    }

    public void escolherFormaDePagamento(String metodo) {

        logger.info("Verificando método de pagamento");
        WebElement metodoPagamento = driver.findElement(By.xpath("//a[@class='" + metodo + "']"));
        esperarElementoEstarClicavel(metodoPagamento, 10);

        logger.info("Método de pagamento verificado");

        metodoPagamento.click();
    }

}
