package primeiroExercicio;

import java.util.ArrayList;
import java.util.List;

import primeiroExercicioException.EmptyListException;

public class LinkedList implements ListAction {

    public Node last, first;

    @Override
    public void addFirst(String value) {
        Node node = new Node(value);
        if (first == null) {
            last = node;
        }
        this.first = node;
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String getLast() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Tentou acessar lista vazia");
        }
        return last.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Node node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    @Override
    public void addLast(String value) {
        Node node = new Node(value);
        if (last == null) {
            first = node;
        }
        this.last = node;
    }

    @Override
    public void removeFirst() {
        list().remove(getFirst());
    }

    @Override
    public void remove(int index) {
        Node tmp = getNode(index - 1);
        Node removido = tmp.getNext();
        tmp.setNext(removido);
    }

    public Node getNode(int index) {
        Node node = first;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public void add(int index, String value){
        Node node = new Node(value);
        list().add(index, value);
        node.getValue();
        list().indexOf(index);
    }

    protected class Node {

        public String value;

        public Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
