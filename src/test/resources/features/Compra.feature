#language:pt

Funcionalidade: Realizar Compra

  Contexto: Comprar uma peça de roupa
  * que o usuário acesse a página de login
  * preencher os campos com dados validos:
    | Email                       | Password |
    | brunoaushduhashdu@gmail.com | 123456   |

  @TESTE-03
  Esquema do Cenario: Comprar uma peça da categoria
    E acesse uma categoria "T-shirts" e subcategoria ""
    E tenha escolhido o "<produto>" e <quantidade> com "<cor>" e "<tamanho>" para compra
    E validar o produto na tela de checkout
    E confirmar o endereco e opcao de entrega
    Quando escolher a forma de pagamento "<pagamento>" e finalizar a compra
    Entao a compra devera ser realizada com sucesso
    Exemplos:
      | produto                     | quantidade | cor  | tamanho | pagamento |
      | Faded Short Sleeve T-shirts | 2          | Blue | M       | bankwire  |

  @TESTE-04
  Esquema do Cenario: Comprar uma peça na vitrine
    E acesso a vitrine My store
    E tenho escolho um "<produto>"
    E validar o produto na tela de checkout
    E confirmar o endereco e opcao de entrega
    Quando escolher a forma de pagamento "<pagamento>" e finalizar a compra
    Entao a compra devera ser realizada com sucesso
    Exemplos:
      | produto                     |  pagamento |
      | Printed Summer Dress        |  cheque    |