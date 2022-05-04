package backjoon.programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Budget {
    public static int size;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> d;
        int budget;
        size=sc.nextInt();
        d=new ArrayList<Integer>(size);
        budget = sc.nextInt();

        for(int i=0;i<size;i++) {
            d.add(sc.nextInt());
        }
        System.out.println(solution(d,budget));
    }
    public static int solution(ArrayList<Integer>d,int budget){
        int cnt=0;
        Collections.sort(d);
        for(int i=0;i<size;i++){
            try{
            budget-=d.get(i);
            cnt++;
            if(budget<d.get(i+1)) break;
            }catch (IndexOutOfBoundsException e){
                continue;
            }

        }
        return cnt;
    }

}
