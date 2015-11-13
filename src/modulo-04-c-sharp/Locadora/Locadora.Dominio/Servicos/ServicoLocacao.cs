using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoLocacao
    {
        public DateTime DataPrevistaEntrega(Selo selo)
        {
            DateTime dataAtual = DateTime.Now;
            switch (selo)
            {
                case Selo.OURO:
                    dataAtual = dataAtual.AddDays(1);
                    break;
                case Selo.PRATA:
                    dataAtual = dataAtual.AddDays(2);
                    break;

                case Selo.BRONZE:
                    dataAtual = dataAtual.AddDays(3);
                    break;
            }
            return dataAtual;
        }
    }
}
