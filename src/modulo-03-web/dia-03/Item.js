function Item(options){
  options = options || {};
  options.sku = sku;
  options.descricao = descricao;
  options.quantidade = quantidade || 0;
  options.valorUnitario = valorUnitario;
};

Item.prototype.calcularSubTotal = function () {
  return this.quantidade * this.valorUnitario;
};
