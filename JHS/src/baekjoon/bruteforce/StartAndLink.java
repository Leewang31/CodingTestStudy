package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StartAndLink {

    private static int[][] arr;
    private static int N;
    private static List<Integer> start;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(reader.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = new ArrayList<>();
        System.out.println(divideGroup(0, 0));
    }

    private static int divideGroup(int size, int index) {
        int min = Integer.MAX_VALUE;
        if (size == N / 2) {
            return calc();
        }
        for (int i = index; i < N; i++) {
            if (!start.contains(i)) {
                start.add(i);
                min = Math.min(min, divideGroup(size + 1, i+1));
                start.remove(size);
            }
        }
        return min;
    }

    private static int calc() {
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (start.contains(i) && start.contains(j)) {
                    startSum += arr[i][j] + arr[j][i];
                }
                if (!start.contains(i) && !start.contains(j)) {
                    linkSum += arr[i][j] + arr[j][i];
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }
}
