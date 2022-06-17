package questions;
import java.nio.channels.UnresolvedAddressException;
import java.util.*;
import java.util.spi.LocaleNameProvider;

public class nonOverlappingIntervals {

    public nonOverlappingIntervals(){
      int r =   eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}});
        System.out.println(r);
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

       int[] prevInterval = intervals[0];
       int result = 0;
       for(int i = 1 ; i < intervals.length ; i++){
           if(intervals[i][0] < prevInterval[1]){
               result++;
               if(intervals[i][1] <= prevInterval[1]){
                   prevInterval = intervals[i];
               }
           }
       }

       return result;
    }
}
