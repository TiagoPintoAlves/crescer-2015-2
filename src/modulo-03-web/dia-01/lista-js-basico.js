
//Exercicio 1
function daisyGame(numero) {
   if(numero % 2 === 0){
      console.log("Love me not");
  }else if(numero % 2 !== 1){
      console.log("Love me");
  }
}

//Exercicio 2
var array = ["Apple", "Banana", "Orange"];
var maior = 0;
function maiorTexto(array) {
  for (i = 0; i < array.length; i++) {
    if(array[i].length > maior){
      maior = array[i];
    }
    console.log(maior);
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
