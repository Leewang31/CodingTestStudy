package baekjoon.dp;

import java.util.Scanner;

public class BABBA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();

        int[] arr = new int[K + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= K; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        int len = arr.length;
        System.out.println(arr[len-2] + " " + arr[len-1]);
    }
}
