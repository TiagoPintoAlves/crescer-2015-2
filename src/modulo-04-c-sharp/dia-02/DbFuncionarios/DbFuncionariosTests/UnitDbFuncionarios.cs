using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace DbFuncionariosTests
{
    [TestClass]
    public class UnitDbFuncionarios
    {

        [TestMethod]
        public void OrdenadosPorCargo()
        {
            BaseDeDados baseDeDados = new BaseDeDados();

            IList<Funcionario> funcionarios = baseDeDados.Funcionarios;
            IList<Funcionario> funcionariosOrdenados = baseDeDados.OrdenadosPorCargo();
            Assert.AreEqual(11, funcionariosOrdenados.Count);
        }

        [TestMethod]
        public void BuscaPorNome()
        {
            BaseDeDados baseDeDados = new BaseDeDados();
            IList<Funcionario> Esperado = baseDeDados.BuscarPorNome("Lucas Kauer");

            Assert.AreEqual("Lucas Kauer", Esperado[0].ToString());
        }

        [TestMethod]
        public void BuscarPorTurnoManha()
        {
            BaseDeDados baseDeDados = new BaseDeDados();
            TurnoTrabalho turno = TurnoTrabalho.Manha;
            IList<Funcionario> ResultadoBusca = baseDeDados.BuscarPorTurno(turno);

            Assert.AreEqual(5, ResultadoBusca.Count);
        }

        [TestMethod]
        public void AniversarianteDoMes()
        {
            BaseDeDados baseDeDados = new BaseDeDados();
            IList<Funcionario> Esperado = baseDeDados.AniversariantesDoMes();
            Assert.AreEqual(1, Esperado.Count);
        }

        [TestMethod]
        public void BuscarPorCargo()
        {
            BaseDeDados baseDeDados = new BaseDeDados();
            Cargo desenvolvedor = new Cargo("Desenvolvedor", 0.0);

            IList<Funcionario> Esperado = baseDeDados.BuscarPorCargo(desenvolvedor);

            Assert.AreEqual(8, Esperado.Count);
        }

        [TestMethod]
        public void FiltraPorIdade40anos()
        {
            BaseDeDados baseDeDados = new BaseDeDados();
            IList<Funcionario> Esperado = baseDeDados.FiltrarPorIdadeAproximada(40);
            Assert.AreEqual(1, Esperado.Count);
        }

    }
}
