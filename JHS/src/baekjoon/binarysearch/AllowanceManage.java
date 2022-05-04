package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class AllowanceManage {

    private static int[] allowances;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        allowances = new int[N];
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            allowances[i] = Integer.parseInt(reader.readLine());
            min = Math.max(allowances[i], min);
            max += allowances[i];
        }
//        solve(Arrays.stream(allowances).min().getAsInt(), Arrays.stream(allowances).sum());
        System.out.println(solve(min, max));
    }

    private static int solve(int min, int max) {
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            int count = 1;

            for (int i = 0; i < N; i++) {
                if (sum + allowances[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += allowances[i];
            }
            if(count <= M)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return min;
    }
}
