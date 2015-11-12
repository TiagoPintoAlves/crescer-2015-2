using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public string Selo { get; set; }

        public JogoModel(string nome, string categoria, string selo)
        {
            Nome = nome;
            Categoria = categoria;
            Selo = selo;
        }
    }
}