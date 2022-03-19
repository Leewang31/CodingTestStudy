package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpecialAward {

    private static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(reader.readLine());
        arr = new long[N][N];

        if (N == 1) {
            System.out.println(reader.readLine());
            return;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        System.out.println(divide(0, 0, N));
    }

    private static long divide(int x, int y, int size) {
        if (size == 2) {
            long[] dividedArr = {arr[x][y], arr[x + 1][y], arr[x][y + 1], arr[x + 1][y + 1]};
            Arrays.sort(dividedArr);
            return dividedArr[1];
        }

        int newSize = size / 2;
        long[] dividedArr =
                {divide(x, y, newSize)
                        , divide(x + newSize, y, newSize)
                        , divide(x, y + newSize, newSize)
                        , divide(x + newSize, y + newSize, newSize)};

        Arrays.sort(dividedArr);
        return dividedArr[1];
    }
}
