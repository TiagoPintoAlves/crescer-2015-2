//Exercicio 1
function CarrinhoDeCompras(Item){
  this.Itens = [Item];
}

CarrinhoDeCompras.prototype.addItem = function (nItem) {
  this.Itens.push(nItem);
};

CarrinhoDeCompras.prototype.removeItem = function (SKU) {
  this.Itens.forEach(function(elem, index, array){
      array.splice(array.indexOf(SKU, 0), 1);
  })
};
