using System;
using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp
{
    public class Agenda
    {
        public List<Contato> contatos;
        public int QuantidadeContatos { get { return contatos.Count; } }

        public Agenda(){
          contatos = new List<Contato>();
        }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if(contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContatosPorNome(string nomeContato)
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

        public void RemoverContatosPorNumero(int numeroContato)
        {
            var listaNumerosRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                    listaNumerosRemovidos.Add(contatos[i]);
            }

            foreach (var contato in listaNumerosRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public List<Contato> ListarContatos()
        {
            return contatos;
        }

        public List<Contato> ListarContatosOrdenadoPorNome()
        {
            var ListaOrdenada = contatos.OrderBy(contato => contato.Nome).ToList();
            return ListaOrdenada;
        }
    }
}
