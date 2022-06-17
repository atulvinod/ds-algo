package questions.hackerrank;
import java.util.*;
public class monkAndOrderOfPheonix {

    class solution{
        LinkedList<Stack<Integer>> stacks;
        public solution(int n, int[][] heights){
            stacks = new LinkedList<>();
            for(int i = 0 ;i < heights.length ; i++){
                Stack<Integer> st = new Stack<>();
                for(int k = 0 ; k < heights[i].length ; k++){
                    st.push(heights[i][k]);
                }
                stacks.add(st);
            }
        }

        public void add(int k, int h){
            stacks.get(--k).push(h);
        }

        public void remove(int k){
            stacks.get(--k).pop();
        }

        public String check(){
            Stack<Integer> st = new Stack<>();
            for(int i = 0 ; i < stacks.get(0).size() ; i++){
                st.add(stacks.get(0).get(i));
                if(dfs(st,1)) return "YES";
                st.pop();
            }
            return "NO";
        }

        private boolean dfs(Stack<Integer> st, int index){
            if(st.size() == stacks.size()) return true;
            if(stacks.get(index).peek() < st.peek()) return false;
            for(int z = stacks.get(index).size()-1 ; z>=0 ; z--){
                if(stacks.get(index).get(z) < st.peek()) continue;
                st.add(stacks.get(index).get(z));
                if(dfs(st,index+1)) return true;
                st.pop();
            }

            return false;
        }

    }

    public monkAndOrderOfPheonix(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] st = new int[n][];
        for(int i = 0 ; i < n ; i++){
            int x = scan.nextInt();
            st[i] = new int[x];
            for(int k = 0 ; k < x ; k++){
                st[i][k] = scan.nextInt();
            }
        }

        solution sol = new solution(n,st);
        int q = scan.nextInt();
        while(q-- > 0){
            int op = scan.nextInt();
            switch (op){
                case 1:
                    int k = scan.nextInt();
                    int h = scan.nextInt();
                    sol.add(k,h);
                    break;
                case 2:
                    System.out.println(sol.check());
                    break;
                case 0:
                    int v = scan.nextInt();
                    sol.remove(v);
            }
        }
    }

}
