package questions;
import java.util.*;

public class insertInterval {

    public insertInterval(){
        insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>(List.of(newInterval[0],newInterval[1])));
        for(int [] i : intervals){
            list.add(new LinkedList<Integer>(List.of(i[0],i[1])));
        }

        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });

        LinkedList<LinkedList<Integer>> mergedIntervals = new LinkedList<>();
        for(LinkedList<Integer> i : list){
            if(mergedIntervals.isEmpty()) {
                mergedIntervals.add(new LinkedList<>(List.of(i.get(0), i.get(1))));
                continue;
            }
            if(mergedIntervals.getLast().get(1) < i.get(0)){
                mergedIntervals.add(new LinkedList<>(List.of(i.get(0),i.get(1))));
                continue;
            }

            LinkedList<Integer> lastInterval = mergedIntervals.getLast();
            mergedIntervals.remove(mergedIntervals.size()-1);
            mergedIntervals.add(new LinkedList<Integer>(List.of(lastInterval.get(0), Math.max(i.get(1),lastInterval.get(1)))));
        }

        int[][] result = new int[mergedIntervals.size()][];
        int idx = 0;
        for(LinkedList<Integer> i : mergedIntervals){
            result[idx++] = new int[]{i.get(0),i.get(1)};
        }

        return result;
    }

}
