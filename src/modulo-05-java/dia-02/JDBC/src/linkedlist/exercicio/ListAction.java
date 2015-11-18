package linkedlist.exercicio;

import java.util.List;

import linkedlist.exception.EmptyListException;
import linkedlist.exercicio.LinkedList.Node;

public interface ListAction<T> {

    void addFirst(T value);

    void add(int index, T value);

    void addLast(T value);
    
    T getFirst();
    
    T getLast() throws EmptyListException;
    
    List<T> list();
    
    void add(T value);

    void removeFirst();

    void remove(int index);

}
