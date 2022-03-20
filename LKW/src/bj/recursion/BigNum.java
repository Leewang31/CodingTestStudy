package bj.recursion;

import java.util.Scanner;

public class BigNum {
    static int[] a;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[M];
        int cnt = 0;
        for (int x = 0; x < M; x++)
            a[x] = sc.nextInt();
        int[] num = new int[a.length * a.length * a.length];
        if (M == 3) {
            for (int x = 0; x < 3; x++)
                for (int y = 0; y < 3; y++)
                    for (int z = 0; z < 3; z++) {
                        num[cnt] = a[x] * 100 + a[y] * 10 + a[z];
                        cnt++;
                    }
        }
        if (M == 2) {
            for (int y = 0; y < 3; y++)
                for (int z = 0; z < 3; z++) {
                    num[cnt] = a[y] * 10 + a[z];
                    cnt++;
                }
        }
        System.out.println(CorrectNum(num, cnt - 1));
    }

    private static int CorrectNum(int[] num, int c) {
        int x;
        if (num[c] < N) {
            return num[c];
        } else
            x = CorrectNum(num, c - 1);
        if (x > num[c - 1])
            return num[c - 1];
        else
            return x;
    }
}


