package ru.haazad.homework3.deque;

import ru.haazad.homework3.queue.Queue;

public interface DeQueue<E> extends Queue<E> {
    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();
}