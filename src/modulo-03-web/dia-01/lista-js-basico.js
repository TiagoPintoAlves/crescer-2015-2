
//Exercicio 1
function daisyGame(numero) {
   if(numero % 2 === 0){
      return "Love me not";
  }else{
      return "Love me"
  }
}

//Exercicio 2
var array = ["Apple", "Banana", "Orange"];
function maiorTexto(array) {
  var maiortxt = '';
  for (var i = 0; i < array.length; i++) {
    if(array[i].length > maiortxt.length){
      maiortxt = array[i];
    }
    return maiortxt;
  }
}

//Exercicio 3
function imprime(instrutor, funcao){
  try {
   funcao(instrutor);
    for(i = 0; i < instrutor.length; i++){
     console.log('olá querido instrutor:', instrutor[i]);
    }

  } catch (e) {
    console.log("TypeError: number is not a function");
  }
}

//Exercicio 4
function fiboSum(n){
var atual = 0;
var anterior = 1;
var anterior2 = 1;
var soma = 0;
for ( i = 0; i < n; i++) {
  anterior = anterior2;
  anterior2 = atual;
  atual = anterior + anterior2;
  soma += atual;
}
  console.log(soma);
}

//Exercicio 5
function excelis(carac) {
    var soma = 0;
    for (var i = 0; i < carac.length; i++) {
        soma = soma * 26 + carac.charCodeAt(i) - 64;
    }
    return soma;
}
