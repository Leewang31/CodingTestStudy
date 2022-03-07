import java.util.Scanner;
import java.util.Vector;

public class BJ15312 {
    public static void main(String[] args) {
        int[] n = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1,
                2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        Vector<Integer> result = new Vector<Integer>();
        Vector<Integer> tp = new Vector<Integer>();

        for (int i = 0; i < A.length(); i++) {
            result.add(n[A.charAt(i) - 'A']);
            result.add(n[B.charAt(i) - 'A']);
        }
        Loop:
        while (true) {
            for (int j = 0; j < result.size() - 1; j++) {
                tp.add((result.get(j) + result.get(j + 1)) % 10);
            }
            result.clear();
            for (int x = 0; x < tp.size(); x++)
                result.add(tp.get(x));
            tp.clear();
            if (result.size() == 2) {
                System.out.println(result.get(0) + "" + result.get(1));
                break Loop;
            }
        }
    }
}