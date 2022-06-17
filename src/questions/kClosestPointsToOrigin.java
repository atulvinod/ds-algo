package questions;
import java.util.*;
public class kClosestPointsToOrigin {


    class Pair{
        int[] point;
        double dist;

        public Pair(int[] point){
            this.dist = Math.round(Math.sqrt((Math.pow(point[0],2)+Math.pow(point[1],2))));
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> q = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o1.dist,o2.dist);
            }
        });

        for(int[] i : points){
            q.add(new Pair(i));
        }

        int[][] res = new int[k][];

        for(int i = 0 ; i < k ; i++){
            res[i] = q.poll().point;
        }

        return res;
    }

}
