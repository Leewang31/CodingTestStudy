package programmers.summer_winter_coding_2018;

public class EndTalk {
    public static void main(String[] args) {
        int n = 3;
        String words[] = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int solution[] = solution(n, words);
        for (int i = 0; i < 2; i++)
            System.out.print(solution[i] + " ");
    }

    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i] == words[j]) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    return answer;
                }
            }
            char last = words[i-1].charAt(words[i-1].length() - 1);
            char first = words[i].charAt(0);
            if (first != last) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}