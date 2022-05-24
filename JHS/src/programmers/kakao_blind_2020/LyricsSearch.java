package programmers.kakao_blind_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LyricsSearch {
    static HashMap<String, Integer> map;
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] solution = solution1(words, queries);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution1(String[] words, String[] queries) {
        Trie front = new Trie();
        Trie back = new Trie();

        for (String word : words) {
            System.out.println(word);
            front.insert(word);
            back.insert(reverse(word));
        }

        for (Trie trie : front.child) {
            System.out.println(trie);
        }
        return Arrays.stream(queries).mapToInt(
                query -> query.charAt(0) == '?' ?
                        back.find(reverse(query), 0) :
                        front.find(query, 0)).toArray();
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static class Trie {
        Map<Integer, Integer> lenMap = new HashMap<>();
        Trie[] child = new Trie[26];

        void insert(String str) {
            Trie node = this;
            int len = str.length();
            lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';
                if (node.child[idx] == null)
                    node.child[idx] = new Trie();

                node = node.child[idx];
                node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
            }
        }

        int find(String str, int i) {
            if (str.charAt(i) == '?')
                return lenMap.getOrDefault(str.length(), 0);

            int idx = str.charAt(i) - 'a';
            return child[idx] == null ? 0 : child[idx].find(str, i + 1);
        }

    }

    private static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        map = new HashMap<>();
        for (String word : words) {
            getCombination(word.split(""), "", 0);
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = map.getOrDefault(queries[i], 0);
        }
        return answer;
    }

    private static void getCombination(String[] word, String sb, int count) {
        if (count == word.length) {
            map.put(sb, map.getOrDefault(sb, 0) + 1);
            return;
        }
        getCombination(word, sb + word[count], count + 1);
        getCombination(word, sb + "?", count + 1);
    }
}
