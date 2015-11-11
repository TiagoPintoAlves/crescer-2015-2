using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoAutenticacao
    {
        private IUsuarioRepositorio usuarioRepositorio;

        public ServicoAutenticacao()
        {

        }

        public ServicoAutenticacao(IUsuarioRepositorio usuarioRepositorio)
        {
            this.usuarioRepositorio = usuarioRepositorio;
        }

        public Usuario BuscarPorAutenticacao(string email, string senha)
        {
            Usuario usuario = this.usuarioRepositorio.BuscarPorEmail(email);

            return usuario;
            }
    }
}
