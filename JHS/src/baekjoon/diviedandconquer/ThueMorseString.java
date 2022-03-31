package baekjoon.diviedandconquer;

import java.util.Scanner;

public class ThueMorseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        System.out.println(solve(k));
    }

    private static int solve(long number) {
        if (number == 1) {
            return 0;
        }
        long i;
        for (i = 1; i + i < number; i += i) {}
        return solve(number-i) ^ 1;
    }
}
