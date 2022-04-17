package programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EndTalk {
    public static void main(String[] args) {
        int n = 5;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] solution = solution(n, words);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char charEnd = words[0].charAt(words[0].length() - 1);
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char charStart = words[i].charAt(0);
            if (list.contains(words[i]) || charEnd != charStart) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            list.add(words[i]);
            charEnd = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }
}
