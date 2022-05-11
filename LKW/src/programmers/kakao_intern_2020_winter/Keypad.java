package programmers.kakao_intern_2020_winter;

public class Keypad {
    public static int[] leftPoint= {3,0};
    public static int[] rightPoint= {3,2};
    public static int [][] keyPad = {
            {3,1},
            {0,0},{0,1},{0,2},
            {1,0},{1,1},{1,2},
            {2,0},{2,1},{2,2},
            {3,0},{3,2}
    };
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer ="";
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7){
                leftPoint = keyPad[number];
                answer += "L";
            }
            else if (number == 3 || number == 6 || number == 9){
                rightPoint = keyPad[number];
                answer += "R";
            }
            else {
                int leftHand = Math.abs(leftPoint[0] - keyPad[number][0]) + Math.abs(leftPoint[1] - keyPad[number][1]);
                int rightHand = Math.abs(rightPoint[0] - keyPad[number][0]) + Math.abs(rightPoint[1] - keyPad[number][1]);
                if(leftHand<rightHand){
                    leftPoint = keyPad[number];
                    answer += "L";
                }
                else if(leftHand > rightHand){
                    rightPoint = keyPad[number];
                    answer += "R";
                }
                else {
                    if(hand.equals("right")){
                        rightPoint = keyPad[number];
                        answer += "R";
                    }
                    else{
                        leftPoint = keyPad[number];
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }
}
/*package kakao_intern_2020_winter;

public class Keypad {
    private static int pointLx = 0;
    private static int pointLy = 3;
    private static int pointRx = 2;
    private static int pointRy = 3;

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(Solution(numbers, hand));
    }

    public static String Solution(int[] numbers, String hand) {
        String answer = "";
        for (int number : numbers) {
            if (number == 0){
                int pointNewX = 1;
                int pointNewY = 3;
                answer += Distance(pointNewX, pointNewY, hand);
            }
            else if (number % 3 == 1) {
                answer += "L";
                pointLx = 0;
                pointLy = (number - 1) / 3;
            } else if (number % 3 == 0) {
                answer += "R";
                pointRx = 2;
                pointRy = (number - 1) / 3;
            } else {
                int pointNewX = 1;
                int pointNewY= (number - 2) / 3;
                answer += Distance(pointNewX, pointNewY, hand);
            }
            System.out.println(number+" "+pointLx+" "+pointLy+" "+pointRx+" "+pointRy);
        }
        return answer;

    }

    private static String Distance(int newX, int newY, String hand) {
        double distanceL = Math.pow(pointLx - newX, 2) + Math.pow(pointLy - newY, 2);
        double distanceR = Math.pow(pointRx - newX, 2) + Math.pow(pointRy - newY, 2);
        if (distanceR > distanceL) {
            pointLx = newX;
            pointLy = newY;
            return "L";
        } else if (distanceL > distanceR) {
            pointRx = newX;
            pointRy = newY;
            return "R";
        } else {
            if (hand == "right") {
                pointRx = newX;
                pointRy = newY;
                return "R";
            } else {
                pointLx = newX;
                pointLy = newY;
                return "L";
            }
        }
    }
}*/
