using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoFullPropModel : RelatorioModel
    {
        public int id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public string Categoria { get; set; }
        public string Descricao { get; set; }
        public string Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }

        public JogoFullPropModel(string nome, decimal preco, string categoria, string descricao, string selo, string imagem, string video)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
            this.Descricao = descricao;
            this.Selo = selo;
            this.Imagem = (imagem == null)? "/Content/imagem/img_not_found.gif" : imagem;
            this.Video = video;
        }
    }
}