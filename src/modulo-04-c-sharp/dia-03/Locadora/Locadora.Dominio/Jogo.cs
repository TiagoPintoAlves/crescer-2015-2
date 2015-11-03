using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    class Jogo
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public double Preco { get; private set; }
        public string Categoria { get; private set; }
        public bool Disponibilidade { get; set; }

        public Jogo(string nome, double preco, string Categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = Categoria;
        }

        public Jogo(Jogo jogo)
        {
            this.Id = jogo.Id;
            this.Nome = jogo.Nome;
            this.Preco = jogo.Preco;
            this.Categoria = jogo.Categoria;
            this.Disponibilidade = jogo.Disponibilidade;
        }

        public XElement ToXElement()
        {
            XElement jogo = new XElement("Jogo");
            jogo.SetAttributeValue("id", Id);
            XElement nome = new XElement("Nome", this.Nome);
            XElement preco = new XElement("Preco", this.Preco);
            XElement categoria = new XElement("Categoria", this.Categoria.ToString());
            XElement disponibilidade = new XElement("Disponibilidade", this.Disponibilidade);
            jogo.Add(nome);
            jogo.Add(preco);
            jogo.Add(categoria);
            jogo.Add(disponibilidade);
            return jogo;
        }
    }
}
