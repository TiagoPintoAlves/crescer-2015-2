
//Exercicio 1.A
function byname(time_a, time_b) {
    return time_a.nome < time_b.nome;
}

function filterByQtd(Array){
  var maior = 0;
  if(Array.titulos[0].qtd > maior){
    maior = Array.titulos[0].qtd;
  }
  return maior;
}

function ordenaPorNacionais(Array){
  return Array.filter(filterByQtd).sort(byname);
}
