using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Segurança;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginModel loginModel)
        {

            ServicoAutenticacao servicoAutenticacao = new ServicoAutenticacao();

            Usuario user = servicoAutenticacao.BuscarPorAutenticacao(loginModel.Email, loginModel.Senha);

            if (user != null)
            {
                var permissoes = user.Permissoes;

                var usuarioLogado = new UsuarioLogado(user.Email, new string[] { "ADMIN" });
                
                FormsAuthentication.SetAuthCookie(loginModel.Email, true);

                Session["USUARIO_LOGADO"] = usuarioLogado;

                return RedirectToAction("Index", "Home");
            }
            
            ModelState.AddModelError("INVALID", "Usuário ou senha inválidos.");
            return View("Index", loginModel);

        }
    }
}