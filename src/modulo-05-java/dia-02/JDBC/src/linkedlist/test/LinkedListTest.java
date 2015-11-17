package linkedlist.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linkedlist.exercicio.LinkedList;


public class LinkedListTest {

    @Test
    public void adicionarPrimeiroNaLista() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void mostrarTodosNaLista() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.list().size(), 3);
    }

    @Test
    public void removePrimeiroDaLista() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        linkedList.removeFirst();

        assertEquals(linkedList.getFirst(), "terceiro");
    }

    @Test
    public void removeUltimoDaListaPorIndice() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        linkedList.remove(2);
        
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
        assertEquals(linkedList.list().size(), 3);
    }
    
    @Test
    public void adicionarEmListaDeNumeros() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        
        assertEquals(linkedList.list().size(), 3);
    }
}
