using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;
using System.Collections;

namespace LocadoraTests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void CadastrandoJogoComSucesso()
        {
            var baseDeDados = new BaseDeDados();
            var jogo = new Jogo("Adventure Time", 1, Categoria.AVENTURA);
            baseDeDados.CadastrarJogo(jogo);
            Assert.IsTrue(jogo.Equals(jogo));
        }

        [TestMethod]
        public void PesquisarJogoAdicionadoPorNome()
        {
            var baseDeDados = new BaseDeDados();
            var jogo = new Jogo("Yu-Gi-Oh", 5, Categoria.RPG);
            baseDeDados.CadastrarJogo(jogo);
            var query = baseDeDados.PesquisarPorNome("Yu-Gi-Oh");
            Assert.AreEqual(jogo.Nome, query[0].Nome);
        }
    }
}
