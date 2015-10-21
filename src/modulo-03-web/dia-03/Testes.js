// Testes para as Classes.

// Adiciona Item por parametro
var carrinho = new CarrinhoDeCompras([
  new Item({
    sku: 'sku-item-inline',
    descricao: 'chocolate 1000k',
    quantidade: 15,
    valorUnitario: 22.00
  })
]);

// addItem no carrinho1
var carrinho1 = new CarrinhoDeCompras();
carrinho1.addItem(new Item({
  sku: 'novo-sku',
  descricao: 'chocolate 1000k',
  quantidade: 15,
  valorUnitario: 22.00
}));
