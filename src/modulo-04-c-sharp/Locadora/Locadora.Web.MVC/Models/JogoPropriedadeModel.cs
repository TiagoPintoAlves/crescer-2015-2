﻿using Locadora.Dominio;
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
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public Categoria Categoria { get; set; }
        public string Descricao { get; set; }
        public Selo Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }

        public JogoPropriedadeModel(Jogo jogo)
        {
            Nome = jogo.Nome;
            Preco = jogo.Preco;
            Descricao = jogo.Descricao;
            Categoria = jogo.Categoria;
            Selo = jogo.Selo;
            Imagem = (string.IsNullOrEmpty(jogo.Imagem) ? "~/Content/imagem/img_not_found.gif" : jogo.Imagem);
            Video = jogo.Video;
        }
    }
}