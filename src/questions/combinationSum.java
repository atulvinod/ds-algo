package questions;
import java.util.*;

public class combinationSum {
    HashMap<String, Boolean> map = new HashMap<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(new LinkedList<>(), 0, candidates, target);
        return result;
    }

    public boolean solve(LinkedList<Integer> currentElements,int currentSum, int[] candidates, int target){
        if(map.containsKey(currentElements.toString())){
            return map.get(currentElements.toString());
        }

        if(currentSum > target){
            map.put(currentElements.toString(), false);
            return false;
        }else if(currentSum == target){
            map.put(currentElements.toString(), true);
            result.add(currentElements);
            return true;
        }

        boolean k = true;

        for(int i = 0 ; i < candidates.length ; i++){
            currentElements.add(candidates[i]);
            boolean a = solve(currentElements, currentSum+candidates[i], candidates, target);
            map.put(currentElements.toString(), a);
            k = a || k;
        }

        return k;
    }

}
