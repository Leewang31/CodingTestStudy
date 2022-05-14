package programmers.kakao_blind_2021;

import java.util.*;

import static java.util.Comparator.*;

public class TaxiFare {

    private static List<List<Edge>> fareList;

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {{4, 1, 10}
                , {3, 5, 24}
                , {5, 6, 2}
                , {3, 1, 41}
                , {5, 1, 24}
                , {4, 6, 50}
                , {2, 4, 66}
                , {2, 3, 22}
                , {1, 6, 25}};

        int[][] fares1 = {{5, 7, 9}
                , {4, 6, 4}
                , {3, 6, 1}
                , {3, 2, 3}
                , {2, 1, 6}};

        int[][] fares2 = {{2, 6, 6}
                , {6, 3, 7}
                , {4, 6, 7}
                , {6, 5, 11}
                , {2, 5, 12}
                , {5, 3, 20}
                , {2, 4, 8}
                , {4, 3, 9}};
        System.out.println(solution(n, s, a, b, fares2));
    }

    private static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        fareList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            fareList.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            fareList.get(fare[0]).add(new Edge(fare[1], fare[2]));
            fareList.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }

        int[] fareS = getFare(n, s);
        int[] fareA = getFare(n, a);
        int[] fareB = getFare(n, b);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, fareS[i] + fareA[i] + fareB[i]);
        }
        return answer;
    }

    private static int[] getFare(int count, int start) {
        int[] result = new int[count + 1];

        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>(comparingInt(Edge::getFare));
        pq.add(new Edge(start, 0));
        result[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.fare > result[current.number]) {
                continue;
            }
            for (Edge edge : fareList.get(current.number)) {
                if (edge.fare + result[current.number] < result[edge.number]) {
                    result[edge.number] = edge.fare + result[current.number];
                    pq.add(new Edge(edge.number, result[edge.number]));
                }
            }

        }
        return result;
    }

    private static class Edge {
        int number;
        int fare;

        public Edge(int number, int fare) {
            this.number = number;
            this.fare = fare;
        }

        public int getFare() {
            return fare;
        }
    }
}
