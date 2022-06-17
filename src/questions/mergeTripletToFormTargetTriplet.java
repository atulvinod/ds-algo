package questions;

import java.util.*;

public class mergeTripletToFormTargetTriplet {
    //https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
    public mergeTripletToFormTargetTriplet(){
//        boolean result = mergeTriplets(new int[][]{{2,5,3},{1,8,4},{1,7,5}}, new int[]{2,7,5});
//        boolean result = mergeTriplets(new int[][]{{3,4,5},{4,5,6}}, new int[]{3,2,5});
        boolean result = mergeTriplets(new int[][]{{3,1,7},{1,5,10}}, new int[]{3,5,7});

        System.out.println(result);
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {

        PriorityQueue<List<Integer>> queue1 = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) - o1.get(0);
            }
        });

        PriorityQueue<List<Integer>> queue2 = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1) - o1.get(1);
            }
        });

        PriorityQueue<List<Integer>> queue3 = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return   o2.get(2) - o1.get(2);
            }
        });

        for(int[] i : triplets){
            queue1.add(new LinkedList(List.of(i[0],i[1],i[2])));
        }

        while(!queue1.isEmpty() && queue1.peek().get(0) != target[0]){
            queue1.poll();
        }

        if(queue1.isEmpty()) return false;

        while(!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }

        while(!queue2.isEmpty() && queue2.peek().get(1) != target[1]){
            queue2.poll();
        }

        if(queue2.isEmpty()) return false;

        while(!queue2.isEmpty()){
            queue3.add(queue2.poll());
        }

        while(!queue3.isEmpty() && queue3.peek().get(2) != target[2]){
            queue3.poll();
        }

        List<List<Integer>> queue3List = queue3.stream().toList();
        int a = 0;
        int b = 0;
        int c = 0;
        for(List<Integer> q3l : queue3List){
            a = Math.max(q3l.get(0),a);
            b = Math.max(q3l.get(1),b);
            c = Math.max(q3l.get(2),c);
        }

        return target[0] == a && target[1] == b && target[2] == c;
    }


}
