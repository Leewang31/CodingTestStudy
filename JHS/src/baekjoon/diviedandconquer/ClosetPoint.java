package baekjoon.diviedandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClosetPoint {

    private static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(reader.readLine());
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        System.out.println(solve(0, n - 1));
    }

    private static int solve(int start, int end) {
        if (end - start + 1 <= 3) {
            return calc(start, end);
        }
        int mid = (start + end) / 2;
        int minDistance = Math.min(solve(start, mid), solve(mid + 1, end));

        int middleMinDistance = calcMiddleMinDistance(start, mid, end, minDistance);
        return Math.min(minDistance, middleMinDistance);
    }

    private static int calcMiddleMinDistance(int start, int mid, int end, int minDistance) {
        List<Point> list = getMiddlePoints(start, mid, end, minDistance);
        return getMinDistanceInList(minDistance, list);
    }

    private static List<Point> getMiddlePoints(int start, int mid, int end, int minDistance) {
        List<Point> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int xDist = points[i].x - points[mid].x;

            if (xDist * xDist < minDistance)
                list.add(points[i]);
        }
        list.sort((p1, p2) -> p1.y - p2.y);
        return list;
    }

    private static int getMinDistanceInList(int minDistance, List<Point> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int yDist = list.get(i).y - list.get(j).y;

                if (yDist * yDist > minDistance)
                    break;

                minDistance = Math.min(minDistance, list.get(i).calcDistanceFrom(list.get(j)));
            }
        }
        return minDistance;
    }

    private static int calc(int start, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                min = Math.min(min, points[i].calcDistanceFrom(points[j]));
            }
        }
        return min;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calcDistanceFrom(Point other) {
            return (this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y);
        }
    }
}
