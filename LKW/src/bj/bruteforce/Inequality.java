package bj.bruteforce;

import java.util.Scanner;

public class Inequality {
    static int N;
    static int[] num = new int[10];
    static boolean[] visited = new boolean[10];
    static int[] result = new int[N + 1];
    static char[] sign = new char[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++)
            sign[i] = sc.next().toCharArray()[0];
        for (int i = 0; i < 10; i++)
            num[i] = i;
        for (int i = 0; i < 10; i++) {
            min(i, 0);
        }
    }

    private static void min(int n, int cnt) {
        if (cnt == N) {
            for (int i = 0; i < 10; i++) {
                System.out.print(result[i] + " ");
                return;
            }
        }
        if (cnt == 0) {
            result[cnt] = num[n];
            visited[n] = true;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (check(result[cnt], i, cnt) == true) {
                result[cnt + 1] = num[i];
                visited[i] = true;
                min(result[cnt + 1], cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int n, int i, int cnt) {
        if (sign[cnt] == '<')
            if ((n > i) == true)
                return false;
        if (sign[cnt] == '>')
            if ((n < i) == true)
                return false;
        return true;
    }
}
//실패 list로 구현만 가능한가?