
function CarrinhoDeCompras(Item){
  this.Itens = [Item];
}

CarrinhoDeCompras.prototype.addItem = function (nItem) {
  this.Itens.push(nItem);
};

CarrinhoDeCompras.prototype.removeItem = function (SKU) {
  for (var i = 0, len = this.Itens.length ; i < len; i++) {
    if(this.Itens[i].sku == SKU){
      this.Itens.splice(i,1);
    }
  }
};
