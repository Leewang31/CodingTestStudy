package programmers.kakao_blind_2021;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] order = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        System.out.println(Arrays.toString(solution(order, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = i + 1; j < orders.length; j++) {
                String str = union(orders[i], orders[j]);
                if (lengthCheck(str, course)) {
                    set.add(str);
                }
            }
        }

        String[] answer = new String[set.size()];
        answer = set.toArray(answer);
        Arrays.sort(answer);
        return answer;
    }

    public static String union(String str1, String str2) {
        String result = "";
        String[] word1 = str1.split("");
        String[] word2 = str2.split("");
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        for (int i = 0; i < word1.length; i++) {
            arr1.add(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            arr2.add(word2[i]);
        }
        arr1.retainAll(arr2);
        for (int i = 0; i < arr1.size(); i++) {
            result += arr1.get(i);
        }
        return result;
    }

    public static boolean lengthCheck(String str, int[] course) {
        for (int i = 0; i < course.length; i++) {
            if (str.length() == course[i]) {
                return true;
            }
        }
        return false;
    }
}
