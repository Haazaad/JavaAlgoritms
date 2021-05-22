package ru.haazad.homework2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E>{
    private static final Logger logger = LogManager.getLogger(ArrayImpl.class);

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public ArrayImpl(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @Override
    public void add(E value) {
        checkAndInflate();
        data[size++] = value;
    }

    private void checkAndInflate() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errorMsg = String.format("Incorrect 'index': %d, min value is %d, max value is %d", index, 0, size - 1);
            logger.throwing(Level.ERROR, new ArrayIndexOutOfBoundsException(errorMsg));
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedValue;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
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
        logger.info(this);
    }

    @Override
    public void sortBubble() {
        logger.info("Start bubble sorting");
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0){
                    swap(j, j + 1);
                }
            }
        }
        logger.info("Bubble sorting time in milliseconds: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    @Override
    public void sortSelect() {
        logger.info("Start select sorting");
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i; j < size - 1; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
        logger.info("Select sorting time in milliseconds: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
    }

    @Override
    public void sortInsert() {
        logger.info("Start insert sorting");
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            E temp = data[i];
            int index = i;
            while (index > 0 && data[index - 1].compareTo(temp) > 0) {
                data[index] = data[index - 1];
                index--;
            }
            data[index] = temp;
        }
        logger.info("Insert sorting time in milliseconds: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime));
    }

    @Override
    public String toString() {
        StringBuilder  stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
