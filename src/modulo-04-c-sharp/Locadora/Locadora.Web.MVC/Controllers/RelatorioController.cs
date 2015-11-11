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
        private IJogoRepositorio JogosRepositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            RelatorioModel model = new RelatorioModel();

            try
            {
                bool verificarNome = string.IsNullOrEmpty(nome);
                var resultado = (verificarNome)? JogosRepositorio.BuscarTodos() : JogosRepositorio.BuscarPorNome(nome);

                decimal somatorio = 0;

                foreach (var jogo in resultado)
                {
                    JogoModel jogoModels = new JogoModel(jogo.Nome, jogo.Preco, jogo.Categoria.ToString()) { Id = jogo.Id };

                    somatorio += jogo.Preco;
                    model.Jogos.Add(jogoModels);
                }

                model.QuantidadeTotal = model.Jogos.Count;
                model.ValorMedioJogos = somatorio / model.QuantidadeTotal;

                model.JogoMaisCaro = model.Jogos.FirstOrDefault(jogo => jogo.Preco == model.Jogos.Max(j => j.Preco)).Nome;
                model.JogoMaisBarato = model.Jogos.FirstOrDefault(jogo => jogo.Preco == model.Jogos.Min(j => j.Preco)).Nome;

                return View(model);
            }
            catch
            {
                TempData["Mensagem"] = "Nenhum jogo Encontrado";
                return View();
            }
            
        }
    }
}