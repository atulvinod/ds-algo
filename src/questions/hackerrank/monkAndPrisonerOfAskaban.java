package questions.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class monkAndPrisonerOfAskaban {

    public monkAndPrisonerOfAskaban(){
        solve(new long[]{5,4,1,3,2});
    }

    public void solve(long[] values){
        long[] x = new long[values.length];
        long[] y = new long[values.length];

        Arrays.fill(x,-1);
        Arrays.fill(y,-1);

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> queue = new Stack<>();

        for(int i = values.length-1 ; i >= 0 ; i--){
            if(mainStack.isEmpty()){
                mainStack.add(i);
            }else{

                if(values[mainStack.peek()] > values[i]){
                    y[i] = mainStack.peek()+1;

                }else{
                    while(!mainStack.isEmpty() && values[mainStack.peek()] < values[i]){
                        mainStack.pop();
                    }
                    y[i] = mainStack.isEmpty() ? -1 : mainStack.peek()+1;
                }
                mainStack.add(i);
            }

        }
        mainStack.clear();

        for(int i = 0 ; i < values.length ; i++){
            if(mainStack.isEmpty()){
                mainStack.add(i);
            }else{

                    if(values[mainStack.peek()] > values[i]){
                        x[i] = mainStack.peek()+1;

                    }else{
                        while(!mainStack.isEmpty() && values[mainStack.peek()] < values[i]){
                            mainStack.pop();
                        }
                        x[i] = mainStack.isEmpty() ? -1 : mainStack.peek()+1;
                    }
                mainStack.add(i);
            }

        }


        for(int i= 0 ; i< values.length ; i++){
            System.out.print(x[i]+y[i]+" ");
        }
    }

}
