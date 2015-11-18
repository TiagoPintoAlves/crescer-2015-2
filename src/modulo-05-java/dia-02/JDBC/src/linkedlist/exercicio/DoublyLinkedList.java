package linkedlist.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import linkedlist.exception.EmptyListException;
import linkedlist.exercicio.LinkedList.Node;

public class DoublyLinkedList<T> implements ListAction<T> {

    protected Node<T> last, first;

	@Override
	public void addFirst(T value) {
		if(first == null){
			Node<T> node = new Node<T>(value);
			this.first = node;
			this.last = node;
		}else{
			Node<T> node = new Node<T>(value, this.first);
			this.first.setPrevious(node);
			this.first = node;
		}
	}

	@Override
	public T getFirst() {
		return this.first.getValue();
	}

	@Override
	public void addLast(T value) {
		if(first == null){
			Node<T> node = new Node<T>(value);
			this.first = node;
			this.last = node;
		}else{
			Node<T> node = new Node<T>(value);
			this.last.setNext(node);
			node.setPrevious(this.last);
			this.last = node;
		}
	}
	
	@Override
	public T getLast() throws EmptyListException {
		if (isEmpty()) {
       	 throw new NoSuchElementException();
       }
		return this.last.getValue();
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
	
	public Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

	@Override
	public void add(int index, T value) {
		if(index == 0){
			this.addFirst(value);
		}else{
			Node<T> Last = getNode(index - 1);
			Node<T> Next = Last.getNext();
			Node<T> node = new Node<T>(value, Next.getNext());
			node.setPrevious(Last);
			Last.setNext(node);
			Next.setPrevious(node);
		}
	}

	@Override
	public void add(T value) {
		addLast(value);
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
		if(index == 0){
			removeFirst();
		}else if(getNode(index) == null){
			throw new IllegalArgumentException("Indice invalido");
		}else{
			Node<T> anterior = getNode(index - 1);
			Node<T> atual = anterior.getNext();
			Node<T> proximo = atual.getNext();
			
			anterior.setNext(proximo);
			proximo.setPrevious(anterior);
		}
		
	}
	
	protected class Node<T> {

        private T value;

        private Node<T> next, previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
        
        public Node(T value, Node<T> next){
        	this.value = value;
        	this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
        
        public Node<T> getPrevious() {
			return previous;
		}
        
        public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
