using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Segurança
{
    public class UsuarioLogado
    {
        public Usuario Usuario { get; private set; }

        public String[] Permissoes { get; private set; }

        public UsuarioLogado(String email, string[] permissoes)
        {
            this.Usuario.Email = email;
            this.Permissoes = permissoes;
        }
    }
}