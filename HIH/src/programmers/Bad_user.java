package programmers;
import java.util.ArrayList;
import java.util.Scanner;
public class Bad_user {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<String> users=new ArrayList<String>();
        ArrayList<String> bad_user=new ArrayList<String>();
        while(true){
            String id=sc.nextLine();
            if(id=="-1") break;
            users.add(id);

        }
        while(true){
            String id=sc.nextLine();
            if(id=="-1") break;
            bad_user.add(id);
        }

    }
    public static void result(ArrayList<String > arr1,ArrayList<String > arr2){
        String tmp[];
        char a;
        int n;
        for(int i=0;i<arr1.size();i++){
            for(int j=0;j<arr2.size();j++){
                if(arr1.get(i).length()==arr2.get(j).length()){
                    n=arr2.get(j).charAt('*');
                    for(int k=0;k<arr2.get(j).length();k++){
                        if(n==k)k++;
                        //hih1217
                        //hih*2*7
                    }
                }

            }
        }
    }
}
/*
* 가려진 부분을 제외하고
* 문자열이 같으면 패스
*
* */