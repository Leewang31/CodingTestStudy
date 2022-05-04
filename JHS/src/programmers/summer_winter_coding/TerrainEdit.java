package programmers.summer_winter_coding;

import java.util.Arrays;

public class TerrainEdit {
    private static int pValue;
    private static int qValue;

    public static void main(String[] args) {
        int[][] land = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
        int P = 5;
        int Q = 3;

        System.out.println(solution(land, P, Q));
    }

    private static long solution(int[][] land, int P, int Q) {
        pValue = P;
        qValue = Q;

        long start = land[0][0];
        long end = land[0][0];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                start = Math.min(start, land[i][j]);
                end = Math.max(end, land[i][j]);
            }
        }

        return solve(land, start, end);
    }

    private static long solve(int[][] land, long start, long end) {
        /*if (start == end) {
            return calculation(land, start);
        }

        long mid = (start + end) / 2;

        long leftCal = calculation(land, mid);
        long rightCal = calculation(land, mid+1);

        long min = Math.min(leftCal, rightCal);
        if (leftCal < rightCal) {
            end = mid - 1;
        } else if (leftCal > rightCal) {
            start = mid + 1;
        }

        return Math.min(min, solve(land, start, end));*/

        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            long leftCalc = calculation(land, mid);
            long rightCalc = calculation(land, mid+1);

            if (leftCalc <= rightCalc) {
                answer = leftCalc;
                end = mid - 1;
            } else {
                answer = rightCalc;
                start = mid + 1;
            }
        }
        return answer;
    }

    private static long calculation(int[][] land, long mid) {
        long result = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] > mid) {
                    result += (land[i][j] - mid) * qValue;
                }
                if (land[i][j] < mid) {
                    result += (mid - land[i][j]) * pValue;
                }
            }
        }
        return result;
    }
}
