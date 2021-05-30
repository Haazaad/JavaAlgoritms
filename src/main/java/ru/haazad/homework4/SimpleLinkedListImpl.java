package ru.haazad.homework4;

public class SimpleLinkedListImpl<E> implements LinkedList<E>{
    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
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
        } else {
            previous.next = current.next;
        }
        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)){
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
        return firstElement != null ? firstElement.item : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                current = current.next;
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
