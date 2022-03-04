package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NameCompatibility {
    public static void main(String[] args) {
        int[] strokesNum = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            sb.append(A.charAt(i));
            sb.append(B.charAt(i));
        }

        char[] totalName = sb.toString().toCharArray();
        int[] totalNameStrokes = new int[sb.length()];

        IntStream.range(0, sb.length())
                .forEach(i -> totalNameStrokes[i] = strokesNum[totalName[i] - 'A']);

        for (int i = sb.length(); i > 2; i--) {
            for (int j = 0; j < i-1; j++) {
                totalNameStrokes[j] += totalNameStrokes[j + 1];
                totalNameStrokes[j] %= 10;
            }
        }

        sb.setLength(0);
        String result = sb.append(totalNameStrokes[0]).append(totalNameStrokes[1]).toString();
        System.out.println("result = " + result);
    }
}
