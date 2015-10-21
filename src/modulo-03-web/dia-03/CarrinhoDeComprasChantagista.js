CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

function CarrinhoDeComprasChantagista(Itens){
  CarrinhoDeCompras.call(this, arguments);
}

CarrinhoDeComprasChantagista.prototype.forcarCompra = function() {
  CarrinhoDeCompras.prototype.forcarCompra.apply(this, arguments);
}

CarrinhoDeComprasChantagista.prototype.concluirPedido = function () {
  CarrinhoDeCompras.prototype.concluirPedido.apply(this, arguments);
};
