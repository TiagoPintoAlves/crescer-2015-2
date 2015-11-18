package linkedlist.exercicio;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Aplicacao extends Exception {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //File file = new File("C:\\Users\\tiago.alves\\Downloads");
        File file = new File("C:\\Users\\vicente\\Downloads");
        int opcao = 0;
        int escolhaContinuar;
        boolean continuar;
        int escolhaLista;
        
    	System.out.println("Escolha um tipo de lista:");
    	System.out.println("1- Lista simples\n2- Lista dupla\n");
    	escolhaLista = scanner.nextInt();
    	ListAction lista = (escolhaLista == 1)? new LinkedList() : new DoublyLinkedList();
        
        do{
        	
            System.out.println("Digite uma opcao:");
            StringBuilder alternativas = new StringBuilder();
            alternativas.append("1- Adicionar na lista\n");
            alternativas.append("2- Adicionar no primeiro da lista\n");
            alternativas.append("3- Remover da lista\n");
            alternativas.append("4- Listagem completa\n");
            alternativas.append("5- Imprimir Lista\n");
            System.out.println(alternativas);
            
            try{
                opcao = scanner.nextInt();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }

            switch(opcao){
                case 1:
                	try{
                		System.out.println("Digite o valor a ser inserido:");
                    	String value = scanner.next();
                    	System.out.println("Digite a posicao a ser inserido:");
                    	int index = scanner.nextInt();
                    	lista.add(index, value);
                    	System.out.println("Elemento adicionado");
                	} catch(Exception e){
                		System.err.println(e);
                	}
                    break;
                case 2:
                	try{
                		System.out.println("Digite o valor a ser inserido:");
                    	String value = scanner.next();
                    	lista.addFirst(value);
                    	System.out.println("Elemento adicionado");
                	} catch(Exception e){
                		System.err.println(e);
                	}
                    break;
                case 3:
                	try{
                		System.out.println("Digite a posicao do elemento:");
                		int index = scanner.nextInt();
                		lista.remove(index);
                	} catch(Exception e){
                		System.err.println(e);
                	}
                    break;
                case 4:
                	System.out.println(lista.list());
                    break;
                case 5:
                    try {
                        file.setReadable(false);
                        file.createNewFile();
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter buff = new BufferedWriter(fw);

                        buff.write(lista.list().toString());

                    } catch (IOException e) {
                        System.err.println(e);
                    }
                    break;
                default:
                    System.out.println("Erro. Selecione uma das opcoes listadas.");
            }
            
            System.out.println("Deseja continuar ? 1-Sim ou 2-Nao");
            escolhaContinuar = scanner.nextInt();
            continuar = (escolhaContinuar == 1)? true : false;
        }while(continuar == true);
    }
}
