package ru.haazad.homework4;

public interface TwoSideLinkedList<E> extends LinkedList<E>{
    void insertLast(E value);

    E getLast();

    E removeLast();

}
