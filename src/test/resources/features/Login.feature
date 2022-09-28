#language: pt

Funcionalidade: Efetuar Login

  @TESTE-02
  Cenário: Login
    Dado que o usuário acesse a página de login
    Quando preencher os campos com dados validos:
      | Email                       | Password |
      | brunoaushduhashdu@gmail.com | 123456   |
    Então o login é realizado com sucesso

  @TESTE-05
  Cenário: Login
    Dado que o usuário acesse a página de login
    Quando preencher os campos com dados validos
    Então o login é realizado com sucesso