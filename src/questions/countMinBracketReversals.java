package questions;

import java.util.Stack;

public class countMinBracketReversals {
    public static int solveRev(String s){
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(st.isEmpty() || c == '{'){
                st.push(c);
            }else if(c == '}'){
                if(!st.isEmpty() && st.peek() == '{'){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }

        Stack<Character> st2 = new Stack<>();
        while(!st.isEmpty()) {
            char temp = st.pop();
            if(!st2.isEmpty() ){
                if(st2.pop() == temp){
                    res++;
                }else{
                    res+=2;
                }
            }else{
                st2.push(temp);
            }
        }

        return !st2.isEmpty() ? -1 : res;
    }
}
