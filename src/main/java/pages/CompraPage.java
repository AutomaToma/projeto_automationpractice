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

    @FindBy(xpath = "//a[@title = 'My Store']")
    private WebElement titleVitrine;

    @FindBy(id = "layer_cart_product_attributes")
    private  WebElement txtCorETamanho;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement txtQuantidade;

    @FindBy(id = "layer_cart_product_price")
    private WebElement txtValorProduto;




    //MÉTODO

    public void selecionarCategoria(String categoria, String subcategoria) {
        WebElement categoria1 = null;

        if (subcategoria.isEmpty()) {
            categoria1 = driver.findElement(By.xpath("(//a[text() = '" + categoria + "'])[2]"));
            categoria1.click();
        } else {
            categoria1 = driver.findElement(By.xpath("(//a[text() = '" + categoria + "'])"));
            moverMouseParaElemento(categoria1);
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

        //Salvando infos do produto
        String [] corETamanho = txtCorETamanho.getText().split(",");
        helper.setCor(corETamanho[0]);
        helper.setTamanho(corETamanho[1].trim());
        helper.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        helper.setValorUnitario(Float.parseFloat(txtValorProduto.getText().replaceAll("\\$", "")));


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

    public void voltarHome(){
        titleVitrine.click();
    }

    public void selecionarProdutoVitrine(String produto) {
        WebElement prod = driver.findElement(By.xpath("//a[contains(text(),'" + produto + "')]"));
        rolarAteOElemento(prod);
        moverMouseParaElemento(prod);
        helper.setNomeProduto(produto);

        espera(5);
        WebElement addCarrinho = driver.findElement(By.xpath("(//a[contains(text(),'" + produto + "')])[1]//../../div//a[@title='Add to cart']//span"));
        addCarrinho.click();
        prosseguirParaOCheckout();

    }

    // TODO: 15/08/2022 Falta checkout 

}
