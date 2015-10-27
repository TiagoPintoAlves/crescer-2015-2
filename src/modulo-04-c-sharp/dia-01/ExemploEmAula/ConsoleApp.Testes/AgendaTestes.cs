using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato("Júlio César", 977454545);

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaRemoveDoisContatosPorNumero()
        {
          var agenda = new Agenda();
          var contato1 = new Contato("Júlio César", 977454545);
          var contato2 = new Contato("Ben Hur", 666);
          var contato3 = new Contato("Fabricio", 666);
          agenda.AdicionarContato(contato1);
          agenda.AdicionarContato(contato2);
          agenda.AdicionarContato(contato3);

          agenda.RemoverContatosPorNumero(666);

          Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaRemoveDoisContatosPorNome()
        {
          var agenda = new Agenda();
          var contato1 = new Contato("Júlio César", 977454545);
          var contato2 = new Contato("Fabricio", 666);
          var contato3 = new Contato("Fabricio", 1515515);
          agenda.AdicionarContato(contato1);
          agenda.AdicionarContato(contato2);
          agenda.AdicionarContato(contato3);

          agenda.RemoverContatosPorNome("Fabricio");

          Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaListarTodosContatos()
        {
          var agenda = new Agenda();
          var contato1 = new Contato("Júlio César", 977454545);
          var contato2 = new Contato("Ben Hur", 666);
          var contato3 = new Contato("Fabricio", 1515515);
          agenda.AdicionarContato(contato1);
          agenda.AdicionarContato(contato2);
          agenda.AdicionarContato(contato3);

          agenda.ListarContatos();

          Assert.AreEqual(agenda.QuantidadeContatos, 3);
        }
    }
}
