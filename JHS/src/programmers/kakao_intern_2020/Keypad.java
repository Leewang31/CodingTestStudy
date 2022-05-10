package programmers.kakao_intern_2020;

import java.util.HashMap;

public class Keypad {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        HashMap<Integer, Integer> position = new HashMap<>();
        position.put(1, 0);
        position.put(2, 0);
        position.put(3, 0);
        position.put(4, 1);
        position.put(5, 1);
        position.put(6, 1);
        position.put(7, 2);
        position.put(8, 2);
        position.put(9, 2);
        position.put(0, 3);

        int leftPosition = 3;
        int rightPosition = 3;

        boolean leftMiddle = false;
        boolean rightMiddle = false;

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            switch (number) {
                case 1: case 4: case 7:
                    sb.append("L");
                    leftPosition = position.get(number);
                    leftMiddle = false;
                    break;
                case 3: case 6: case 9:
                    sb.append("R");
                    rightPosition = position.get(number);
                    rightMiddle = false;
                    break;
                default:
                    int newLeftPosition = Math.abs(leftPosition - position.get(number)) + ((leftMiddle)?0:1);
                    int newRightPosition = Math.abs(rightPosition - position.get(number)) + ((rightMiddle)?0:1);
                    if (newLeftPosition < newRightPosition) {
                        sb.append("L");
                        leftPosition = position.get(number);
                        leftMiddle = true;
                    } else if (newLeftPosition > newRightPosition) {
                        sb.append("R");
                        rightPosition = position.get(number);
                        rightMiddle = true;
                    } else {
                        if (hand.equals("right")) {
                            rightPosition = position.get(number);
                            rightMiddle = true;
                            sb.append("R");
                        } else {
                            leftPosition = position.get(number);
                            leftMiddle = true;
                            sb.append("L");
                        }
                    }
                    break;
            }
        }
        return sb.toString();
    }
}
