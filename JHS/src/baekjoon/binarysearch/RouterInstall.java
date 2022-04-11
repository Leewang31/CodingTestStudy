package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstall {

    private static int N;
    private static int[] house;
    private static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(house);
        int start = 1;
        int end = house[N - 1] - house[0] + 1;

        System.out.println(solve(start, end));
    }

    private static int solve(int start, int end) {
        while (start < end) {
            System.out.println("start = " + start + ", end = " + end);
            int mid = (start + end) / 2;

            int count = 1;
            int currentHouse = house[0];
            for (int i = 1; i < N; i++) {
                if (house[i] - currentHouse >= mid) {
                    count++;
                    currentHouse = house[i];
                }
            }

            if (count < C) {
                end = mid - 1;
            }else
                start = mid + 1;

        }
        return start-1;
    }
}
