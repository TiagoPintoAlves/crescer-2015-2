package primeiroExercicio;

public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        System.out.println(linkedList.list());
        linkedList.remove(1);

    }
}
