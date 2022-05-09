package programmers.kakao_intern_2020_winter;

import java.util.HashSet;
import java.util.Set;

public class JewelryShopping {
    public static void main(String[] args) {
        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        int [] arr = solution(gems);
        System.out.println(arr[0]+", "+arr[1]);
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int [2];

        Set<String> jewelrySet1 = new HashSet<>();
        Set<String> jewelrySet2 = new HashSet<>();
        for (String gem : gems) {
            jewelrySet1.add(gem);
            jewelrySet2.add(gem);
        }
        for (int i = 0; i < gems.length; i++) {
            if (!jewelrySet1.isEmpty()) {
                jewelrySet1.remove(gems[i]);
            }
            if (jewelrySet1.isEmpty()) {
                answer[1] = i+1;
                break;
            }
        }
        for (int i = answer[1]-1; i >= 0; i--) {
            if (!jewelrySet2.isEmpty()) {
                if (jewelrySet2.contains(gems[i])) {
                    jewelrySet2.remove(gems[i]);
                }
            }
            if (jewelrySet2.isEmpty()) {
                answer[0] = i+1;
                break;
            }
        }
        return answer;
    }

}

//실패