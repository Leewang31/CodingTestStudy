package baekjoon.diviedandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LovedGCD {

    private static int[] arr;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(reader.readLine());
        arr = new int[N];

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(0, N - 1));
    }

    private static long solve(int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = (end - start + 1) / 2;
        return Math.max(calc(start, start + mid - 1) + solve(start + mid, end)
                , solve(start, start + mid - 1) + calc(start + mid, end));
    }

    private static int calc(int start, int end) {
        int gcd = arr[start];
        for (int i = start; i <= end; i++) {
            gcd = getGCD(gcd, arr[i]);
        }
        return gcd;
    }

    private static int getGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return getGCD(num2, num1 % num2);
    }
}
