package bj.bruteforce;

import java.util.Scanner;

public class StartandLink {
    private static int N;
    private static boolean[] num = new boolean[N];
    private static int[] my = new int[N / 2];
    private static int[] you = new int[N / 2];
    private static int[][] arr;
    private static int Min = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        choose(0);
    }

    private static void choose(int cnt) {
        if (cnt == N / 4) {
        }

        for (int i = 0; i < N; i++) {
            if (!num[i]) {
                my[cnt] = i;
                num[i] = true;
                choose(cnt + 1);
            }
        }
        for (int i = 0; i < N; i++)
            num[i]=false;
    }



    private static void chooseyou(int cntY) {
        if (cntY == N / 4) {
            for (int i = 0; i < N; i++) {
                if (!num[i]) {
                    you[cntY] = i;
                    num[i] = true;
                    choose(cntY + 1);
                }
            }
        }
    }

}
//실패 다시 생각해야할듯