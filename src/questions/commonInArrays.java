package questions;

import java.util.*;

public class commonInArrays {

    public static ArrayList<Integer> commonElements(int []A, int[] B, int []C, int a, int b, int c){
        HashMap<Integer, Integer> am = new HashMap<>();
        HashMap<Integer, Integer> bm = new HashMap<>();
        HashMap<Integer, Integer> cm = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int ai : A){
            am.put(ai, am.getOrDefault(ai,0) +1);
        }
        for(int bi : B){
            bm.put(bi, am.getOrDefault(bi,0) +1);
        }
        for(int ci : C){
            cm.put(ci, am.getOrDefault(ci,0) +1);
        }

        Iterator<Integer> iterator = am.keySet().iterator();
        while(iterator.hasNext()){
            int v =iterator.next();
           if(bm.containsKey(v) && cm.containsKey(v)){
//               int instances = Math.min(cm.get(v),Math.min(am.get(A[i]),bm.get(B[i])));
//               for(int k = 0 ; k < instances ; k++);
               res.add(v);
           }
       }
        Collections.sort(res);
       return res;
    }
}
