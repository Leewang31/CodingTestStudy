package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class JewelryBox {

    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println(solve(1, Arrays.stream(arr).max().getAsInt()));
    }

    private static int solve(int min, int max) {
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;

            for (int i = 0; i < M; i++) {
                sum += arr[i] % mid == 0 ? arr[i] / mid : arr[i] / mid + 1;
            }
            if (sum > N) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }
}
