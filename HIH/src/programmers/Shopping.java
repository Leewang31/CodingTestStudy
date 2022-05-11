package programmers;

import java.util.*;
import java.util.stream.Stream;

public class Shopping {
    public static void main(String[] args) {
        String[] gems={"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] arr={"DIA","Ruby","EMERALD","SAPPHIRE"};
        int[] result;
        result=solution(gems);
        for (int i = 0; i < 2; i++) System.out.println(result[i]);


    }
    public static int[] solution(String[] gems) {
        int[] min = {1, gems.length};
        HashSet<String> hs = new HashSet<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int g_len = 0;
        int redundancy=0;
        for (int i = 0; i < gems.length; i++) {
            hs.add(gems[i]);
            g_len = i;
        }
        int[] cnt_arr=new int[g_len];
        for(int i=0;i<cnt_arr.length;i++) {
            cnt_arr[i]=0;
            hm.put(gems[i],cnt_arr[i]);
        }
        for (int i = 0; i < g_len; i++) {
            if(hm.containsKey(gems[i])){
                hm.compute(gems[i],(k,v)->(v!=null)?1:v+1);
            }
            System.out.println("hm = " + hm);
            /*while(hm.get(gems[redundancy])>1){
                hm.compute(gems[redundancy],(k,v)->v-1);
                redundancy++;
            }*/
            min[0]=redundancy;
            min[1]=i-redundancy;
        }
        return min;
    }
}
