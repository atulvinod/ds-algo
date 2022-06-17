package questions;
import java.util.*;

public class pathInZigZagLabelledBinaryTree {
    public pathInZigZagLabelledBinaryTree(){
        findPathInZigZagTree(50);
    }

    public static ArrayList<Integer> findPathInZigZagTree(int label) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> elements = new ArrayList<>();

        int level = 0;
        int currentNumber = 1;
        main:
        while(true){
            ArrayList<Integer> temp = new ArrayList<>();
            int numberOfElements = (int)Math.pow(2,level++);
            boolean reachedLabel = false;
            for(int i = 0 ; i < numberOfElements ; i++){
                temp.add(currentNumber++);
                if(currentNumber == label){
                    reachedLabel = true;
                }
            }
            if(level % 2 == 0){
                Collections.reverse(temp);
            }
            elements.addAll(temp);
            if(reachedLabel) break main;
        }

       int child = elements.size()-1;

        main:
        while(child >=0){
            if(elements.get(child) == label){
                while(child > 0){
                    result.add(elements.get(child));
                    child = (int)Math.floor((child-1)/2);
                }
                result.add(elements.get(0));
                break main;
            }else{
                child--;
            }
        }
        Collections.sort(result);
        return result;
    }
}
