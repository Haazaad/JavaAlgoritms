package ru.haazad.homework7;

import java.util.Stack;

public interface Graph {
    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    void dfs(String startLabel);

    void bfs(String startLabel);

    Stack<String> findShortWay(String startLabel, String endLabel);
}
