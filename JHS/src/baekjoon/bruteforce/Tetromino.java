package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tetromino {

    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {1, 0, -1, 0};

    private static int[][] etcX = {{0, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 2, 1}, {0, 1, 2, 1}};
    private static int[][] etcY = {{0, 1, 2, 1}, {0, 1, 2, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}};

    private static Position[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new Position[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = new Position(i, j, Integer.parseInt(st.nextToken()), false);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, solve(i, j, 1, new ArrayList<>()));
                result = Math.max(result, etc(i, j));
            }
        }
        System.out.println(result);
    }

    private static int solve(int x, int y, int count, List<Integer> sum) {
        int result = 0;
        arr[x][y].visited = true;
        sum.add(arr[x][y].value);

        if (count == 4) {
            arr[x][y].visited = false;
            return sum.stream().reduce(0, Integer::sum);
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            boolean nextVisited;
            try {
                nextVisited = arr[nextX][nextY].visited;
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }

            if (!nextVisited) {
                result = Math.max(result, solve(nextX, nextY, count + 1, sum));
                sum.remove(sum.size()-1);
            }
        }
        arr[x][y].visited = false;
        return result;
    }

    private static int etc(int x, int y) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                int nextX = x + etcX[i][j];
                int nextY = y + etcY[i][j];

                try {
                    temp += arr[nextX][nextY].value;
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
            sum = Math.max(sum, temp);
        }
        return sum;
    }

    static class Position {
        int x;
        int y;
        int value;
        boolean visited;

        public Position(int x, int y, int value, boolean visited) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.visited = visited;
        }
    }
}
