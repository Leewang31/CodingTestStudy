package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargeNumberComposition {

    private static int[] arr;
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(arr);
        System.out.println(makeLargeNumber(0, 0));

    }

    private static void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
    }

    private static int makeLargeNumber(int current, int result) {
        if (current > N) {
            return result;
        }

        for (int i = 0; i < arr.length; i++) {
            result = Math.max(current, makeLargeNumber(current * 10 + arr[i], result));
        }
        return result;
    }
}
