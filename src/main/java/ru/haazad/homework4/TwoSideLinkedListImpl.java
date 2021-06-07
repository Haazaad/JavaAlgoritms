package ru.haazad.homework4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>{
    private Node<E> lastElement;

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, null);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            newNode.prev = lastElement;
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if (isEmpty()) {
            lastElement = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        Node<E> next;
        while (current != null) {
            if (current.item.equals(value)){
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
        } else if (current == lastElement){
            lastElement = previous;
            previous.next = null;
        } else  {
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
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = lastElement;
        Node<E> previous = lastElement.prev;
        lastElement.prev = null;
        previous.next = null;
        lastElement = previous;
        size--;
        return removedNode.item;
    }
}
