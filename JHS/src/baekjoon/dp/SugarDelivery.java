package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class SugarDelivery {
    private static final int FIRST_BAG = 5;
    private static final int SECOND_BAG = 3;
    private static int dp[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        //반복문 호출 방식
        /*int count = 0;

        while (N > 0) {
            if (N % FIRST_BAG == 0) {
                count += N / FIRST_BAG;
                N = 0;
                break;
            }
            N -= SECOND_BAG;
            count++;
        }
        System.out.println((N == 0) ? count : -1);*/

        //재귀 호출 방식
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        
        System.out.println((solve(N, 0) == Integer.MAX_VALUE) ? -1 : dp[N]);
    }

    private static int solve(int n, int count) {
        if(n < 0)
            return Integer.MAX_VALUE;
        if(dp[n] != -1)
            return dp[n];
        if (n == 0)
            return count;

        dp[n] = Math.min(solve(n - FIRST_BAG, count + 1), solve(n - SECOND_BAG, count + 1));
        return dp[n];
    }
}
