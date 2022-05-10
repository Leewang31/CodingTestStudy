package programmers.kakao_intern_2020;

import java.util.LinkedList;
import java.util.Queue;

public class RaceRoad {
    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {1, 0, -1, 0};
    private static boolean[][][] visited;

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0}
                , {1, 0, 1, 1, 1, 1, 1, 0}
                , {1, 0, 0, 1, 0, 0, 0, 0}
                , {1, 1, 0, 0, 0, 1, 1, 1}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 1, 1, 1, 0}
                , {1, 1, 1, 1, 1, 1, 1, 0}
                , {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int size = board.length;
        int minMoney = Integer.MAX_VALUE;
        visited = new boolean[size][size][4];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, -1, 0));
        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.x == size - 1 && current.y == size - 1) {
                minMoney = Math.min(minMoney, current.money);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + moveX[i];
                int nextY = current.y + moveY[i];

                if (0 <= nextX && nextX < size && 0 <= nextY && nextY < size && board[nextX][nextY] != 1) {
                    int newMoney = current.dir == -1 || current.dir == i ? current.money + 100 : current.money + 600;
                    if (!visited[nextX][nextY][i] || board[nextX][nextY] >= newMoney) {
                        visited[nextX][nextY][i] = true;
                        board[nextX][nextY] = newMoney;
                        queue.add(new Position(nextX, nextY, i, newMoney));
                    }
                }

            }
        }
        return minMoney;
    }

    private static class Position {
        int x;
        int y;
        int dir;
        int money;

        public Position(int x, int y, int dir, int money) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.money = money;
        }
    }
}
