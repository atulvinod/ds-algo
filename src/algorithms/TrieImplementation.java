package algorithms;

import java.util.LinkedList;
import java.util.List;

public class TrieImplementation {
    class Dictionary{

        class TrieNode{
            boolean terminatesWord;
            TrieNode[] nodes;

            char currentCharacter;
            String description;

            public TrieNode(){
                terminatesWord = false;
                nodes = new TrieNode[26];
            }

            public TrieNode(Character character){
                this();
                this.currentCharacter = character;
            }
        }

        TrieNode root = new TrieNode();

        public Dictionary(){

        }

        public LinkedList<String> getWords(TrieNode node, String prefix){
            if(node.terminatesWord){
                return new LinkedList<String>(List.of(prefix));
            }

            LinkedList<String> results = new LinkedList<>() ;
            for(TrieNode n : node.nodes){
                if(n != null)
                    results.addAll(getWords(n, prefix+n.currentCharacter));
            }
            return results;
        }

        public String searchWord(TrieNode node, String key, String prefix){
            if(key.length() == 0){
                if(node.terminatesWord) {
                    return node.description;
                }else{
                    LinkedList<String> suggestions = getWords(node, prefix);
                    String suggestionString = String.join(",",suggestions);
                    return "Did you mean "+suggestionString;
                }
            }
            int characterKey = key.charAt(0) - 'a';
            TrieNode nextNode = node.nodes[characterKey];
            return searchWord(nextNode, key.substring(1), prefix+key.charAt(0));
        }

        public String get(String key){
            return searchWord(root, key,"");
        }

        public void set(String key, String value){
            TrieNode currentNode = root;
            for(int i = 0 ; i < key.length() ; i++){
                int currentKey = key.charAt(i) - 'a';
                if(currentNode.nodes[currentKey] == null){
                    currentNode.nodes[currentKey] = new TrieNode(key.charAt(i));
                }
                currentNode = currentNode.nodes[currentKey];
            }
            currentNode.terminatesWord = true;
            currentNode.description = value;
        }

    }
}
