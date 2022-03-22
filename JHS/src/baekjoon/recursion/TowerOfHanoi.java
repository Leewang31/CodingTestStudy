package baekjoon.recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class TowerOfHanoi {

    private static StringBuilder sb;
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sb = new StringBuilder();
        count = 0;

        int N = scanner.nextInt();
        if (N <= 20) {
            solve(N, 1, 2, 3);
            sb.insert(0, count + "\n");
            System.out.println(sb.toString());
            return;
        }
        System.out.println(new BigInteger("2").pow(N).subtract(BigInteger.ONE));
    }

    private static void solve(int N, int start, int by, int end) {
        if (N == 1) {
            sb.append(start + " " + end + "\n");
            count++;
            return;
        }
        solve(N - 1, start, end, by);
        sb.append(start + " " + end + "\n");
        count++;
        solve(N-1, by, start, end);
    }
}
