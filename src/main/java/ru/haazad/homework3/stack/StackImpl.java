package ru.haazad.homework3.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StackImpl<E> implements Stack<E> {
    private static final Logger logger = LogManager.getLogger(StackImpl.class);

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }


    @Override
    public void push(E value) {
        data[size++] = value;
    }

    @Override
    public E pop() {
        E value = peek();
        data[--size] = null;
        return value;
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void display() {
        logger.info(this);
    }
}
