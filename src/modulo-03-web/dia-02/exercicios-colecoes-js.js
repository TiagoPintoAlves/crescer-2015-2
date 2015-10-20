var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];


//Exercicio 1.A
function ordenaPorNacionais(Array){
  return Array.sort(function(x,y) {
    return x.titulos[0].qtd < y.titulos[0].qtd;
  });
};

//Exercicio 1.B
function ordenaPorContinentais(Array){
  return Array.sort(function(x,y) {
    return x.titulos[1].qtd < y.titulos[1].qtd;
  });
};

//Exercicio 1.C
function ordenaPorMundiais(Array){
  return Array.sort(function(x,y) {
    return x.titulos[2].qtd < y.titulos[2].qtd;
  });
};


//Exercicio2 Somatório de titulos
//Exercicio 2.A
function somaPorTitulos(index, clubes){
  return clubes.reduce(function(acumulador, elemAtual){
    return acumulador + elemAtual.titulos[index].qtd;
  }, 0);
}

function somarPorNacionais(clubes){
  return somaPorTitulos(0, clubes);
}


//Exercicio 2.B
function somarPorContinentais(clubes){
  return somaPorTitulos(1, clubes);
}

//Exercicio 2.C
function somarPorTodosTitulos(clubes){
  return somaPorTitulos(0, clubes) + somaPorTitulos(1, clubes) + somaPorTitulos(2, clubes) + somaPorTitulos(3, clubes);
}

//Exercicio 3
function apenasOsMelhores(clubes){
  return clubes.filter(function(elem, index){
    return elem.titulos[0].qtd > 18;
  })
}

// adicionando map
var time = clubes.map(function(clube){
  return clube.nome += ' FC', clube;
});

//Exercicio 4
function calcularIdadeMedia(clubes){
  var soma = clubes
  .map(function(elem){
    return new Date().getFullYear() - elem.fundacao.getFullYear();
  })
  .reduce(function(acumulador, elem){
    return acumulador + elem;
  }, 0)
    return soma / clubes.length;
};
