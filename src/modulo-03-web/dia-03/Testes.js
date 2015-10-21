// Testes para as Classes.

// Adiciona Item por parametro
var carrinho1 = new CarrinhoDeCompras([
  new Item({
    sku: 'sku-item-inline',
    descricao: 'chocolate 1000k',
    quantidade: 15,
    valorUnitario: 22.00
  })
]);

// Adiciona no carrinho1
var carrinho2 = new CarrinhoDeCompras();
carrinho1.addItem(new Item({
  sku: 'novo-sku',
  descricao: 'chocolate 1000k',
  quantidade: 15,
  valorUnitario: 22.00
}));

// Testes para CarrinhoDeComprasChantagista
var carrinho3 = new CarrinhoDeComprasChantagista([new Item({
    sku: 'sku-item',
    descricao: 'chocolate 1000k',
    quantidade: 15,
    valorUnitario: 22.00
  })
]);
