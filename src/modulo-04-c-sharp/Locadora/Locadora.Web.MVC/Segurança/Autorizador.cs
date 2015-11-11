using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Locadora.Web.MVC.Segurança
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            if (AuthorizeCore(filterContext.HttpContext))
            {
                UsuarioLogado usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioLogado;

                if(usuarioLogado == null)
                {
                    filterContext.Result = new RedirectToRouteResult(new RouteValueDictionary{
                                                                    { "action", "Index"},
                                                                    { "controller", "Login"}
                                                                    });
                }
                else
                {
                    var identidade = new GenericIdentity(usuarioLogado.Email);
                    var principal = new GenericPrincipal(identidade, usuarioLogado.Permissoes);

                    Thread.CurrentPrincipal = principal;
                    HttpContext.Current.User = principal;

                    base.OnAuthorization(filterContext);
                }
            
            }
            
        }
    }
}