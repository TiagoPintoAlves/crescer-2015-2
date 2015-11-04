using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            const int CADASTRAR = 1;
            const int EDITARNome = 2;
            const int EDITARPreco = 3;
            const int EDITARCategoria = 4;
            const int PESQUISAR = 5;
            const int EXPORTAR_RELATORIO = 6;

            var baseDeDados = new BaseDeDados();
            int reiniciar = 1;
            do{
                Console.Clear();
                Console.WriteLine("Digite uma opção");
                Console.WriteLine("1- Cadastrar Jogo \n 2- Editar Nome \n 3- Editar Preco \n 4- Editar Categoria \n 5- Pesquisar por nome \n 6- Imprimir Relatorio");
                int menu = int.Parse(Console.ReadLine());

                switch (menu)
                {
                    case CADASTRAR:
                        Console.WriteLine("Digite o Nome do jogo a ser adicionado");
                        var nome = Console.ReadLine();
                        Console.WriteLine("Digite o preço do jogo a ser adicionado");
                        double preco;
                        try
                        {
                            preco = Convert.ToDouble(Console.ReadLine(), System.Globalization.CultureInfo.InvariantCulture);
                        }
                        catch
                        {
                            Console.WriteLine("O campo preço aceita somente numeros");
                            return;
                        }

                        Console.WriteLine("Digite a categoria do jogo");
                        Categoria categoria;
                        try
                        {
                            categoria = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine().ToUpper());
                        }
                        catch
                        {
                            Console.WriteLine("A categoria digitada não existe");
                            return;
                        }

                        var jogo = new Jogo(nome, preco, categoria);
                        baseDeDados.CadastrarJogo(jogo);
                        break;
                    case EDITARNome:
                        Console.WriteLine("Digite o nome do jogo:");
                                    var antigoNome = Console.ReadLine();
                                    List<Jogo> jogosComNomeProcurado = baseDeDados.PesquisarPorNome(antigoNome);
                                    if (jogosComNomeProcurado.Count() >= 1) {
                                        Console.WriteLine("Digite o novo nome para este jogo:");
                                        var novoNome = Console.ReadLine();
                                        baseDeDados.EditarNomeJogo(antigoNome, novoNome);
                                    }
                                    else
                                    {
                                        Console.WriteLine("Jogo não existente");
                                    }
                        break;
                    case EDITARPreco:
                        //baseDeDados.EditarPrecoJogo();
                        break;
                    case EDITARCategoria:
                        //baseDeDados.EditarCategoriaJogo();
                        break;
                    case PESQUISAR:
                        //baseDeDados.PesquisarPorNome();
                        break;
                    case EXPORTAR_RELATORIO:
                        baseDeDados.gerarRelatorio();
                        break;
                    default:
                        Console.WriteLine("Escolha inválida");
                        break;
                }

                Console.WriteLine("Fazer outra operação");
                Console.WriteLine("1- Sim \n2- Nao");
                try
                {
                    reiniciar = int.Parse(Console.ReadLine());
                    
                }
                catch
                {
                    Console.WriteLine("Escolha inválida");
                    reiniciar = 0;
                }

                Console.Clear();
            } while (reiniciar == 1);

          
        }
    }
}
