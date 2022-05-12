package programmers.kakao_blind_2021;

import java.util.*;

public class RankingSearch {

    private static HashMap<String, List<Integer>> map;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150"
                       , "python frontend senior chicken 210"
                       , "python frontend senior chicken 150"
                       , "cpp backend senior pizza 260"
                       , "java backend junior chicken 80"
                       , "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100"
                        , "python and frontend and senior and chicken 200"
                        , "cpp and - and senior and pizza 250"
                        , "- and backend and senior and - 150"
                        , "- and - and - and chicken 100"
                        , "- and - and - and - 150"};

        int[] result = solution(info, query);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int index = 0;
        map = new HashMap<>();
        for (String s : info) {
            getCombination(s.split(" "), "", 0);
        }

        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }
        for (String s : query) {
            String[] split = s.replace(" and ", "").split(" ");
            answer[index++] = map.containsKey(split[0]) ? counting(map.get(split[0]), Integer.parseInt(split[1])) : 0;
        }
        return answer;
    }

    private static int counting(List<Integer> scores, int score) {
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid -  1;
            }
        }
        return scores.size() - start;
    }

    private static void getCombination(String[] info, String sb, int size) {
        if (size == 4) {
            if (!map.containsKey(sb)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(sb, list);
            }
            map.get(sb).add(Integer.valueOf(info[size]));
            return;
        }

        getCombination(info, sb + "-", size + 1);
        getCombination(info, sb + info[size], size+1);
    }
}
