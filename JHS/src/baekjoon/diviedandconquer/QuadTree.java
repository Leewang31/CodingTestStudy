package baekjoon.diviedandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {

    private static int[][] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(String.valueOf(line.charAt(j)));
            }
        }

        divide(0, 0, N);
        System.out.println(sb.toString());
    }

    private static void divide(int x, int y, int size) {
        if (!check(x, y, size)) {
            sb.append("(");
            int newSize = size / 2;
            divide(x, y, newSize);
            divide(x, y + newSize, newSize);
            divide(x + newSize, y, newSize);
            divide(x + newSize, y + newSize, newSize);
            sb.append(")");
            return;
        }
        sb.append(arr[x][y]);
    }

    private static boolean check(int x, int y, int size) {
        int flag = arr[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(arr[i][j] != flag)
                    return false;
            }
        }
        return true;
    }
}
