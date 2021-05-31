package ru.haazad.homework3;

import ru.haazad.homework3.stack.Stack;
import ru.haazad.homework3.stack.StackImpl;

import java.util.Scanner;

public class StringBackwards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputString = scanner.nextLine();
        if (!checkString(inputString)) {
            System.out.println("Input string: " + inputString);
            System.out.println("String backward: " + stringBackwards(inputString));
        }
    }

    public static String stringBackwards(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new StackImpl<>(input.length());
        String[] str = input.split("");
        for (String s: str) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static boolean checkString(String input) {
        if (input.isEmpty()) {
            System.out.println("ERROR: Input string is empty");
            return true;
        }
        return false;
    }
}
