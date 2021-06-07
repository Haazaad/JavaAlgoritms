package ru.haazad.homework5;

public class Exponent {
    public static void main(String[] args) {
        int number = 2;
        int exp = 5;
        if (exp >= 0) {
            System.out.printf("Number %d in power %d is %d", number, exp, (int) exponent(number, exp));
        } else {
            System.out.printf("Number %d in power %d is %f", number, exp, 1 / exponent(number, exp));
        }
    }

    private static double exponent(int n, int exponent) {
        exponent = Math.abs(exponent);
        if (exponent == 0 || n == 0) {
            return 1;
        } else {
            return n * exponent(n, --exponent);
        }
    }
}
