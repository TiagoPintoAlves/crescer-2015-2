﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using System.Xml.Serialization;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {
        const string CaminhoXML = @"C:\Users\vicente\Documents\Github-fork-crescer\src\modulo-04-c-sharp\dia-05\Locadora\game_store.xml";

        public BaseDeDados()
        {

        }

        public void CadastrarJogo(Jogo jogo)
        {
            XElement jogoXML = XElement.Load(CaminhoXML);
            int LastId = Convert.ToInt32(jogoXML.Elements("jogo").Last().Attribute("id").Value) + 1;

            XElement xmlDoCadastro = new XElement("jogo",
                new XElement("nome", jogo.Nome),
                new XElement("preco", jogo.Preco),
                new XElement("categoria", jogo.Categoria));

            xmlDoCadastro.SetAttributeValue("id", LastId);
            jogoXML.Add(xmlDoCadastro);
            jogoXML.Save(CaminhoXML);
        }

        public List<Jogo> PesquisarPorNome(string nome)
        {
            XElement XMLjogos = XElement.Load(CaminhoXML);

            IEnumerable<XElement> resultado = XMLjogos.Elements("jogo").Where(jogo => jogo.Element("nome").Value.Contains(nome)).ToList();
            List<Jogo> jogos = new List<Jogo>();
            foreach (var jogo in resultado)
            {
                jogos.Add(XMLToJogo(jogo));
            }
            return jogos;
        }

        public int TotalJogos()
        {
            XElement XMLjogos = XElement.Load(CaminhoXML);
            int total = Convert.ToInt32(XMLjogos.Elements("jogo").Count());
            return total;
        }

        public Jogo XMLToJogo(XElement elemXML)
        {
            var jogo = new Jogo(elemXML.Element("nome").Value,
                    double.Parse(elemXML.Element("preco").Value, System.Globalization.CultureInfo.InvariantCulture),
                    (Categoria) Enum.Parse(typeof(Categoria), elemXML.Element("categoria").Value));
            return jogo;
        }

        public void EditarNomeJogo(string atualNome, string novoNome)
        {
            XElement jogoXML = XElement.Load(CaminhoXML);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == atualNome);
            jogoEscolhido.Element("nome").SetValue(novoNome);
            jogoXML.Save(CaminhoXML);
        }

        public void EditarPrecoJogo(string atualNome, double novoPreco)
        {
            XElement jogoXML = XElement.Load(CaminhoXML);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == atualNome);
            jogoEscolhido.Element("preco").SetValue(novoPreco);
            jogoXML.Save(CaminhoXML);
        }

        public void EditarCategoriaJogo(string atualNome, string novaCategoria)
        {
            XElement jogoXML = XElement.Load(CaminhoXML);
            var jogoEscolhido = jogoXML.Elements("jogo").FirstOrDefault(jogo => jogo.Element("nome").Value == atualNome);
            jogoEscolhido.Element("categoria").SetValue(novaCategoria.ToString());
            jogoXML.Save(CaminhoXML);
        }

        public XElement ToXElement(Jogo j)
        {
            XElement jogo = new XElement("Jogo");
            jogo.SetAttributeValue("id", j.Id);
            XElement nome = new XElement("Nome", j.Nome);
            XElement preco = new XElement("Preco", j.Preco);
            XElement categoria = new XElement("Categoria", j.Categoria.ToString());
            XElement disponibilidade = new XElement("Disponibilidade", j.Disponibilidade);
            jogo.Add(nome);
            jogo.Add(preco);
            jogo.Add(categoria);
            jogo.Add(disponibilidade);
            return jogo;
        }

        public void gerarRelatorio()
        {
            XElement arquivoXML = XElement.Load(CaminhoXML);
            List<Jogo> listaDeJogos = new List<Jogo>();
            foreach (XElement jogo in arquivoXML.Elements("jogo"))
            {
                listaDeJogos.Add(XMLToJogo(jogo));
            }
            double valorTotal = 0;
            StringBuilder lista = new StringBuilder();
            foreach (var jogo in listaDeJogos)
            {
                valorTotal += jogo.Preco;
                lista.Append(jogo.Id.ToString().PadRight(10));
                lista.Append(jogo.Categoria.ToString().PadRight(10));
                lista.Append(jogo.Nome.PadRight(45));
                lista.Append(jogo.Preco.ToString().PadRight(10) + "\r\n");
            }
            int totalDeJogos = listaDeJogos.Count;
            double valorMedio = valorTotal / totalDeJogos;
            double maiorPreco = listaDeJogos.Max(jogo => jogo.Preco);
            double menorPreco = listaDeJogos.Min(jogo => jogo.Preco);
            string maisCaro = listaDeJogos.First(jogo => jogo.Preco == maiorPreco).Nome;
            string maisBarato = listaDeJogos.First(jogo => jogo.Preco == menorPreco).Nome;
            string data = DateTime.Now.Date.ToString("dd/MM/yyyy");
            string hora = DateTime.Now.ToLongTimeString();
            string caminhoTXT = @"C:\Users\vicente\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\Locadora\extrato.txt";
            string nomeLocadora = "LOCADORA NUNES GAMES";
            string nomeRelatorio = "Relatorio de Jogos";
            using (StreamWriter writer = new StreamWriter(caminhoTXT))
            {
                writer.WriteLine(nomeLocadora.PadLeft(40));
                writer.WriteLine(data.PadRight(30) + hora.PadLeft(30));
                writer.WriteLine(nomeRelatorio.PadLeft(40));
                writer.WriteLine("");
                writer.WriteLine("==========================================================================");
                writer.WriteLine("ID".PadRight(10) + "Categoria".PadRight(10) + "Nome".PadRight(45) + "Preco".PadRight(10));
                writer.WriteLine(lista);
                writer.WriteLine("--------------------------------------------------------------------------");
                writer.WriteLine("Quantidade total de jogos: " + totalDeJogos);
                writer.WriteLine("Quantidade de jogos disponiveis: ");
                writer.WriteLine("Valor medio por jogo: " + valorMedio);
                writer.WriteLine("Jogo mais caro: " + maisCaro);
                writer.WriteLine("Jogo mais barato: " + maisBarato);
                writer.WriteLine("==========================================================================");
            }

        }

    }
}
