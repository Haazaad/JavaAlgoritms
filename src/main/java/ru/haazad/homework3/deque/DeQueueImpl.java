package ru.haazad.homework3.deque;

import ru.haazad.homework3.queue.QueueImpl;

public class DeQueueImpl<E> extends QueueImpl<E> implements DeQueue<E> {

    public DeQueueImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == DEFAULT_HEAD) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return insert(value);
    }

    @Override
    public E removeLeft() {
        return remove();
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        if (tail == DEFAULT_TAIL) {
            tail = data.length - 1;
        }
        E value = data[tail--];
        size--;
        return value;
    }
}