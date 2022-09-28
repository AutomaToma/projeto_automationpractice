package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginSteps {
    HomePage home = new HomePage();
    LoginPage login = new LoginPage();
    MyAccountPage myAccount = new MyAccountPage();

    @Dado("que o usuário acesse a página de login")
    public void que_o_usuário_acesse_a_página_de_login() {
        home.validarHome();
        home.signIn();
        login.validarPagina();
    }

    @Quando("preencher os campos com dados validos:")
    public void preencherOsCamposComDadosValidos(DataTable dataTable) {
        login.logar(dataTable);
    }

    @Quando("preencher os campos com dados validos")
    public void preencherOsCamposComDadosValidos(){
        login.logar();
    }

    @Então("o login é realizado com sucesso")
    public void o_login_é_realizado_com_sucesso() {
        myAccount.validarMyAccount();
    }


}
