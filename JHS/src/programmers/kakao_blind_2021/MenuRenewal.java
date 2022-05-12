package programmers.kakao_blind_2021;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRenewal {

    private static HashMap<String, Integer> menus;

    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        String[] solution = solution(orders, course);
        for (String s : solution) {
            System.out.println(s);
        }
    }

    private static String[] solution(String[] orders, int[] course) {
        menus = new HashMap<>();

        for (String order : orders) {
            String[] menu = order.split("");

            Arrays.sort(menu);
            for (int i : course) {
                getCombination(menu, new StringBuilder(), i, 0);
            }
        }

        Map<Integer, List<String>> collect = menus.keySet().stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(menus::get, Comparator.reverseOrder())
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.groupingBy(s -> s.length()));

        List<String> result = new ArrayList<>();
        for (int i : collect.keySet()) {
            List<String> strings = collect.get(i);
            int max = menus.get(strings.get(0));
            if (max < 2) {
                continue;
            }
            result.add(strings.get(0));

            for (int j = 1; j < strings.size(); j++) {
                if (menus.get(strings.get(j)) != max) {
                    break;
                }
                result.add(strings.get(j));
            }
        }

        String[] answer = new String[result.size()];
        Object[] objects = result.stream().sorted(Comparator.naturalOrder()).toArray();

        for (int i = 0; i < objects.length; i++) {
            answer[i] = String.valueOf(objects[i]);
        }
        return answer;
    }

    private static void getCombination(String[] menu, StringBuilder sb, int size, int index) {
        if (sb.length() == size) {
            menus.put(sb.toString(), menus.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = index; i < menu.length; i++) {
            sb.append(menu[i]);
            getCombination(menu, sb, size, i + 1);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
