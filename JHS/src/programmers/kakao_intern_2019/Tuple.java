package programmers.kakao_intern_2019;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        int[] solution = solution(s);
//        for (int integer : solution) {
//            System.out.print(integer + ", ");
//        }

//        solution1(s);
        solution2(s);
    }

    private static int[] solution(String s) {
        String[] splits = s.substring(1, s.length() - 2).split("},");
        Arrays.sort(splits,(o1, o2) -> o1.length() - o2.length());

        List<Integer> answer = new ArrayList<>();

        for (String split : splits) {
            split = split.replace("{", "");
            System.out.println(split);

            String[] split2 = split.split(",");

            for (String s1 : split2) {
                if(!answer.contains(Integer.valueOf(s1)))
                    answer.add(Integer.valueOf(s1));
            }
        }
        return answer.stream().mapToInt(value -> value).toArray();
    }

    public static int[] solution1(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        for (String s1 : arr) {
            System.out.println(s1);
        }
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static int[] solution2(String s) {

        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.toString());
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
}
