package ru.haazad.homework4;


import ru.haazad.homework3.queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {

    private final TwoSideLinkedList<E> data;

    public LinkedQueueImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }


    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
