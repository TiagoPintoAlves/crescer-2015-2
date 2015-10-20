
//Exercicio 1.A
function byname(time_a, time_b) {
    return time_a.nome < time_b.nome;
}

function filterByQtd(club){
  var maior = 0;
  if(club.titulos[0].qtd > maior){
    maior = club.titulos[0].qtd;
  }
  return maior;
}

function ordenaPorNacionais(Array){
  return Array.filter(filterByQtd).sort(byname);
}
