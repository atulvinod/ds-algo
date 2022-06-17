package questions;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class handOfStraights {

    /**
     * https://leetcode.com/problems/hand-of-straights/
     * */

    public  handOfStraights(){
//        boolean result = isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3);
//        boolean result = isNStraightHand(new int[]{5,1},1);
        boolean result = isNStraightHand(new int[]{1,1,2,2,3,3},2);
        System.out.println(result);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize == 1) return true;
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue();

        Stack<Integer> st = new Stack<>();
        Stack<Integer> tempSt = new Stack<>();

        for(int i : hand){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i : map.keySet()){
            heap.add(i);
        }

        while(!heap.isEmpty()){

            while(st.size() != groupSize){
                if(heap.isEmpty()) return false;
                int min = heap.poll();
                tempSt.add(min);

                if(st.isEmpty()){
                    st.add(min);
                    continue;
                }
                if(st.peek() +1 == min){
                    st.add(min);
                }else{
                    return false;
                }
            }

            st.clear();
            while(!tempSt.isEmpty()){
                int v = tempSt.pop();
                map.put(v, map.get(v)-1);
                if(map.get(v)!=0){
                    heap.add(v);
                }
            }
        }

        return true;
    }
}
