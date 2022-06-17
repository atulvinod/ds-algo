package questions;

import java.util.Stack;

public class checkValidParenthesis {

    public  checkValidParenthesis(){
        boolean result = solve("(((((()*)(*)*))())())(()())())))((**)))))(()())()");
        System.out.println(result);
    }

    public boolean solve(String s){
        if(s.length() == 1){
            return (s.charAt(0)=='*');
        }
        int starCount = 0;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*'){
                starCount++;
                continue;
            }
            if(st.isEmpty() || c == '('){
                st.add(c);
            }
            if(c == ')' && st.peek() =='('){
                st.pop();
            }
        }

        return st.isEmpty() || starCount >= st.size();
    }
}
