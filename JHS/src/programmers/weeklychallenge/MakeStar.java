package programmers.weeklychallenge;

import java.util.ArrayList;
import java.util.List;

public class MakeStar {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] answer = solution(line);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];

            for (int j = i+1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long xNumerator = (B * F) - (E * D);
                long yNumerator = (E * C) - (A * F);
                long denominator = ((A * D) - (B * C));

                if (denominator != 0) {
                    double crossX = xNumerator / (double) denominator;
                    double crossY = yNumerator / (double) denominator;

                    if (isInt(crossX) && isInt(crossY)) {
                        list.add(new long[]{(long) crossX, (long) crossY});
                        minX = Math.min(minX, (long) crossX);
                        maxX = Math.max(maxX, (long) crossX);
                        minY = Math.min(minY, (long) crossY);
                        maxY = Math.max(maxY, (long) crossY);
                    }
                }
            }
        }

        String[] answer = new String[(int) (maxY - minY + 1)];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ".".repeat((int) (maxX - minX + 1));
        }

        for (long[] point : list) {
            long x = point[0];
            long y = point[1];

            answer[(int) (maxY - y)] = answer[(int) (maxY - y)].substring(0, (int) (x - minX))
                    + "*" + answer[(int) (maxY - y)].substring((int) (x - minX) + 1);
        }
        return answer;
    }

    private static boolean isInt(double number) {
        return number == Math.ceil(number);
    }
}
