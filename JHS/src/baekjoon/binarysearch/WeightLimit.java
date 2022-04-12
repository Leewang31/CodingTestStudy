package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WeightLimit {

    private static int maxWeight;
    private static List<List<Factory>> factories;
    static boolean[] visited;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        factories = new ArrayList<>();
        visited = new boolean[N + 1];
        for(int i = 0 ; i <= N ; i++) {
            factories.add(new ArrayList<>());
        }

        maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int myNum = Integer.parseInt(st.nextToken());
            int oppositeNum = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            factories.get(myNum).add(new Factory(oppositeNum, weight));
            factories.get(oppositeNum).add(new Factory(myNum, weight));
            maxWeight = Math.max(maxWeight, weight);
        }

        st = new StringTokenizer(reader.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        solve(from, to);
    }

    private static void solve(int from, int to) {
        long start = 1;
        long end = maxWeight;
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (search(from, to, mid)) {
                start = mid + 1;
                answer = Math.max(mid, answer);
            } else
                end = mid - 1;
        }
        System.out.println(answer);
    }

    private static boolean search(int from, int to, long mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.clear();
        for (int i = 0; i <= N; i++) {
            visited[i] = false;
        }
        visited[from] = true;
        queue.add(from);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == to) {
                return true;
            }

            for (Factory factory : factories.get(current)) {
                if (factory.weight >= mid && !visited[factory.oppositeNum]) {
                    visited[factory.oppositeNum] = true;
                    queue.add(factory.oppositeNum);
                }
            }
        }
        return false;
    }

    static class Factory {
        int oppositeNum;
        int weight;

        public Factory(int oppositeNum, int weight) {
            this.oppositeNum = oppositeNum;
            this.weight = weight;
        }
    }
}
