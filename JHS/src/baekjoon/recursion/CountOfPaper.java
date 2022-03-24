package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountOfPaper {

    private static int[][] arr;
    private static int ONE;
    private static int ZERO;
    private static int NEGATIVE_ONE;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(reader.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(NEGATIVE_ONE);
        System.out.println(ZERO);
        System.out.println(ONE);
    }

    private static void divide(int x, int y, int size) {
        if (!checkPaper(x, y, size)) {
            int newSize = size / 3;
            divide(x, y, newSize);
            divide(x, y + newSize, newSize);
            divide(x, y + newSize * 2, newSize);

            divide(x + newSize, y, newSize);
            divide(x + newSize, y + newSize, newSize);
            divide(x + newSize, y + newSize * 2, newSize);

            divide(x + newSize * 2, y, newSize);
            divide(x + newSize * 2, y + newSize, newSize);
            divide(x + newSize * 2, y + newSize * 2, newSize);
        }
    }

    private static boolean checkPaper(int x, int y, int size) {
        int flag = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != flag) {
                    return false;
                }
            }
        }
        increaseCount(flag);
        return true;
    }

    private static void increaseCount(int flag) {
        if (flag == 1) {
            ONE++;
        }
        if (flag == 0) {
            ZERO++;
        }
        if (flag == -1) {
            NEGATIVE_ONE++;
        }
    }
}
