function CarrinhoDeCompras(){
  this.Itens = [];
};

CarrinhoDeCompras.prototype.addItem = function (nItem) {
  this.Itens.push(nItem);
};

CarrinhoDeCompras.prototype.removeItem = function (sku) {
  for (var i = 0, len = this.Itens.length ; i < len; i++) {
    if(this.Itens[i].sku == sku){
      this.Itens.splice(i, 1);
    }
  }
};

CarrinhoDeCompras.prototype.atualizarQuantidade = function (sku, novaQuantia) {
  for (var i = 0, len = this.Itens.length ; i < len; i++) {
    if(this.Itens[i].sku == sku){
      this.Itens.filter(function(elem){
        return elem.quantidade = novaQuantia;
      }).splice(i, 1, novaQuantia);
    }
  }
};

CarrinhoDeCompras.prototype.valorTotal = function () {
    var somaSubTotal = this.Itens.map(function(elem){
      return elem.calcularSubTotal();
    }).reduce(function(acumulador, elem){
      return acumulador + elem;
    });
  return somaSubTotal * (this.sortearDesconto()? 0.9:1);
};

CarrinhoDeCompras.prototype.sortearDesconto = function () {
  return Math.random() < 0.4;
};

CarrinhoDeCompras.prototype.forcarCompra = function () {
  if(!this.intervalo){
    this.intervalo = setInterval(function(){
      this.Itens.forEach(function(elem){
        elem.valorUnitario += elem.valorUnitario * 0.1;
      });
    }, 5000);
  }
};

CarrinhoDeCompras.prototype.concluirPedido = function () {
  clearInterval(this.intervalo);
  delete this.intervalo;
};
