package backjoon.return_method;
import  java.util.Scanner;
/*Ez*/
public class Big_num {
    public static int cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int big_Num;
        int num_Array[];
        int size;
        big_Num=sc.nextInt();
        size=sc.nextInt();
        num_Array=new int[size];
        for(int i=0;i<size;i++){
            num_Array[i]=sc.nextInt();
        }
       find_BigNum(num_Array,big_Num,size);
    }
    public static void find_BigNum(int Array[],int first, int size){
        int num;
        first=first/100;
        //System.out.println("first: "+first);
        //System.out.println("cnt : "+cnt);
        if (cnt==size) return;
        num=Array[0];
        for(int i=0; i<size;i++){
            if(cnt==0){
                for(int j=0;j<size;j++){
                    if(num<first&&Array[i]<first)
                        num=Array[i];
                }
            }
            else if(num<Array[i]&&cnt>0) num=Array[i];
        }
        System.out.print(num);
        cnt++;
        find_BigNum(Array,first,size);
    }
}
