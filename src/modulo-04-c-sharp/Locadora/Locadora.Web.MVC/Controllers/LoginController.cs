using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
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
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(UsuarioLogado login, string senha)
        {

            ServicoAutenticacao servicoAutenticacao = new ServicoAutenticacao();

            Usuario user = servicoAutenticacao.BuscarPorAutenticacao(login.Email, senha);

            if (user != null)
            {
                var permissoes = user.Permissoes;

                var usuarioLogado = new UsuarioLogado(user.Email, new string[] { "ADMIN" });
                
                FormsAuthentication.SetAuthCookie(login.Email, true);

                Session["USUARIO_LOGADO"] = usuarioLogado;

                return RedirectToAction("Index", "Home");
            }
            
            ModelState.AddModelError("INVALID", "Usuário ou senha inválidos.");
            return View("Index", "Login");

        }
    }
}