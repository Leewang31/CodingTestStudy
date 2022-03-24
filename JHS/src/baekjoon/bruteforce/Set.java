package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Set {

    private static int flag;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = null;
        int M  = Integer.parseInt(reader.readLine());
        flag = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");

            String calc = st.nextToken();
            int number = 0;
            if(st.hasMoreTokens())
                number = Integer.parseInt(st.nextToken());
            System.out.println(i+1 + "번째 calc = " + calc + " ,number = " + number);
            calculation(calc, number);
        }
        System.out.println(sb);
    }

    private static void calculation(String calc, int number) {
        switch (calc) {
            case "add":
                flag |= 1<<(number-1);
                break;
            case "remove":
                flag &= ~(1<<(number-1));
                break;
            case "check":
                sb.append((flag & 1<<(number-1)) == 0 ? 0+"\n" : 1+"\n");
                break;
            case "toggle":
                flag ^= 1<<(number-1);
                break;
            case "all":
                flag = ~0;
                break;
            case "empty":
                flag = 0;
                break;

        }
    }
}
