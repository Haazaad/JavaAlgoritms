package ru.haazad.homework7;

import java.util.Stack;

public class TestApp {
    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Курск", "Воронеж");


//        Stack<String> stack = graph.findShortWay("Москва", "Воронеж");
        Stack<String> stack = graph.findShortWay("Рязань", "Калуга");
        showShortWay(stack);
    }

    private static void showShortWay(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while (!stack.isEmpty()) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
