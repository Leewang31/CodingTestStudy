package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPermutation {

    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sb = new StringBuilder();
        N = scanner.nextInt();

        solve(0, new ArrayList<>());
        System.out.println(sb);
    }

    private static void solve(int count, List<Integer> list) {
        if (count == N) {
            for (Integer i : list) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!list.contains(i)) {
                list.add(i);
                solve(count+1, list);
                list.remove(count);
            }
        }
    }
}
