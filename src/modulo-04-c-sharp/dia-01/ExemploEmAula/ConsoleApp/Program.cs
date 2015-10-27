using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
          Agenda agenda = new Agenda();
          int Escolha;

          do{
            Console.WriteLine("Escolha uma operação:\n"+ "1- Adicionar Contato;\n"+"2- Remover Contato Por Numero;\n"+ "3- Remover Contatos Por Nome;\n"+"4- Listar Contatos;\n"+"5- Listar Contatos Ordenado Por Nome;\n"+"6- Limpar Tela e Sair");
            Escolha = Convert.ToInt32(Console.ReadLine());

            switch(Escolha){
              case 1:
                      Console.WriteLine("Digite o nome do contato:");
                      var nome = Console.ReadLine();
                      Console.WriteLine("Digite o numero do contato:");
                      var numero = Convert.ToInt32(Console.ReadLine());
                      agenda.AdicionarContato(new Contato(nome, numero));
                      Console.WriteLine("Contato adicionado");
                    break;
              case 2:
                      Console.WriteLine("Digite o numero do contato:");
                      var numero = Convert.ToInt32(Console.ReadLine());
                      agenda.RemoverContatoPorNumero(numero);
                      Console.WriteLine("Contato Removido");
                    break;
              case 3:
                      Console.WriteLine("Digite o nome do contato:");
                      var Nome = Console.ReadLine();
                      agenda.RemoverContatosPorNome(Nome);
                      Console.WriteLine("Contato Removido");
                    break;
              case 4:
                      Console.WriteLine("Lista de contatos:");
                      agenda.ListarContatos();
                    break;
              case 5:
                      Console.WriteLine("Lista de contatos:");
                      agenda.ListarContatosOrdenadoPorNome();
                    break;
              case 6:
                      Console.clear();
                    break;
            }
          } while(Escolha != 6);
        }
    }
}
