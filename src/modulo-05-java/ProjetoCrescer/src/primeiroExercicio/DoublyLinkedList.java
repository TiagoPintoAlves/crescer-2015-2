package primeiroExercicio;

import java.util.List;

import primeiroExercicioException.EmptyListException;

public class DoublyLinkedList implements ListAction {

    public Node last, first;

    @Override
    public void addFirst(String value) {
        Node node;
    }

    @Override
    public String getFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addLast(String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(int index, String value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub

    }

    protected class Node {

        public String value;

        public Node first, next, previus;

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
