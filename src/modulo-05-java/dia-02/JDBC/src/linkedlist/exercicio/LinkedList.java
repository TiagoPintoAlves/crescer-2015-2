package linkedlist.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListAction<T> {

    protected Node<T> last, first;

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (first == null) {
            last = node;
        }
        this.first = node;
    }

    public T getFirst() {
        return first.getValue();
    }
    
	public void addLast(T value) {
			Node<T> node = new Node<T>(value);
			if(first == null){
				first = node;
			}
			last.setNext(node);
			last = node;
	}
    
    public T getLast() {
        if (isEmpty()) {
        	 throw new NoSuchElementException();
        }
        return last.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }
    
    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }
    
    public void removeFirst() {
        list().remove(getFirst());
        
    }
    
    public void remove(int index) {
        Node<T> tmp = getNode(index - 1);
        Node<T> removido = tmp.getNext();
        tmp.setNext(removido);
    }

    public Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    
    public void add(int index, T value){
        Node<T> node = new Node<T>(value);
        getNode(index - 1).next = node;
        
    }
    
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
