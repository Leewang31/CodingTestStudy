package bj.binarySearch;

import java.util.Scanner;

public class WeightLimit {
    private static int N;
    private static int M;
    private static int start;
    private static int end;
    private static int[][] hint;
    private static boolean[] visited;
    private static int result = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        hint = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            hint[a][b] = Math.max(hint[a][b], c);
            hint[b][a] = hint[a][b];
        }
        start = sc.nextInt();
        end = sc.nextInt();
        check(start);
        System.out.println(result);
    }

    private static void check(int spot) {
        visited[spot] = true;
        if (spot == end) {
            for (int i = 1; i < N + 1; i++)
                visited[i] = false;
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i] && (hint[spot][i] != 0)) {
                result = Math.max(result, hint[spot][i]);
                System.out.println("spot = " + spot + "result = " + result);
                check(i);
            }
        }
    }
}
