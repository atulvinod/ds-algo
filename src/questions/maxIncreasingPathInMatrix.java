package questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class maxIncreasingPathInMatrix {

    public maxIncreasingPathInMatrix(){
        longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }

        int maxPath = Integer.MIN_VALUE;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ;j++ ){
                if(dp[i][j] == -1){
                    dp[i][j] = dfs(dp[i][j],i,j,0,matrix,dp,new HashSet<String>());
                    maxPath = Math.max(maxPath, dp[i][j]);
                }
            }
        }
        return maxPath+1;
    }

    public int dfs(int prev, int x, int y, int depth, int[][] matrix, int[][] dp, Set<String> visited){
        if(x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0){
            return depth-1;
        }

        if(visited.contains(x+","+y) || matrix[x][y] <= prev) return depth-1;

        if(dp[x][y] != -1) return dp[x][y]+depth;

        visited.add(x+","+y);

        int[][] vectors = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        int maxV = 0;
        for(int[] v : vectors){
            maxV = Math.max(maxV, dfs(matrix[x][y], x+v[0],y+v[1],depth+1, matrix, dp, visited));
        }

        dp[x][y] = maxV;
        return maxV;
    }


}
