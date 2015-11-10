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

        public ActionResult Login(UsuarioLogado login, string senha)
        {

            if (login.Usuario.Email == "test@test.com" && senha == "test")
            {
                var usuarioLogadoModel = new UsuarioLogado("test@test.com", new string[] { "MASTER" });

                FormsAuthentication.SetAuthCookie(login.Usuario.Email, true);

                Session["USUARIO_LOGADO"] = usuarioLogadoModel;

                return RedirectToAction("Index", "Home");
            }
            else{

                ModelState.AddModelError("INVALID", "Erro");
                return View("Index", "Login");
            }
            
        }
    }
}