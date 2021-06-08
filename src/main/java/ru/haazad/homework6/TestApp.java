package ru.haazad.homework6;

public class TestApp {
    private static final int TREE_COUNT = 20;

    public static void main(String[] args) {
        generateTree();
    }

    private static void generateTree() {
        for (int i = 0; i < TREE_COUNT; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < 64; j ++) {
                tree.add(-25 + ((int) (Math.random() * 50) + 1));
            }
            tree.display();
            tree.isBalanced();
        }
    }
}
