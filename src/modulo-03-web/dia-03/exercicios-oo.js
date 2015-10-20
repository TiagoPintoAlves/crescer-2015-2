//Exercicio 1
function Item(sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;

}

function CarrinhoDeCompras(Item){
  this.Item = [Item];
}

CarrinhoDeCompras.prototype.addItem = function (nItem) {
  this.Item.push(nItem);
};

CarrinhoDeCompras.prototype.removeItem = function (SKU) {
  
};
