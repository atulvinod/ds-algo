package questions;

import java.util.*;

public class courseSchedule {

    /**
     * This question has the implementation of topological sort using in-degrees in directed graph
     *
     *  */

    public courseSchedule(){
        canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<Integer, LinkedList<Integer>>();
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        //create adjecency list
        for(int[] courses : prerequisites){
            LinkedList<Integer> neighbours = adjList.getOrDefault(courses[1], new LinkedList<>());
            neighbours.add(courses[0]);
            adjList.put(courses[1], neighbours);
        }

        //initialize the indegree of each course to one
        for(int i = 0 ; i < numCourses ; i++){
            indegrees.put(i, 0);
        }

        //set indregrees of vertices which have an incoming edge
        for(Map.Entry<Integer, LinkedList<Integer>> m : adjList.entrySet()){
            for(int e : m.getValue()){
                indegrees.put(e, indegrees.getOrDefault(e,0)+1);
            }
        }

        //push vertices to queue whose indegree is zero
        for(Map.Entry<Integer, Integer> map : indegrees.entrySet()){
            if(map.getValue() == 0){
                q.add(map.getKey());
            }
        }

        int processedElements = 0;

        //iterate over the queue, increase processedElements count for each vertice with a zero indegree.
        while(!q.isEmpty()){
            //we can also add this element to an array
            //which will store the topological ordering of the graph's vertices
            int value = q.poll();
            processedElements++;

            //reduce the indegree of all the neighbouring vertices
            for(int i : adjList.getOrDefault(value, new LinkedList<>())){

                int indeg = indegrees.get(i);
                if(indeg == 0) continue;

                indeg = indeg-1;
                if(indeg == 0){
                    //if the indegree becomes zero, add it to queue,
                    q.add(i);
                }
                indegrees.put(i, indeg);

            }
        }

        //if the processedElements count is not equal to the total number of elements (stored in indegrees map) then topological ordering
        //is not possible due to a cycle in the graph
        return processedElements == indegrees.size();
    }
}
