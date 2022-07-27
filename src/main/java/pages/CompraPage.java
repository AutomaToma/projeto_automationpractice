package pages;

import core.DriverFactory;
import helpers.ValidationsHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraPage extends BasePage {

    WebDriver driver = DriverFactory.getDriver();
    ValidationsHelper helper = new ValidationsHelper();

    public CompraPage() {
        PageFactory.initElements(driver, this);
    }

    //    Mapeamento

    @FindBy(id = "our_price_display")
    private WebElement txtValorUnitario;

    @FindBy(id = "quantity_wanted")
    private WebElement inputQuantidade;

    @FindBy(id = "group_1")
    private WebElement selectTamanho;

    @FindBy(name = "Submit")
    private WebElement btnAdicionarAoCarrinho;

    @FindBy(className = "icon-ok")
    private WebElement iconeOK;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement btnProssguirParaCheckout;

    @FindBy(xpath = "//span[@class='ajax_cart_shipping_cost']")
    private WebElement txtValorFrete;


    //MÉTODO

    public void selecionarCategoria(String categoria, String subcategoria) {
        WebElement categoria1 = null;

        if (subcategoria.isEmpty()) {
            categoria1 = driver.findElement(By.xpath("(//a[text() = '" + categoria + "'])[2]"));
            categoria1.click();
        } else {
            categoria1 = driver.findElement(By.xpath("(//a[text() = '" + categoria + "'])"));
            moveMouseToElement(categoria1);
            WebElement sub = driver.findElement(By.xpath("//a[text()='" + subcategoria + "']"));
            sub.click();
        }

        System.out.println("Selecionada categoria " + categoria);
    }

    public void selecionarProduto(String produto) {
        WebElement prod = driver.findElement(By.xpath("//a[contains(text(),'" + produto + "')]"));
        prod.click();

        //salvando nome do produto
        helper.setNomeProduto(produto);
    }

    public void finalizarSelecaoProduto(int quantidade, String tamanho, String cor) {

        //salvando valor unitário da peça, tamanho, cor e quantidade
        helper.setValorUnitario(Float.parseFloat(txtValorUnitario.getText().replaceAll("\\$", "")));
        helper.setTamanho(tamanho);
        helper.setCor(cor);
        helper.setQuantidade(quantidade);

        inputQuantidade.clear(); // Limpa o campo quantidade
        inputQuantidade.sendKeys(String.valueOf(quantidade)); // convertendo int para String com String.valueOf()

        selecionarPorTexto(selectTamanho, tamanho);

        WebElement corElemento = driver.findElement(By.name(cor));
        esperarElementoEstarClicavel(corElemento, 5);
        corElemento.click();

        esperarElementoEstarClicavel(btnAdicionarAoCarrinho, 5);
        btnAdicionarAoCarrinho.click();

        //mostrando que tá salvando
        System.out.println("------ VALORES SALVOS -----");
        System.out.println(helper.getValorUnitario());
        System.out.println(helper.getTamanho());
        System.out.println(helper.getCor());
        System.out.println(helper.getQuantidade());
        System.out.println("----------------------------");
    }

    public void prosseguirParaOCheckout() {
        esperarElementoEstarVisivel(iconeOK, 10);

        //Convertendo o valor do frete de String para Float e salvando
        helper.setValorFrete(Float.parseFloat(txtValorFrete.getText().replaceAll("\\$", "")));

        //validando modal de produto adicionado ao carrinho
        WebElement txtItemAdicionadoAoCarrinho = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt ']//parent::h2"));
        Assert.assertTrue(iconeOK.isDisplayed());
        esperarElementoEstarVisivel(txtItemAdicionadoAoCarrinho, 10);
        //Validar texto do modal
        if(helper.getQuantidade() > 1){
            Assert.assertEquals("There are " + helper.getQuantidade() + " items in your cart.", txtItemAdicionadoAoCarrinho.getText());
        }
        else{
            Assert.assertEquals("There is " + helper.getQuantidade() + " item in your cart.", txtItemAdicionadoAoCarrinho.getText());
        }

        esperarElementoEstarClicavel(btnProssguirParaCheckout, 5);
        btnProssguirParaCheckout.click();


    }

}
