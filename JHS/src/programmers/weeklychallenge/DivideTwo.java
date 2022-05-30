package programmers.weeklychallenge;

import java.util.*;

public class DivideTwo {

    private static List<List<Integer>> powerList;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(n, wires));
    }

    private static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        powerList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            powerList.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            powerList.get(wire[0]).add(wire[1]);
            powerList.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            powerList.get(wire[0]).remove((Integer)wire[1]);
            powerList.get(wire[1]).remove((Integer)wire[0]);

            answer = Math.min(answer, Math.abs(n-divide(new boolean[n + 1])*2));

            powerList.get(wire[0]).add(wire[1]);
            powerList.get(wire[1]).add(wire[0]);
        }
        return answer;
    }

    private static int divide(boolean[] visited) {
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            count++;
            Integer current = queue.poll();
            List<Integer> linkedNode = powerList.get(current);

            for (Integer node : linkedNode) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

        return count;
    }
}
