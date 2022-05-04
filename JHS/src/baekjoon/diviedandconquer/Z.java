package baekjoon.diviedandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {

    private static int r;
    private static int c;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(0, 0, (int) Math.pow(2, N));
    }

    private static void solve(int x, int y, int size) {
        if (x == r && y == c) {
            System.out.println(result);
            System.exit(0);
        }
        if (size == 1) {
            result += 1;
            return;
        }
        if (x <= r && r <= x + size && y <= c && c <= y + size) {
            int newSize = size / 2;
            solve(x, y, newSize);
            solve(x, y + newSize, newSize);
            solve(x + newSize, y, newSize);
            solve(x + newSize, y + newSize, newSize);
        } else {
            result += size * size;
        }
    }
}
