package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarLesson {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(reader.readLine(), " ");

        int minTime = 0;
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            minTime = Math.max(minTime, arr[i]);
            maxTime += arr[i];
        }

        while (minTime <= maxTime) {
            int mid = (minTime + maxTime) / 2;
            int count = 1;
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i]> mid) {
                    sum = 0;
                    count++;
                }
                sum += arr[i];
            }
            if (count > M) {
                minTime = mid + 1;
            }
            if(count <= M)
                maxTime = mid - 1;
        }

        System.out.println(minTime);
    }
}
