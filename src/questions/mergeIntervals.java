package questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class mergeIntervals {

    public mergeIntervals(){
//        merge(new int[][]{{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}});
        merge(new int[][]{{1,4},{5,6}});
    }

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 1 || intervals.length == 0){
            return intervals;
        }

        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

       for(int i = 0 ; i < intervals.length ; i++){
           if(list.size() == 0){
               list.add(intervals[i]);
           }else{
               int[] lastInterval = list.getLast();
              if(lastInterval[1] < intervals[i][0]){
                  list.add(intervals[i]);
              }else{
//                  int start = lastInterval[0];
                    lastInterval[1] = Math.max(lastInterval[1],intervals[i][1]);
//                  list.add(new int[]{start,end});
              }
           }

       }

        int[][] list2 = new int[list.size()][];
        for(int i = 0 ; i < list2.length; i++)
            list2[i] = list.get(i);

        return list2;
    }
}
