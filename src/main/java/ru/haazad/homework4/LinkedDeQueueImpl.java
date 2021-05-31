package ru.haazad.homework4;

import ru.haazad.homework3.deque.DeQueue;

public class LinkedDeQueueImpl<E> extends LinkedQueueImpl<E> implements DeQueue<E> {
    private final TwoSideLinkedList<E> data;

    public LinkedDeQueueImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        E removedValue = data.getLast();
        data.remove(removedValue);
        return removedValue;
    }
}
