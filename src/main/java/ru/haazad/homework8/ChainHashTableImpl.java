package ru.haazad.homework8;

import java.util.LinkedList;

public class ChainHashTableImpl<K, V> implements HashTable<K, V> {
    private final LinkedList<Node<K, V>> data;
    private int size;
    private int currentCapacity;

    static class Node<K, V> implements Entry<K, V>{
        private final K key;
        private V value;
        private Node<K, V> nextNode;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public ChainHashTableImpl(int initialCapacity) {
        this.data = new LinkedList<>();
        this.currentCapacity = initialCapacity;
        for (int i = 0; i < initialCapacity; i++) {
            data.add(null);
        }
    }

    private int getKeyIndex(K key) {
        return key.hashCode() % currentCapacity;
    }

    @Override
    public boolean put(K key, V value) {
        int index = getKeyIndex(key);
        Node<K, V> node = data.get(index);
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return true;
            }
            node = node.nextNode;
        }
        size++;
        node = data.get(index);
        Node<K, V> newNode = new Node<>(key, value);
        newNode.nextNode = node;
        data.set(index, newNode);
        return true;
    }



    @Override
    public V get(K key) {
        int index = getKeyIndex(key);
        Node<K, V> node = data.get(index);
        while (node != null) {
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.nextNode;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = getKeyIndex(key);
        Node<K, V> currentNode = data.get(index);
        Node<K, V> prevNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)){
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (currentNode == null) {
            return null;
        }
        if (prevNode != null) {
            prevNode.nextNode = currentNode.nextNode;
        } else {
            data.set(index, currentNode.nextNode);
        }
        size--;
        return currentNode.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("-----------------");
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("%d = [%s]%n", i, data.get(i));
        }
        System.out.println("-----------------");
    }
}
