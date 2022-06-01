package programmers.weekly;

public class Network {
    static int[][] Graph = new int[101][101];

    public static void main(String[] args) {
        int n = 9;
        int wires[][] = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(n, wires));
    }

    private static int solution(int n, int[][] wires) {
        int answer = -1;
        int[][] Graph = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            Graph[wires[i][0]][wires[i][1]] = 1;
            Graph[wires[i][1]][wires[i][0]] = 1;
        }
        for (int i = 0; i < wires.length; i++) {

            Graph[wires[i][0]][wires[i][1]] = 0;
            Graph[wires[i][1]][wires[i][0]] = 0;

            boolean[] Check = new boolean[n];
            int cnt = 1;
            answer = Math.max(answer, Math.abs(n - dfs(Check, n, cnt, 1)));
            System.out.println("i : " + i + ", answer : " + answer);

            Graph[wires[i][0]][wires[i][1]] = 1;
            Graph[wires[i][1]][wires[i][0]] = 1;
        }

        return answer;
    }

    private static int dfs(boolean[] Check, int n, int cnt, int node) {
        Check[node] = true;
        for (int next = 0; next < n + 1; next++) {
            if (!Check[next] && Graph[node][next] != 0) {
                cnt = Math.max(dfs(Check, n, cnt++, next), cnt);
            }
        }
        return cnt;
    }
}