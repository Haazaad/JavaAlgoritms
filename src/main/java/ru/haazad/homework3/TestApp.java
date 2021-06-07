package ru.haazad.homework3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.haazad.homework3.queue.Queue;
import ru.haazad.homework3.stack.Stack;
import ru.haazad.homework3.stack.StackImpl;
import ru.haazad.homework4.LinkedQueueImpl;
import ru.haazad.homework4.LinkedStackImpl;

public class TestApp {
    private static final Logger logger = LogManager.getLogger(TestApp.class);

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static Integer removeFromStack(Stack<Integer> stack) {
        return !stack.isEmpty() ? stack.pop() : null;
    }

    private static boolean addToStack(Stack<Integer> stack, Integer value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testStack() {
//        Stack<Integer> stack = new StackImpl<>(5);
        Stack<Integer> stack = new LinkedStackImpl<>();
        for (int i = 0; i < 7; i++) {
            logger.info("Add value " + i + " to stack: " + addToStack(stack, i));
        }
        logger.info(stack);
        logger.info("Stack size: " + stack.size());
        logger.info("Stack peek: " + stack.peek());

        while (!stack.isEmpty()) {
            logger.info("Stack pop: " + removeFromStack(stack));
        }
        logger.info(stack);
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueueImpl<>(5);
        Queue<Integer> queue = new LinkedQueueImpl<>();
        for (int i = 0; i < 7; i++) {
            logger.info("Insert into queue: " + queue.insert((int) (Math.random() * 10)));
        }
        logger.info("Queue remove: " + queue.remove());
        logger.info("Queue peek: " + queue.peekFront());
        logger.info("Queue size: " + queue.size());
        logger.info("Queue is full: " + queue.isFull());
        while (!queue.isEmpty()) {
            logger.info("Queue remove: " + queue.remove());
        }
        logger.info("Queue size: " + queue.size());
    }
}
