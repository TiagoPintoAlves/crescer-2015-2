using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class ClienteController : Controller
    {
        //Só pra teste! Não façam uma coisa dessas!
        List<JogoDisponivelModel> exemploDeLista = new List<JogoDisponivelModel>
        {
            //new JogoDisponivelModel(new Dominio.Jogo(1) { Nome = "Mario" }),
            //new JogoDisponivelModel(new Dominio.Jogo(2) { Nome = "Mario 2" })

        };

        [HttpGet]
        public ActionResult Index()
        {
            var model = new ClienteIndexModel();

            UsuarioLogado usuarioLogado = ControleDeSessao.UsuarioLogado;
            model.PodeCadastrar = usuarioLogado.TemPermissao(Permissao.ADMIN);
            return View(model);
        }

        [HttpGet]
        [Autorizador(Roles = Permissao.ADMIN)]
        public ActionResult Manter(int? id)
        {            
            ViewBag.ListaJogos = new SelectList(exemploDeLista, "IdJogo", "Nome");
            //OU:
            //ViewBag.ListaJogos = exemploDeLista.Select(x => new SelectListItem() { Value = x.IdJogo.ToString(), Text = x.Nome });

            if (id.HasValue)
            {
                //Busca cliente do banco
                var model = new ClienteModel()
                {
                    Id = 5,
                    Nome = "Didi must die",
                    Email = "didi@didi.com",
                    EmailConfimacao = "didi@didi.com",
                    Idade = 80
                };

                return View(model);
            }
            else
            {
                return View();
            }
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ClienteModel model)
        {
            //ModelState.AddModelError("Nome", "Nome já existe no banco de dados!");
            //ModelState.AddModelError("", "Tem coisa errada aí...");

            if (ModelState.IsValid)
            {
                //salvar no banco
                TempData["Mensagem"] = "Cliente salvo com sucesso!";

                return RedirectToAction("Index", "Cliente");
            }
            else
            {
                //Exemplo de modificação dos dados da model antes de retornar!
                //ModelState.SetModelValue("Nome", new ValueProviderResult("Bob Esponja", "", CultureInfo.InvariantCulture));

                ViewBag.ListaJogos = new SelectList(exemploDeLista, "IdJogo", "Nome");

                return View("Manter", model);
            }
        }
    }
}