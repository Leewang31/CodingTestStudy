package programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skillTrees));
    }

    public static int solution(String skill, String[] skillTree) {
        int answer = 0;

        answer = firstSolution(skill, skillTree, answer);
        return answer;

//        List<String> skillTrees = secondSolution(skill, skillTree);
//        return skillTrees.size();
    }

    private static int secondSolution(String skill, String[] skillTree) {
        List<String> skillTrees = new ArrayList<>(Arrays.asList(skillTree));
        skillTrees.removeIf(s -> skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0);
        return skillTrees.size();
    }

    private static int firstSolution(String skill, String[] skillTree, int answer) {
        String pattern = "[^" + skill + "]";

        for (String s : skillTree) {
            s = s.replaceAll(pattern, "");

            if (s.equals("")) {
                answer++;
                continue;
            }

            int beginIndex = skill.indexOf(s.charAt(0));
            if (beginIndex != 0) {
                continue;
            }
            String substring = skill.substring(beginIndex);
            if (substring.contains(s)) {
                answer++;
            }
        }
        return answer;
    }
}
