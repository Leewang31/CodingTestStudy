package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star {

    private static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int length = (int) Math.pow(2, N);
        arr = new String[length][length];
        printStar(0, 0, length);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (j == length-i) {
                    break;
                }
                sb.append(arr[i][j] == null ? " " : "*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void printStar(int x, int y, int round) {
        if (round == 1) {
            arr[x][y] = "*";
            return;
        }

        printStar(x, y, round/2);
        printStar(x + round/2, y, round/2);
        printStar(x, y + round/2, round/2);
    }
}
