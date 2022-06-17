package questions;
import java.util.*;

public class wordLadder {

    public wordLadder(){
        ladderLength("hit","cog", new LinkedList<String>(List.of("hot","dot","dog","lot","log","cog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Integer> weights = new HashMap<>();

        HashMap<String, LinkedList<String>> adjList =  new HashMap<>();
        //we will solve this problem using min cost path , starting form the beginWord

        //generate the adj List, two strings will be considered adjacent when only a single character is different
        for(int i = 0 ;i < wordList.size() ; i++){
            for(int j = 0 ; j < wordList.size(); j++){
                String a = wordList.get(i);
                String b = wordList.get(j);
                if(a.equals(b)){
                    continue;
                }
                int diff = 0;
                for(int k = 0 ; k < a.length() ; k++){
                    if(a.charAt(k) != b.charAt(k)){
                        diff++;
                    }
                    if(diff > 1){
                        break;
                    }
                }
                if(diff == 1){
                    LinkedList<String> n = adjList.getOrDefault(wordList.get(i), new LinkedList<String>());
                    n.add(wordList.get(j));
                    adjList.put(wordList.get(i), n);
                }
            }
        }

        //generate the weights and visited maps
        for(String s : wordList){
            visited.put(s, false);
            if(s.equals(beginWord)){
                weights.put(beginWord, 0);
                continue;
            }
            weights.put(s, Integer.MAX_VALUE);
        }

        Queue<String> queue =  new LinkedList<String>();
        queue.add(beginWord);

        //apply dijkstra's algorithm
        while(!queue.isEmpty()){
            String n = queue.poll();
            if(visited.get(n)){
                continue;
            }
            visited.put(n, true);

            LinkedList<String> neighbours = adjList.getOrDefault(n, new LinkedList<String>());
            for(String nv : neighbours){
                if(visited.get(nv)) continue;

                queue.add(nv);

                int dist = weights.get(nv);
                int distFromCurrent = weights.get(n)+1;
                if( distFromCurrent < dist){
                    weights.put(nv, distFromCurrent);
                }
            }
        }

        return weights.getOrDefault(endWord, Integer.MAX_VALUE) == Integer.MAX_VALUE ? 0 : weights.get(endWord)+1;
    }

}
