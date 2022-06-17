package questions;
import java.util.*;

public class pacificAtlanticWaterfall {
    /**
    * https://leetcode.com/problems/pacific-atlantic-water-flow/
     *
     * From the pacific and atlantic sides, we check which nodes can be reached via dfs from these sides and store those in their sets
     * the next node should be greater than the prev node (as we are traversing from the side of the ocean)
     *
     *  finally we take intersection of the set to get all the nodes which can reach pacific and atlantic side
     *
    * */

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific =  new HashSet<List<Integer>>();
        Set<List<Integer>> atlantic =  new HashSet<List<Integer>>();

        for(int x = 0 ; x < heights.length; x++)
            dfs(pacific,x, 0,heights, heights[x][0]);

        for(int y = 0 ; y < heights[0].length ; y++)
            dfs(pacific, 0,y, heights, heights[0][y]);

        for(int x = 0 ; x < heights.length ; x++)
            dfs(atlantic, x, heights[0].length-1, heights, heights[x][heights[0].length-1]);

        for(int y = 0 ; y < heights[0].length ; y++)
            dfs(atlantic, heights.length-1, y, heights, heights[heights.length-1][y]);

        //intersection of two sets
        pacific.retainAll(atlantic);
        return pacific.stream().toList();
    }

    public void dfs(Set<List<Integer>> set, int x, int y, int[][] heights, int prevHeight){

        List<Integer> pt = new LinkedList(List.of(x,y));

        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || set.contains(pt)){
            return;
        }

        if(heights[x][y] < prevHeight){
            return;
        }

        set.add(pt);
        int[][] vectors = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] v : vectors){
            int nx = x+v[0];
            int ny = y+v[1];
            dfs(set, nx, ny, heights, heights[x][y]);
        }

    }
}
