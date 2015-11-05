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
        public ActionResult JogosDisponiveis()
        {
            RelatorioModel model = new RelatorioModel();

            IJogoRepositorio JogosRepositorio = new Repositorio.ADO.JogoRepositorio();
            List<Jogo> BaseDeJogos = JogosRepositorio.BuscarTodos().ToList();

            decimal somatorio = 0;

            foreach (var jogo in BaseDeJogos)
            {
                JogoModel jogoModels = new JogoModel();
                jogoModels.Nome = jogo.Nome;
                jogoModels.Preco = jogo.Preco;
                jogoModels.Categoria = jogo.Categoria.ToString();

                somatorio += jogo.Preco;
                model.Jogos.Add(jogoModels);
            }

            model.QuantidadeTotal = model.Jogos.Count;
            model.ValorMedioJogos = somatorio / model.QuantidadeTotal;

            model.JogoMaisCaro = model.Jogos.FirstOrDefault(jogo => jogo.Preco == model.Jogos.Max(j => j.Preco)).Nome;
            model.JogoMaisBarato = model.Jogos.FirstOrDefault(jogo => jogo.Preco == model.Jogos.Min(j => j.Preco)).Nome;

            return View(model);
        }
    }
}