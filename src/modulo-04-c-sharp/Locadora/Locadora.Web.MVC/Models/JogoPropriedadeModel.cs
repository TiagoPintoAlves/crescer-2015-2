using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoPropriedadeModel
    {
        public int? id;

        [Required]
        public string Nome { get; set; }

        [Required]
        public decimal Preco { get; set; }

        [Required]
        public string Categoria { get; set; }

        [Required]
        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        [Required]
        public string Selo { get; set; }

        public string Imagem { get; set; }
        public string Video { get; set; }

        public JogoPropriedadeModel(string nome, decimal preco, string categoria, string descricao, string selo, string imagem, string video)
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