package questions;
import java.util.*;

public class topKFreq {

    public topKFreq(){
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> res = new LinkedList<>();
        //Store keys in priority queue
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return map.get(o2) - map.get(o1);
           }
       });

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            q.add(e.getKey());
        }

        for(int i = 1 ; i <= k ; i++){
            res.add(q.poll());
        }

        int[] ans = new int[res.size()];
        for(int i = 0 ; i < res.size();i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}
