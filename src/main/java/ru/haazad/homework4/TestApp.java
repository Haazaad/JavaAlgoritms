package ru.haazad.homework4;

public class TestApp {
    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = prepareList();
        linkedList.display();
        linkedList.removeFirst();
        linkedList.remove(5);
        linkedList.display();
        System.out.println("Contains 4: " + linkedList.contains(4));
        System.out.println("Contains 12: " + linkedList.contains(12));
        linkedListIterator(linkedList);
    }

    private static LinkedList<Integer> prepareList() {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        for (int i = 0; i <= 10; i++) {
            list.insertFirst(i);
        }
        return list;
    }

    private static void linkedListIterator(LinkedList<Integer> list) {
        for (Integer i: list) {
            System.out.println(i);
        }
        System.out.println(list.iterator().hasNext());
        System.out.println(list.iterator().next());
    }

}
