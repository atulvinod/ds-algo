package questions.backtracking;
import java.util.*;

public class combinationSum2 {
    /**
     * Find unique combinations in candidates which sum to a target, every element in candidate can only be taken once
     * The candidates can have duplicate elements.
     *
     * To solve this problem, the approach that we follow is that only one value will be present in a single decision
     * tree (as it is a backtracking question) and it will allow us to find unique subsets.
     *
     * */
    List<List<Integer>> result = new LinkedList<>();
//    HashMap<String, Boolean> map = new HashMap<>();

    public List<List<Integer>> findSubsets(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(new LinkedList<Integer>(), candidates, 0, 0, target);
        return result;
    }

    public void solve(List<Integer> list, int[] candidates, int index, int currentSum,int target){
        /*
        * Base cases, if currentSum is equal to target, we are correct and append the subset to result,
        * if currentSum is greater then reject the subset,
        * if the currentElementIndex is greater than length, then we are out of bounds
        * */
        if(currentSum == target){
            result.add(new LinkedList<Integer>(list));
            return;
        }

        if(currentSum > target){
            return;
        }

        if(index>=candidates.length){
            return;
        }

        /** we take a prev element, as we are taking two decision trees, in one we have that value, and in the other we dont,
         * so left tree can have all the repeated values, the other tree wont
        */
         int prev = -1;
        for(int i = index ; i < candidates.length ; i++){
            /**
             * eg [ 1,1,2]
             * left one will have combinations containing [1,1], its subtrees will combine the 1,1 values with other elements,
             * right one will have [2] and will combine with values later in the array with this
             * */
            if(candidates[i] == prev) continue;
            list.add(candidates[i]);
            solve(list,candidates, i+1, currentSum+candidates[i], target);
            list.remove(list.size()-1);
            prev = candidates[i];
        }

    }

}
