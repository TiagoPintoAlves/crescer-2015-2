using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Permissao : EntidadeBase
    {
        public const string ADMIN = "ADMIN";
        public const string OPERADOR = "OPERADOR";

        public string Nome { get; set; }

        public ICollection<Usuario> Usuarios { get; set; }

        public Permissao(string nome)
        {
            this.Nome = nome;
        }

    }
}
