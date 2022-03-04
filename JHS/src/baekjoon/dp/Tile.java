package baekjoon.dp;

import java.util.Scanner;

public class Tile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (N == 1) {
            System.out.println("4");
            return;
        }
        long[] arr = new long[N];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println((arr[N - 1] + arr[N - 2] + arr[N-1])*2);
    }
}
