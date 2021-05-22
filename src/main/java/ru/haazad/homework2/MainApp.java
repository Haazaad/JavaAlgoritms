package ru.haazad.homework2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainApp {
    private static final Logger logger = LogManager.getLogger(MainApp.class);

    private static final int ARRAY_SIZE = 1_000_000;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Array<Integer> array = generateAndFillArray();
            logger.info("Current array size: " + array.size());
            array.sortBubble();
        });
        Thread t2 = new Thread(() -> {
            Array<Integer> array = generateAndFillArray();
            logger.info("Current array size: " + array.size());
            array.sortSelect();
        });
        Thread t3 = new Thread(() -> {
            Array<Integer> array = generateAndFillArray();
            logger.info("Current array size: " + array.size());
            array.sortInsert();
        });
        t1.start();
        t2.start();
        t3.start();
    }

    private static Array<Integer> generateAndFillArray() {
        Array<Integer> array = new ArrayImpl<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array.add((int) (Math.random() * ARRAY_SIZE));
        }
        return array;
    }
}
