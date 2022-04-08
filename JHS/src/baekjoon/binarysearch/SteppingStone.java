package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SteppingStone {

    private static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(solve(arr));
    }

    private static long solve(long[] arr) {
        long start = 0;
        long end = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;

            boolean[] dp = new boolean[n];
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                if (dp[n-1])
                    break;
                if (dp[i]) {
                    for (int j = i+1; j < n; j++) {
                        long l = (j - i) * (1 + Math.abs(arr[i] - arr[j]));
                        if (l <= mid) {
                            dp[j] = true;
                        }
                    }
                }
            }
            if (dp[n - 1]) {
                end = mid - 1;
            }else
                start = mid + 1;
        }
        return start;
    }
}
