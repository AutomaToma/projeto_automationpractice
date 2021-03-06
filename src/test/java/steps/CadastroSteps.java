package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.*;

public class CadastroSteps {

    HomePage home = new HomePage();
    LoginPage login = new LoginPage();
    CadastroPage cadastro = new CadastroPage();
    MyAccountPage myAccount = new MyAccountPage();

    @Dado("que o usuário acesse a página de cadastro")
    public void que_o_usuario_acesse_a_pagina_de_cadastro() {
        home.validarHome();
        home.signIn();
    }

    @Quando("preenche corretamente os campos:")
    public void preenche_corretamente_os_campos(DataTable dataTable) {
        login.validarPagina();
        login.preencherEmail();
        login.clicarEmCriar();
        cadastro.tituloCriarConta();
        cadastro.preencherFormulario(dataTable);
    }

    @Então("o cadastro é realizado com sucesso")
    public void o_cadastro_e_realizado_com_sucesso() {
        myAccount.validarMyAccount();

    }


}
