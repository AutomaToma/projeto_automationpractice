#language: pt

Funcionalidade: Realizar cadastro


  @TESTE-01
  Cenário: Realizar cadastro valido
    Dado que o usuário acesse a página de cadastro
    Quando preenche corretamente os campos:
      | Title | FirstName | LastName | Password | DateOfBirth | AddressFirstName | AddressLastName | Address            | City    | State | Zip   | MobilePhone | AddressAlias |
      | Mrs.  | Laura     | Tralala  | 12345    | 01/01/2000  | Casinha Street   | Teste           | Casinha Street,235 | Jaragua | Ohio  | 73001 | 11955995599 | Home         |
    Então o cadastro é realizado com sucesso
