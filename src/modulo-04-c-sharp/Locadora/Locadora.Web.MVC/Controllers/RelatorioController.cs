using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        public RelatorioModel model = new RelatorioModel();

        public ActionResult JogosDisponiveis()
        {
            List<Jogo> jogos = new List<Jogo>();

            foreach (var jogo in model.Jogos)
            {
                //model.Add(jogo.Nome, jogo.Preco, jogo.Categoria.ToString());
            }

            return View(model);
        }
    }
}