package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Canoe {

    private static int[][] weight;
    private static int T;
    private static int k;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            weight = new int[4][n];
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(reader.readLine(), " ");
                for (int l = 0; l < n; l++) {
                    weight[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(solve() + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int solve() {
        int[] sum1 = new int[n * n];
        int[] sum2 = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1[i * n + j] = weight[0][i] + weight[1][j];
                sum2[i * n + j] = weight[2][i] + weight[3][j];
            }
        }

        Arrays.sort(sum1);
        Arrays.sort(sum2);

        System.out.println();
        int index1 = 0;
        int index2 = n * n - 1;

        int min = Integer.MAX_VALUE;
        int answer = 0;
        while (index1 < n * n && index2 >= 0) {
            int sum = sum1[index1] + sum2[index2];

            if (sum != k) {
                int abs = Math.abs(sum - k);
                if (min > abs) {
                    min = abs;
                    answer = sum;
                } else if (min == abs) {
                    answer = Math.min(answer, sum);
                }
                if (sum < k) {
                    index1++;
                } else if (sum > k) {
                    index2--;
                }
            } else {
                answer = sum;
                break;
            }
        }
        return answer;
    }
}
