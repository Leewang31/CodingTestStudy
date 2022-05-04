package bj.binarySearch;

import java.util.Scanner;

public class SteppingStone {
    private static int N;
    private static int[] arr;
    private static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = -1;
        }
        System.out.println(step(0));
    }

    public static long step(int x) {
        if (x == N - 1) return 0;
        if (dp[x] != -1) {
            return dp[x];
        }
        dp[x] = Long.MAX_VALUE;
        for (int i = x + 1; i < N; i++) {
            dp[x] = Math.min(dp[x], Math.max(step(i), (i - x) * (1 + Math.abs(arr[x] - arr[i]))));
        }
        return dp[x];
    }
}
// 실패 풀이 봄
