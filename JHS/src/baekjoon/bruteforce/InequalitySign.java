package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InequalitySign {

    private static StringBuilder sb;
    private static int k;
    private static String[] sign;
    private static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = null;
        result = new ArrayList<>();

        k = Integer.parseInt(reader.readLine());
        sign = new String[k];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken();
        }
        solve(new ArrayList<>(), 0);
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));

    }

    private static void solve(List<String> list, int signIndex) {
        if (signIndex == k) {
            String temp = "";
            for (String s : list) {
                temp += s;
            }
            result.add(temp);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (list.contains(String.valueOf(i))) {
                continue;
            }
            if (list.size() == 0) {
                list.add(String.valueOf(i));
                solve(list, signIndex);
                list.remove(String.valueOf(i));
                continue;
            }
            if (check(list.get(list.size()-1), String.valueOf(i), sign[signIndex])) {
                list.add(String.valueOf(i));
                solve(list, signIndex + 1);
                list.remove(String.valueOf(i));
            }
        }
    }
    private static boolean check(String originalNum, String addNum, String sign) {
        if (sign.equals("<")) {
            if (originalNum.compareTo(addNum) > 0) {
                return false;
            }
        }
        if (sign.equals(">")) {
            if (originalNum.compareTo(addNum) < 0) {
                return false;
            }
        }
        return true;
    }
}
