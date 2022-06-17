package questions;

import java.util.Stack;

public class largestAreaInHistogram {
    public static int largestRectangleArea(int[] heights){
        int z = 0;
        int[] prevSm = prevSmallerElement(heights);
        int [] nextSm = nextSmallerElement(heights);
        for(int i = 0 ; i< heights.length ; i++){
            z = Math.max((nextSm[i] - prevSm[i] - 1) * heights[i],z);
        }
        return z;
    }

    static int[] prevSmallerElement(int[] heights){
        Stack<Integer> st = new Stack<>();
        int[] prevSmallerArray = new int[heights.length];
        for(int i = 0; i < heights.length ; i++){
            while(!st.isEmpty() && heights[st.peek()] >=  heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                prevSmallerArray[i] = -1;
            }else{
                prevSmallerArray[i] = st.peek();
            }
            st.push(i);
        }
        return prevSmallerArray;
    }

    static int[] nextSmallerElement(int[] heights){
        Stack<Integer> st = new Stack<>();
        int nextSmallerElements[] = new int[heights.length];
        for(int i = heights.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextSmallerElements[i] = heights.length;
            }else{
                nextSmallerElements[i] = st.peek();
            }
            st.push(i);
        }
        return nextSmallerElements;
    }
}
