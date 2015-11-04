using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public double Preco { get; private set; }
        public Categoria Categoria { get; private set; }
        public bool Disponibilidade { get; set; }

        public Jogo(string nome, double preco, Categoria categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
            this.Disponibilidade = true;
        }

        public Jogo(int id, string nome, double preco, Categoria categoria)
        {
            this.Id = id;
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
            this.Disponibilidade = true;
        }
    }
}
