package questions;

import java.util.*;

public class generateParenthesis {
    List<String> list = new LinkedList<>();

    public generateParenthesis(){
        solve(3);
    }


    public List<String> solve(int n) {
        generate(list, "",n, 0, 0);
        return list;
    }

    public void generate(List<String> list, String currentString , int numberOfBracketPairs, int openBracketCount, int closedBracketCount){
        if(currentString.length() == numberOfBracketPairs*2){
            list.add(currentString);
            return;
        }

        if(openBracketCount < numberOfBracketPairs) generate(list, currentString+"(", numberOfBracketPairs,openBracketCount+1, closedBracketCount);
        if(closedBracketCount < openBracketCount)  generate(list, currentString+")",numberOfBracketPairs, openBracketCount, closedBracketCount+1);
    }
}
