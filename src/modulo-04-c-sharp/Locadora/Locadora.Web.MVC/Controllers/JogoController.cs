using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        private IJogoRepositorio JogosRepositorio = new Repositorio.ADO.JogoRepositorio();
 
        public ActionResult DetalheJogo(int id)
        {
            var jogo = JogosRepositorio.BuscarPorId(id);

            var model = new JogoFullPropModel(jogo.Nome, 
                                              jogo.Preco, 
                                              jogo.Categoria.ToString(),
                                              jogo.Descricao,
                                              jogo.Selo.ToString(),
                                              jogo.Imagem, jogo.Video) 
                                              { id = jogo.Id };

            return View(model);
        }
    }
}