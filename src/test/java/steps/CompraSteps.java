package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.*;

public class CompraSteps {

    HomePage home = new HomePage();
    LoginPage login = new LoginPage();
    MyAccountPage myAccount = new MyAccountPage();
    CompraPage compra = new CompraPage();
    SummaryPage summary = new SummaryPage();


    @Dado("que esteja logado na pagina inicial")
    public void que_esteja_logado_na_pagina_inicial() {
        home.validarHome();
        home.signIn();
        login.validarPagina();

    }

    @E("acesse uma categoria {string} e subcategoria {string}")
    public void acesse_uma_categoria_e_subcategoria(String categoria, String subcategoria) {
        compra.selecionarCategoria(categoria, subcategoria);

    }

    @E("tenha escolhido o {string} e {int} com {string} e {string} para compra")
    public void tenha_escolhido_o_e_com_e_para_compra(String produto, Integer quantidade, String cor, String tamanho) {
        compra.selecionarProduto(produto);
        compra.finalizarSelecaoProduto(quantidade, tamanho, cor);
        compra.prosseguirParaOCheckout();
    }

    @E("validar o produto na tela de checkout")
    public void validar_o_produto_na_tela_de_checkout() {
        summary.validarPagina();
        summary.ValidarCompra();

    }

    @E("confirmar o endereco e opcao de entrega")
    public void confirmar_o_endereco_e_opcao_de_entrega() {

    }

    @Quando("escolher a forma de pagamento {string} e finalizar a compra")
    public void escolher_a_forma_de_pagamento_e_finalizar_a_compra(String string) {

    }

    @Entao("a compra devera ser realizada com sucesso")
    public void a_compra_devera_ser_realizada_com_sucesso() {

    }



}
