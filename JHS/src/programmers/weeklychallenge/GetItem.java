package programmers.weeklychallenge;

import java.util.LinkedList;
import java.util.Queue;

public class GetItem {
    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 3, 7}, {2, 2, 7, 4}, {4, 3, 6, 6}};
        int characterX = 1;
        int characterY = 2;
        int itemX = 6;
        int itemY = 6;

        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};
    private static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;

        int[][] map = new int[21][21];
        boolean[][] visited = new boolean[21][21];
        for (int[] point : rectangle) {
            fillMap(map, point);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(characterX*2);
        queue.add(characterY*2);
        visited[characterX*2][characterY*2] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];
                try {
                    if (map[nextX][nextY] != 1 || visited[nextX][nextY]) {
                        continue;
                    }
                    map[nextX][nextY] = map[x][y] + 1;
                    if (nextX == itemX*2 && nextY == itemY*2) {
                        answer = Math.min(answer, map[nextX][nextY]);
                    }
                    queue.add(nextX);
                    queue.add(nextY);
                    visited[nextX][nextY] = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        return answer/2;
    }

    private static void fillMap(int[][] map, int[] point) {
        for (int i = point[0]*2; i <= point[2]*2; i++) {
            for (int j = point[1]*2; j <= point[3]*2; j++) {
                if (map[i][j] == 2) {
                    continue;
                }
                map[i][j] = 2;
                if (i == point[0]*2 || i == point[2]*2 || j == point[1]*2 || j == point[3]*2) {
                    map[i][j] = 1;
                }
            }
        }
    }
}
