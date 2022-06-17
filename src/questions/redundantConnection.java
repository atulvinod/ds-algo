package questions;
import java.util.*;

public class redundantConnection {
    /**
     * https://leetcode.com/problems/redundant-connection/
     *
     * This question requires the implementation of the union-find by rank algorithm
     * */

    public int findParent(int[] parent , int index){
        while(parent[index] != index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }

        return index;
    }

    //using union find
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        //initially all vertices are their own parents
        int[] parent =  new int[nodes+1];

        //their rank is also one
        int[] rank = new int[nodes+1];

        Arrays.setAll(parent, i -> i);
        Arrays.fill(rank,1);

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];

            //for the edges, find their absolute parent.
            //absolute parent, implies that an element which is a parent of itself and our
            //current element is their child in the tree
            int rootA = findParent(parent, a);
            int rootB = findParent(parent, b);

            //if the roots of both the vertices are same, then it implies that
            //adding this edge will create a loop, hence removing this edge will
            //prevent loop
            if(rootA == rootB){
                return e;
            }

            //if they are different, then we check whose rank is greater
            //and that element's root parent becomes the other elements root parent.
            //and rank is increased by adding the child elements current rank.
            if(rank[rootA] > rank[rootB]){
                parent[rootB] = rootA;
                rank[rootA]+=rank[rootB];
            }else{
                parent[rootA] = rootB;
                rank[rootB]+=rank[rootA];
            }
        }

        return new int[0];
    }
}
