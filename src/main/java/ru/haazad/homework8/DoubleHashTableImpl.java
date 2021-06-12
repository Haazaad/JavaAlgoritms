package ru.haazad.homework8;

public class DoubleHashTableImpl<K, V> extends  HashTableImpl<K, V> {

    private static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected int getStep(K key) {
        return hashDoubleFunction(key);
    }

    private int hashDoubleFunction(K key) {
        return 5 - (key.hashCode() % DOUBLE_HASH_CONST);
    }
}
