package ru.haazad.homework4;


import ru.haazad.homework3.stack.Stack;

public class LinkedStackImpl<E> implements Stack<E> {
    private SimpleLinkedListImpl<E> data;

    @Override
    public void push(E value) {
        data.insertFirst(value);
    }

    @Override
    public E pop() {
        return data.getFirst();
    }

    @Override
    public E peek() {
        return data.removeFirst();
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

    @Override
    public void display() {
        data.display();
    }
}
