package backjoon.four;
import java.util.ArrayList;
import java.util.Scanner;

public class Thue_Morse_sequence {
    public static ArrayList<Integer> thue_Morse;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        thue_Morse= new ArrayList<>(n+1);
        sort(thue_Morse,n);

    }
    public static void sort(ArrayList<Integer> list, int size){
        list.add(0);
        list.add(1);
        ArrayList<Integer> tmp=new ArrayList<Integer>(size+1);



            for (int i = 2; i <size; i++) {
                tmp.clear();
                try {
                    if (list.get(i) == 0) {
                        for (int j = 2; j <size; j++) {
                            tmp.add(list.get(j) ^ list.get(j));
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
                if (list.get(i) == 1)
                    list.addAll(tmp);
            }

            System.out.println(list.get(size - 1));
        }
    }

