package primeiroExercicio;

import java.util.List;

import primeiroExercicioException.EmptyListException;

public interface ListAction {

    void addFirst(String value);

    String getFirst();

    String getLast() throws EmptyListException;

    List<String> list();

    void addLast(String value);

    void add(int index, String value);

    void removeFirst();

    void remove(int index);

}
