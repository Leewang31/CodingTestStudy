package programmers.weekly;

import java.util.ArrayList;
import java.util.List;

public class MeetStar {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] result = solution(line);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> list = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long down = a * d - b * c;

                if (down != 0) {
                    long upX = b * f - e * d;
                    long upY = e * c - a * f;
                    if (upX % down != 0 || upY % down != 0) {
                        continue;
                    }
                    long x = upX / down;
                    long y = upY / down;

                    list.add(new long[]{x, y});
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);

                }


            }
        }

        boolean[][] temp = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (long[] ints : list) {
            int x = (int) (ints[0] - minX);
            int y = (int) (ints[1] - maxY);

            temp[Math.abs(y)][Math.abs(x)] = true;
        }

        answer = new String[temp.length];

        int i = 0;
        for (boolean[] bs : temp) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : bs) {
                if (b) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[i] = sb.toString();
            i++;
        }

        return answer;
    }

}