package linkedlist.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListAction<T> {

    protected Node<T> last, first;

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (first == null) {
            last = node;
        }
        this.first = node;
    }

    @Override
    public T getFirst() {
        return first.getValue();
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if(first == null){
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    @Override
    public void removeFirst() {
        if(getNode(0) != null){
            throw new IllegalArgumentException("Posicao nao existe");
        }
        this.first = this.first.getNext();
        if(this.first == null){
            this.last = null;
        }
    }

    @Override
    public void remove(int index) {
        if(getNode(0) != null){
            throw new IllegalArgumentException("Posicao nao existe");
        }

        Node<T> anterior = getNode(index - 1);
        Node<T> atual = anterior.getNext();
        Node<T> proximo = atual.getNext();

        anterior.setNext(proximo);

        /*
         * Node<T> tmp = getNode(index - 1);
         * Node<T> removido = tmp.getNext();
         * tmp.setNext(removido);
         */
    }

    public Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public void add(int index, T value){
        Node<T> node = new Node<T>(value);
        getNode(index - 1).next = node;

    }

    @Override
    public void add(T value){
        addLast(value);
    }

    protected class Node<U> {

        private U value;

        private Node<U> next;

        public Node(U value, Node<U> next) {
            this.value = value;
            this.next = next;
        }

        public Node(U value) {
            this.value = value;
        }

        public U getValue() {
            return this.value;
        }

        public void setValue(U value) {
            this.value = value;
        }

        public Node<U> getNext() {
            return this.next;
        }

        public void setNext(Node<U> next) {
            this.next = next;
        }
    }
}
