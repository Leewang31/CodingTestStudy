package programmers;

import java.util.*;

public class Shopping {
    public static void main(String[] args) {
        String[] gems={"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD",
                "SAPPHIRE", "DIA"};
        String[] arr={"DIA","Ruby","EMERALD","SAPPHIRE"};
        int[] result;
        result=solution(gems);
        for (int i=0;i<2;i++) System.out.println(result[i]);


    }
    public static int[] solution(String[] arr1) {
        int min[] = {1, arr1.length};
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int g_len = 0;
        int redundancy=0;
        int end=0;
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
            g_len = i;
        }
        int[] cnt_arr=new int[g_len];
        for(int i=0;i<cnt_arr.length;i++)
        {
            cnt_arr[i]=0;
            hm.put(arr1[i],cnt_arr[i]);
        }
        for (int i = 0; i < g_len; i++) {
            if(hm.containsKey(arr1[i])){
                hm.compute(arr1[i],(k,v)->(v!=null)?1:v+1);
                System.out.println("hm = " + hm);
            }
            while(hm.get(arr1[redundancy])>1){
                hm.compute(arr1[redundancy],(k,v)->v-1);
                redundancy++;
            }
            min[0]=redundancy;
            min[1]=i-redundancy;
        }
//이전 값에 중복이 있다면 min[0]+=1
//다음 값을 포함 했을 때 중복이 발생하면 min[1]-=1;
//hm에 hs값이 전부 들어가면서 min의 구간이 가장 짧을 경우를 return
//종료조건
        return min;

    }
}
/*
*
* */