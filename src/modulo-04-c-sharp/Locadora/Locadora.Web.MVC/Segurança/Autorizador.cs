using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Segurança
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioLogado usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioLogado;
            if (AuthorizeCore(filterContext.HttpContext))
            {
                GenericIdentity myIdent = new GenericIdentity(usuarioLogado.Usuario.Email);
                GenericPrincipal principal = new GenericPrincipal(myIdent, new string[] { "ADMIN" });

                Thread.CurrentPrincipal = principal;
                HttpContext.Current.User = principal;

                base.OnAuthorization(filterContext);
            }
            
        }
    }
}