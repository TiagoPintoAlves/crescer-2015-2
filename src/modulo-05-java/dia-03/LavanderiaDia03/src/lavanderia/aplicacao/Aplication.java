package lavanderia.aplicacao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import lavanderia.dao.ClienteDao;
import lavanderia.dao.PedidoDao;
import lavanderia.model.Cliente;
import lavanderia.model.Pedido;

public class Aplication {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		while(continuar == true){
			System.out.println("Escolha uma acao:");
			System.out.println("1-Inserir pedido\n2-Listar pedido por cliente\n3-Buscar pedido");
			int escolha = scanner.nextInt();
			
			switch(escolha){
			case 1:				
				System.out.println("1-Cadastrar novo Cliente \n2-Listar Clientes");
				int definir = scanner.nextInt();
				Long idCliente = 0L;
				if(definir == 1){
					Cliente cliente = new Cliente();
					System.out.println("Digite o nome do cliente");
					cliente.setNmCliente(scanner.next());
					System.out.println("Digite o Cpf do cliente");
					cliente.setNrCpf(scanner.next());
					clienteDAO().insert(cliente);
					idCliente = clienteDAO().load(cliente.getIdCliente()).getIdCliente();
				}else if (definir == 2) {
					MostrarTodosCliente();
					System.out.println("Escolha um cliente por ID:");
					idCliente = scanner.nextLong();
				}
				
				System.out.println("Escreva a descricao do pedido");
				String dsPedido = scanner.nextLine();
				Pedido pedido = new Pedido();
				pedido.setIdCliente(idCliente);
				pedido.setDsPedido(dsPedido);
				pedidoDAO().insert(pedido);
                break;
                
            case 2:
            	Scanner in = new Scanner(System.in);
        		System.out.println("Escolha um cliente");
        		MostrarTodosCliente();
        		Long selecionado = scanner.nextLong();
        		List<Pedido> lista = pedidoDAO().findByCliente(selecionado);
        		for (Pedido request : lista) {
        			System.out.print(request.getIdPedido() +  " - ");
        			System.out.print(request.getIdCliente() + " -- ");
        			System.out.println(request.getDsPedido());
        		}
                break;
                
            case 3:
        		System.out.println("Digite o id do pedido");
        		Long idServico = scanner.nextLong();
        		Pedido buscado = pedidoDAO().load(idServico);
        		System.out.println("ID Pedido: "+buscado.getIdPedido() + "\n -ID Cliente" + buscado.getIdCliente() + "\n -Descricao:" + buscado.getDsPedido());
                break;
                
            default:
                System.out.println("Selecione uma das opcoes listadas");
			}
			
            
		}
	}
	
	public static PedidoDao pedidoDAO(){
		return new PedidoDao();
	}
	
	public static ClienteDao clienteDAO(){
		return new ClienteDao();
	}
	
	public static void MostrarTodosCliente() throws SQLException{
		List<Cliente> lista = clienteDAO().listAll();
		for (Cliente cliente : lista) {
			System.out.println(cliente.getIdCliente() + "- " + cliente.getNmCliente());
		}
	}
}
