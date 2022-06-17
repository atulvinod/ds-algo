package questions;
import java.util.*;

public class swimInRisingWater {
    public swimInRisingWater(){
        swimInWater(new int[][]{{3,2},{1,0}});
      //  swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});
    }


    class Pair{
        int x;
        int y;
        int weight;
        public Pair(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    public int swimInWater(int[][] grid) {
        Set<String> visited = new HashSet<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight - o2.weight;
            }
        });

        int[][] vectors = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        heap.add(new Pair(0,0,grid[0][0]));

        while(!heap.isEmpty()){
            Pair p = heap.poll();
            visited.add(p.x+","+p.y);
            if(p.x == grid.length-1 && p.y== grid[0].length-1){
                return p.weight;
            }
            for(int[] v : vectors){
                int x = v[0]+p.x;
                int y = v[1]+p.y;
                if(valid(x,y,grid)&& !visited.contains(x+","+y)){
                    int curWeight = p.weight;
                    int destWeight = grid[x][y];
                    int wt = Math.max(destWeight, curWeight);
                    heap.add(new Pair(x,y,wt ));

                }
            }
        }

        return -1;
    }

    public boolean valid(int x, int y, int[][] grid){
        return x >= 0 && x < grid.length && y >= 0 && y<grid[0].length;
    }
}
