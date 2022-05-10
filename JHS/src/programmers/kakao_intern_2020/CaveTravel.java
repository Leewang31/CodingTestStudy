package programmers.kakao_intern_2020;

import java.util.*;

public class CaveTravel {
    public static void main(String[] args) {
        int n = 9;
        int[][] path = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
        int[][] order = {{8, 5}, {6, 7}, {4, 1}};
        System.out.println(solution(n, path, order));
    }

    private static boolean solution(int n, int[][] path, int[][] order) {
        List<List<Integer>> cave = new ArrayList<>();
        int[] priority = new int[n];
        int[] save = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            cave.add(new ArrayList<>());
        }

        for (int[] caves : path) {
            cave.get(caves[0]).add(caves[1]);
            cave.get(caves[1]).add(caves[0]);
        }

        for (int[] ints : order) {
            priority[ints[1]] = ints[0];
        }

        if (priority[0] != 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        for (Integer linkedCave : cave.get(0)) {
            queue.add(linkedCave);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue);
            int current = queue.poll();

            if (visited[current]) {
                continue;
            }

            if (!visited[priority[current]]) {
                save[priority[current]] = current;
                continue;
            }

            visited[current] = true;
            for (Integer linkedCave : cave.get(current)) {
                if (!visited[linkedCave]) {
                    queue.add(linkedCave);
                }
            }

            queue.add(save[current]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
