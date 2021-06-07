package ru.haazad.homework6;

public class TestApp {
    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(66);
        tree.add(50);
        tree.add(65);
        tree.add(80);
        tree.add(42);
        tree.add(22);
        tree.add(27);
        tree.add(56);
        tree.add(85);
        tree.add(99);
        tree.add(10);

        System.out.println("Find 85: " + tree.contains(85));
        System.out.println("Find 85: " + tree.contains(700));

        tree.traverse(Tree.TraverseMode.IN_ORDER);
        tree.display();
    }


}
