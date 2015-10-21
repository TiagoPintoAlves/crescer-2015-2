function CarrinhoDeCompras(Item){
  this.Itens = [Item];
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
