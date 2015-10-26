using System;
using System.Collections.Generic;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();        

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if (contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContato(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void ListarContatos()
        {
            foreach (var contato in contatos)
            {
                Console.WriteLine(contato.Nome + "-" + contato.Numero);
            }
        }

        public List<Contato> ListarContatosOrdenadoPorNome()
        {
            List<Contato> ordenar = this.contatos.OrderBy(x => x.);
            return
        }

        public void RemoverContatoPorNumero(int numero)
        {
            var listaContatosRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numero)
                    listaContatosRemovidos.Add(contatos[i]);
            }

            foreach (var contato in listaContatosRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatosPorNome(string nome)
        {
            var ListaNomesRemovido = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nome)
                {
                    ListaNomesRemovido.Add(contatos[i]);
                }
            }
        }
    }
}
