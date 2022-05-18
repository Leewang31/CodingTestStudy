package programmers.kakao_blind_2021;

public class SharedTaxiFare {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {
                {4, 1, 10}, {3, 5, 24},
                {5, 6, 2}, {3, 1, 41},
                {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22},
                {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int MAX = Integer.MAX_VALUE;
        int[][] earlyPay = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    earlyPay[i][j] = 0;
                    continue;
                }
                earlyPay[i][j] = MAX;
            }
        }//최대값으로 초기화

        for (int i = 0; i < fares.length; i++) {
            earlyPay[fares[i][0]][fares[i][1]] = fares[i][2];
            earlyPay[fares[i][1]][fares[i][0]] = fares[i][2];
        }//한방에 가는 경우 값 저장

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (earlyPay[i][k] == MAX || earlyPay[k][j] == MAX) {
                        continue;
                    }
                    earlyPay[i][j] = Math.min(earlyPay[i][k] + earlyPay[k][j], earlyPay[i][j]);
                }
            }
        }//경유하는 경우의 최소값

        int minPay;
        if (earlyPay[s][a] == MAX || earlyPay[s][b] == MAX) {
            minPay = MAX;
        } else {
            minPay = earlyPay[s][a] + earlyPay[s][b];
        }
        for (int i = 1; i < n + 1; i++) {
            if (earlyPay[s][i] == MAX || earlyPay[i][a] == MAX || earlyPay[i][b] == MAX) {
                continue;
            }
            minPay = Math.min(earlyPay[s][i] + earlyPay[i][a] + earlyPay[i][b], minPay);
        }//같이 안가는 경우와 i위치 까지 같이간 경우와 비교해서 최소금액

        return minPay;
    }
}
