using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca
{
    public class Autorizador : AuthorizeAttribute
    {
        // este método é responsável por dizer se o usuário está autenticado e autorizado
        // a acessar a action.
        // Se ele estiver apto, deve retonar true, caso contrário, false.
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogado usuario = ControleDeSessao.UsuarioLogado;
            return usuario != null
                    && TemOCookieDeAutenticacao(httpContext)
                    && TemAsPermissoesRequeridas(usuario);
        }

        // Este método é executado quando o usuário não tem autenticação ou autorização
        // para acessar a action que ele quer.
        protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
        {
            // aqui estamos dizendo que ele deve ser redirecionado para a controller
            // Home e action Index.
            filterContext.Result = new RedirectToRouteResult(
                                                new RouteValueDictionary
                                                {
                                                    { "action", "Index" },
                                                    { "controller", "Home" }
                                                });
        }

        // neste método nós verificamos as permissões do usuário logado.
        // vemos aqui se ele tem as mesmas que a declarada no atributo.
        private bool TemAsPermissoesRequeridas(UsuarioLogado usuarioLogado)
        {
            // caso esta action precise de roles específicas, vamos pegar elas.
            string[] permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                                new string[0] : this.Roles.Split(';');

            foreach (string permissao in permissoesRequeridas)
            {
                if (!usuarioLogado.Permissoes.Contains(permissao))
                {
                    return false;
                }
            }

            return true;
        }

        // este método verifica se existe o cookie de autenticação.
        private bool TemOCookieDeAutenticacao(HttpContextBase httpContext)
        {
            return FormsAuthentication.CookiesSupported
                && httpContext.Request.Cookies != null
                && httpContext.Request.Cookies[FormsAuthentication.FormsCookieName] != null;
        }
    }
}