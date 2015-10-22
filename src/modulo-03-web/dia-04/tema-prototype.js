String.prototype.palindromo = function(){
  return this.split("").join() === this.split("").reverse().join();
}

Date.prototype.bissexto = function() {
//  if(isBissexto(this.getFullYear())){
    return isBissexto(this.getFullYear())? true : false;
//  }
}

function isBissexto(ano) {
  return new Date(ano, 1, 29).getMonth() == 1;
}
