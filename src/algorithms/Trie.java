package algorithms;
import java.util.*;


public class Trie {

    class TrieNode{
        Character character;
        boolean terminatesWord;
        HashMap<Character,TrieNode> nodes;

        public TrieNode(){
            this.character = null;
            this.terminatesWord = false;
            this.nodes = new HashMap<>();
        }

        public TrieNode(char character, boolean terminatesWord){
            this.character = character;
            this.terminatesWord = terminatesWord;
            this.nodes = new HashMap<>();
        }
    }

    TrieNode root = new TrieNode();

    public Trie() {

    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length() ; i++){
            if(current.nodes.containsKey(word.charAt(i))){
                current = current.nodes.get(word.charAt(i));
                if(i == word.length() -1){
                    current.terminatesWord = true;
                }
            }else{
                TrieNode newNode = new TrieNode(word.charAt(i), i == word.length()-1);
                current.nodes.put(word.charAt(i),newNode);
                current = newNode;
            }
        }
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length() ; i++){
            if(current.nodes.containsKey(word.charAt(i))){
                current = current.nodes.get(word.charAt(i));
            }else{
                return false;
            }
        }
        return current.character == word.charAt(word.length() -1 ) && current.terminatesWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0 ; i < prefix.length() ; i++){
            if(current.nodes.containsKey(prefix.charAt(i))){
                current = current.nodes.get(prefix.charAt(i));
            }else{
                return false;
            }
        }
        return true;
    }
}
