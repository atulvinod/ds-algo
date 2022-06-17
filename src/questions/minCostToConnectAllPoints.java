package questions;
import java.util.*;

public class minCostToConnectAllPoints {

    /**
     * https://leetcode.com/problems/min-cost-to-connect-all-points/
     *
     * We use the prims algorithm to construct a min spanning tree, using a minHeap and visited set
     * */

    class Pair{
        int weight;
        int nodeIndex;
        public Pair(int weight, int nodeIndex){
            this.weight = weight;
            this.nodeIndex = nodeIndex;
        }
    }

    public minCostToConnectAllPoints(){
        minCostConnectPoints(new int[][]{{0,0},{1,1},{1,0},{-1,1}});
    }


    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<Integer>();

        //Keep track of the point and its respective weight
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight - o2.weight;
            }
        });

        int sum = 0;

        //starting with the origin
        minHeap.add(new Pair(0, 0));

        //iterate until we have visited all the points
        while(visited.size() != points.length){
            Pair p = minHeap.poll();
            //if the point is already visited, continue
            if(visited.contains(p.nodeIndex)){
                continue;
            }

            visited.add(p.nodeIndex);
            //consider the node's weight in the sum as it will be the smallest width
            sum += p.weight;

            //iterate over all its neighbours, in this question we will consider all the edges
            //but normally we consider an adjacency list/matrix
            for(int i = 0 ; i  < points.length ; i++){
                if(i == p.nodeIndex) continue;
                int[] point = points[p.nodeIndex];
                int[] destPoint = points[i];
                minHeap.add(new Pair((Math.abs(point[0]-destPoint[0])+Math.abs(point[1]-destPoint[1])),i));
            }
        }

        return sum;
    }

}
