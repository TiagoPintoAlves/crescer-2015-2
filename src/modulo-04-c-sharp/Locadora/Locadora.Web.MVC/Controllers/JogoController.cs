﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Dominio;
using Locadora.Web.MVC.Segurança;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class JogoController : Controller
    {
        private IJogoRepositorio JogoRepositorio = new Repositorio.EF.JogoRepositorio();
 
        public ActionResult DetalheJogo(int id)
        {
            var jogo = JogoRepositorio.BuscarPorId(id);
            var model = new JogoPropriedadeModel(jogo) { Id = jogo.Id };

            return View(model);
        }

        [HttpGet]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var jogo = JogoRepositorio.BuscarPorId((int)id);
                var model = new JogoPropriedadeModel(jogo);

                return View(model);
            }
            else
            {
                return View();
            }

        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ManterModel model)
        {
            if (ModelState.IsValid)
            {
                var jogo = ManterModelParaJogo(model);

                if (jogo.Id == 0)
                {
                    JogoRepositorio.Criar(jogo);
                }
                else
                {
                    JogoRepositorio.Atualizar(jogo);
                }
                TempData["Mensagem"] = "Jogo salvo com sucesso!";

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                TempData["Mensagem"] = "O Jogo não é valido";
                return View("Manter", model);
            }
        }

        private ManterModel JogoParaManterModel(Jogo jogo)
        {
            return new ManterModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Preco = jogo.Preco,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo,
                Imagem = jogo.Imagem,
                Video = jogo.Video,
                Categoria = jogo.Categoria,
            };
        }

        private Jogo ManterModelParaJogo(ManterModel model)
        {
            Jogo jogo = (model.Id.HasValue) ? new Jogo((int)model.Id) : new Jogo();

            jogo.Nome = model.Nome;
            jogo.Categoria = model.Categoria;
            jogo.Preco = model.Preco;
            jogo.Descricao = model.Descricao;
            jogo.Selo = model.Selo;
            jogo.Imagem = model.Imagem;
            jogo.Video = model.Video;

            return jogo;
        }
    }
}