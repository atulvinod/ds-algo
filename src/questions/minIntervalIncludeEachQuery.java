package questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class minIntervalIncludeEachQuery {

    public minIntervalIncludeEachQuery(){
        minInterval(new int[][]{{1,4},{2,4},{3,6},{4,4}}, new int[]{2,3,4,5});
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]-o1[0]) - (o2[1]-o2[0]);
            }
        });

        for(int[] q : intervals){
            queue.add(q);
        }

        int[] result = new int[queries.length];
        for(int i = 0 ; i< queries.length ; i++){

        }

        return result;
    }

}
