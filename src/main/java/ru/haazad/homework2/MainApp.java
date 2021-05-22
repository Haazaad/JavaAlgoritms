package ru.haazad.homework2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final Logger logger = LogManager.getLogger(MainApp.class);

    private static final int ARRAY_SIZE = 300_000;

    public static void main(String[] args) {
        long startThreadTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            Array<Integer> array = generateAndFillArray();
            logger.info("Current array size: " + array.size());
            array.sortBubble();
            logger.info("Thread working time in seconds: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startThreadTime));
        });
        Thread t2 = new Thread(() -> {
            Array<Integer> array = generateAndFillArray();
            logger.info("Current array size: " + array.size());
            array.sortSelect();
            logger.info("Thread working time in seconds: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startThreadTime));
        });
        Thread t3 = new Thread(() -> {
            Array<Integer> array = generateAndFillArray();
            logger.info("Current array size: " + array.size());
            array.sortInsert();
            logger.info("Thread working time in seconds: " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startThreadTime));
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
