package linkedlist.exercicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Aplicacao extends Exception {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("C:\\Users\\tiago.alves\\Downloads");
        LinkedList linkedList = new LinkedList();
        int opcao = 0;
        int escolha;
        boolean continuar;

        do{
            System.out.println("Digite uma opcao:");
            StringBuilder alternativas = new StringBuilder();
            alternativas.append("1- Adicionar na lista\n");
            alternativas.append("2- Remover da lista\n");
            alternativas.append("3- Buscar na Lista\n");
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    try {
                        file.setReadable(false);
                        file.createNewFile();
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter buff = new BufferedWriter(fw);

                        buff.write(linkedList.list().toString());

                    } catch (IOException e) {
                        System.err.println(e);
                    }

                    break;
                default:
                    System.out.println("Erro. Selecione uma das opcoes.");
            }

            System.out.println("Deseja continuar ? 1-Sim ou 2-Nao");
            escolha = scanner.nextInt();
            continuar = (escolha == 1)? true : false;
        }while(continuar == true);
    }
}
