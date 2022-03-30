package bj.bruteforce;

import java.util.Scanner;

public class Bomboni {
    static char charArr[][];
    static int max = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        charArr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String word = sc.next();
            for (int j = 0; j < N; j++) {
                charArr[i][j] = word.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, i, j, j + 1);
                check();
                swap(i, i, j + 1, j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(j, j + 1, i, i);
                check();
                swap(j + 1, j, i, i);
            }
        }
        System.out.println(max);
    }

    private static void check() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if(charArr[i][j] == charArr[i][j+1])
                    cnt++;
                else
                    cnt =1;
                max = max>cnt?max:cnt;
            }
        }
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if(charArr[j][i] == charArr[j+1][i])
                    cnt++;
                else
                    cnt =1;
                max = max>cnt?max:cnt;
            }
        }
    }

    private static void swap(int a1, int a2, int b1, int b2) {
        char tp;
        tp = charArr[a1][b1];
        charArr[a1][b1] = charArr[a2][b2];
        charArr[a2][b2] = tp;
    }
}