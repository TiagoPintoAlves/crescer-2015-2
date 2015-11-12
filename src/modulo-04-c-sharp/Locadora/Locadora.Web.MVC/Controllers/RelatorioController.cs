using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.ADO;
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
        private IJogoRepositorio JogosRepositorio = new Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            RelatorioModel model = new RelatorioModel();

            try
            {
                bool verificarNome = string.IsNullOrEmpty(nome);
                var resultado = (verificarNome)? JogosRepositorio.BuscarTodos() : JogosRepositorio.BuscarPorNome(nome);

                foreach (var jogo in resultado)
                {
                    JogoModel jogoModels = new JogoModel(jogo.Nome, jogo.Categoria.ToString(), jogo.Selo.ToString())
                                                        { Id = jogo.Id };
                    
                    model.Jogos.Add(jogoModels);
                }

                model.QuantidadeTotal = model.Jogos.Count;
                return View(model);
            }
            catch
            {
                TempData["Mensagem"] = "Nenhum jogo Encontrado";
                return View();
            }
        }

        public JsonResult JogosAutocomplete(string term)
        {
            IList<Jogo> jogosEncontrados = null;

            if (string.IsNullOrEmpty(term))
            {
                jogosEncontrados = JogosRepositorio.BuscarTodos();
            }
            else
            {
                jogosEncontrados = JogosRepositorio.BuscarPorNome(term);
            }

            var json = jogosEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }

    }
}