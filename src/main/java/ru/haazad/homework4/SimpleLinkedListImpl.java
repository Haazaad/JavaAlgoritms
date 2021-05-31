package ru.haazad.homework4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {
    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement, null);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        firstElement.prev = null;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        Node<E> next;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            next = current.next;
            previous.next = next;
            next.prev = previous;
        }
        current.next = null;
        current.prev = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
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
    public void display() {
        System.out.println("-------------");
        System.out.println(this);
        System.out.println("-------------");
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> node) {
        return node != null ? node.item : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>();
    }

    class LinkedListIterator<E> implements Iterator<E> {
        int index;
        Node<E> current;

        public LinkedListIterator() {
            this.index = 0;
            if (hasNext()) {
                this.current = (Node<E>) SimpleLinkedListImpl.this.firstElement;
            }
        }

        @Override
        public boolean hasNext() {
            return index != SimpleLinkedListImpl.this.size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E item = current.item;
                index++;
                current = current.next;
                return item;
            }
            return null;
        }

        @Override
        public void remove() {
            SimpleLinkedListImpl.this.removeFirst();
        }
    }
}
