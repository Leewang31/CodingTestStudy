package bj.bruteforce;

import java.util.Scanner;

public class NM {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        result = new int[M];
        arrSwap();
        getResult(0);
    }

    private static void arrSwap() {
        int[]arrTp=new int[N];
        for (int i = 0; i < N; i++)
            arrTp[i]=arr[i];
        for (int i = 0; i < N; i++)
            arr[i]=arrTp[N-(1+i)];
    }

    private static void getResult(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            result[cnt] = arr[i];
            getResult(cnt + 1);
        }
    }
}
