package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeConfetti {

    private static int[][] confetti;
    private static int N;
    private static int countZero;
    private static int countOne;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        N = Integer.parseInt(reader.readLine());

        confetti = new int[N][N];
        countZero = 0;
        countOne = 0;

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                confetti[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        solve(0,0, N);

        System.out.println(countZero + "\n" + countOne);
    }

    private static void solve(int x, int y, int arrSize) {
        if (!check(x, y, arrSize)) {
            int dividedSize = arrSize / 2;
            solve(x, y, dividedSize);
            solve(x, y+ dividedSize, dividedSize);
            solve(x+ dividedSize, y, dividedSize);
            solve(x+ dividedSize, y+ dividedSize, dividedSize);
        }
    }

    private static boolean check(int x, int y, int arrSize) {
        int flag = confetti[x][y];

        for (int i = x; i < x+arrSize; i++) {
            for (int j = y; j < y+arrSize; j++) {
                if (confetti[i][j] != flag) {
                    return false;
                }
            }
        }

        if(flag == 1)
            countOne++;
        else
            countZero++;

        return true;
    }
}
