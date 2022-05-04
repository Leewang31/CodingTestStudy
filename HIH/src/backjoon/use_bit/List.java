package backjoon.use_bit;
import java.lang.reflect.Array;
import java.util.Scanner;
public class List {
    public static int[] Array;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n;
        int x;
        String s;
        n=sc.nextInt();
        Array=new int[20];
        for(int i=0;i<=n;i++){
            s=sc.next();
            switch (s){
                case "add" : {
                    x=sc.nextInt();
                    add(x);
                    break;
                }
                case "remove":{
                    x=sc.nextInt();
                    remove(x);
                    break;
                }
                case "check":{
                    x= sc.nextInt();
                    check(x);
                    break;
                }
                case "toggle":{
                    x= sc.nextInt();
                    toggle(x);
                    break;
                }
                case "all":{
                    all();
                    break;
                }
                case "empty":{
                    empty();
                    break;
                }
                default: continue;
            }
        }


    }
    public static void add(int x){
        for(int i=0;i<Array.length;i++){
            if(Array[i]==0) Array[i]=x;
        }
    }
    public static void remove(int x){
        for(int i=0;i<Array.length;i++){
            if(Array[i]==x)Array[i]=0;
        }
    }
    public static void check(int x){
        for (int i=0;i<Array.length;i++){
            if(Array[i]==x) {
                System.out.println('1');
                break;
            }
            else if(i==Array.length-1) {
                System.out.println('0');
                break;
            }
        }
    }
    public static void toggle(int x){
        int check=0;

        for(int i=0;i<Array.length;i++){
            if(Array[i]==x&&Array[i]!=0) {
                Array[i]=0;
            }
            else if(i==Array.length-1) check++;
        }
        if(check==1){
            for(int i=0;i<Array.length;i++){
                if(Array[i]==0){
                    Array[i]=x;
                    break;
                }
            }
        }
    }
    public static void all(){
        for (int i=0;i<20;i++){
            Array[i]=i+1;
        }
    }
    public static void empty(){
        for(int i=0;i<Array.length;i++){
            Array[i]=0;
        }
    }

}
