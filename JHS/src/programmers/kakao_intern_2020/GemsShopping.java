package programmers.kakao_intern_2020;

import java.util.HashMap;
import java.util.HashSet;

public class GemsShopping {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] answer = solution(gems);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        for (String s : gems) {
            set.add(s);
        }
        System.out.println(set);

        int distance = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            if (set.size() == map.size()) {
                map.put(gems[left], map.get(gems[left])-1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                map.put(gems[right], map.getOrDefault(gems[right++], 0) + 1);
            }

            System.out.println(map);
            if (set.size() == map.size()) {
                if (right-left < distance){
                    distance = right-left;
                    answer[0] = left+1;
                    answer[1] = right;
                }
            }

        }
        return answer;
    }
}

