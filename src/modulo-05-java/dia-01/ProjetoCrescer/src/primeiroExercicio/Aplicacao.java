package primeiroExercicio;

import java.util.Scanner;
public class Aplicacao extends Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        LinkedList linkedList;
        int opcao = 0;
        int escolha;
        boolean continuar = true;
        
        do{
        	System.out.println("Digite uma op��o:");
            StringBuilder alternativas = new StringBuilder();
            alternativas.append("1- Adicionar na lista\n");
            alternativas.append("2- Remover da lista\n");
            alternativas.append("3- Buscar na Lista\n");
            alternativas.append("4- Listagem completa\n");
            System.out.println(alternativas);
            
            try{
            	opcao = scanner.nextInt();
            }catch(Exception e){
            }
            
            switch(opcao){
            case 1:
            	break;
            case 2:
            	break;
            case 3:
            	break;
            case 4:
            	break;
            	default:
            		System.out.println("Erro. Selecione uma das op��es.");
            }
            
            System.out.println("Deseja continuar ? 1-Sim ou 2-N�o");
            escolha = scanner.nextInt();
            continuar = (escolha == 1)? true : false;
        }while(continuar == true);
    }
}
