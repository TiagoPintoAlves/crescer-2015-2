using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> Jogos { get; set; }

        public int QuantidadeTotal { get; set; }

        public RelatorioModel()
        {
            Jogos = new List<JogoModel>();
        }
    }

    public class JogoPropriedadeModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public Categoria Categoria { get; set; }
        public string Descricao { get; set; }
        public Selo Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }

        public JogoPropriedadeModel(Jogo jogo)
        {
            this.Nome = jogo.Nome;
            this.Descricao = jogo.Descricao;
            this.Categoria = jogo.Categoria;
            this.Selo = jogo.Selo;
            this.Imagem = (string.IsNullOrEmpty(jogo.Imagem) ? "~/Content/imagem/img_not_found.gif" : jogo.Imagem);
            this.Video = jogo.Video;
        }

    }
}

