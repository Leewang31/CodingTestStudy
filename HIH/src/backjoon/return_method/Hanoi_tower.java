package backjoon.return_method;
import java.util.Scanner;
import java.util.Stack;
/*본인 생각
* 사실 재귀로 풀어야 하나 고민했음
* 단순 while문을 통하여 해당 조건이 만족되면 종료 하려함
* 규칙을 메모장에 정리하며 코딩 했지만 구현을 못했음.
* A에서 B로 원판을 이동하는 경우, B에서 A로 원판을 이동하는 경우,
* c에서 A로 이동하는경우 각각 의 상황들을 메모장에 기재하였지만
* 시간이 부족해서 일단 올림 이부분 개선 후 풀리퀘 다시 줄 예정
*  */
public class Hanoi_tower {
    public static int[] cnt_Arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        Stack<Integer> stack_Array;
        n= sc.nextInt();
        stack_Array=new Stack<Integer>();

    }
    public static void return_Method(Stack<Integer> stack,int size){
        cnt_Arr=new int[size];
        Stack<Integer> two=new Stack<>();
        Stack<Integer> three=new Stack<>();
        if(stack==null) return;
        for(int i=0;i<size;i++){
            stack.push(i);
        }
        /*한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
          쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.

          공식 2^n-1
          2^5n-1==31
          */
        while(three.size()!=size){
            if(three.firstElement()>stack.firstElement()||three.empty()) {
                three.push(stack.pop());
            }}

    }
    public static int find_Min(Stack<Integer> stack,int size){
        int min=9999;
        stack=new Stack<Integer>();
        for(int i=0;i<size;i++){
            if(stack.get(i) <min) min=stack.get(i);
        }
        return min;
    }
}
/*한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.*/