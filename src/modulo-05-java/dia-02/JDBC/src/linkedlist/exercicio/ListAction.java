package linkedlist.exercicio;

import java.util.List;

import linkedlist.exception.EmptyListException;

public interface ListAction<T> {

    void addFirst(T value);

    T getFirst();

    T getLast() throws EmptyListException;

    List<T> list();

    void addLast(T value);

    void add(int index, T value);
    
    void add(T value);

    void removeFirst();

    void remove(int index);

}