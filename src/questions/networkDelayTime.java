package questions;

import java.util.*;

public class networkDelayTime {

    public  networkDelayTime(){
        solve(new int[][]{{1,2,1},{2,3,2},{1,3,4}},3,1);
    }

    public int findMinVertex(int[][] adjMatrix, int[] weights, boolean[] visited){
        int minVertex = -1;
        for(int i = 1 ; i < adjMatrix.length ; i++){
            if(!visited[i] && (minVertex == -1 || weights[i] < weights[minVertex])){
                minVertex  = i;
            }
        }
        return minVertex;
    }

    public int solve(int[][] times, int n, int k) {
       int[][] adjMatrix = new int[n+1][n+1];

        for (int[] row: adjMatrix)
            Arrays.fill(row, -1);


       boolean[] visited = new boolean[n+1];
       int[] parent = new int[n+1];
       int[] weights = new int[n+1];
       Arrays.fill(weights, Integer.MAX_VALUE);

       weights[k] = 0;
       parent[k] = -1;

       for(int[] e : times){
            adjMatrix[e[0]][e[1]] =  e[2];
       }

       HashMap<Integer, LinkedList<Integer>> minSpanTreeAdjlist = new HashMap<>();

       for(int i = 1 ; i <=n; i++){
           int minVertex = findMinVertex(adjMatrix, weights, visited);
           visited[minVertex] = true;
           for(int j = 1 ; j <=n; j++){
               if(adjMatrix[minVertex][j] != -1 && !visited[j]){
                   if(adjMatrix[minVertex][j] < weights[j]){
                       weights[j] = adjMatrix[minVertex][j];
                       parent[j] = minVertex;
                   }
               }
           }
       }
       for(int i = 1 ; i < parent.length ; i++){
           if(parent[i] == -1) continue;
           LinkedList<Integer> neighbours = minSpanTreeAdjlist.getOrDefault(parent[i], new LinkedList<>());
           neighbours.add(i);
           minSpanTreeAdjlist.put(parent[i], neighbours);
       }

       Arrays.fill(visited, false);
       Queue<Integer> bfsQueue = new LinkedList<>();
       bfsQueue.add(k);
       int processed = 0;

       int time  = 0;
       while(!bfsQueue.isEmpty()){
           int v = bfsQueue.poll();
           if(visited[v]) continue;
           processed++;
           visited[v] = true;

           LinkedList<Integer> neighbr = minSpanTreeAdjlist.getOrDefault(v, new LinkedList<>());
           int maxPathLength = Integer.MIN_VALUE;
           for(int i : neighbr){
               maxPathLength = Math.max(maxPathLength, weights[i]);
               bfsQueue.add(i);
           }

           time += (maxPathLength == Integer.MIN_VALUE ? 0 : maxPathLength);
       }

       return processed == n ? time : -1;
    }

}
