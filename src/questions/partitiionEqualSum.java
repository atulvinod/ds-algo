package questions;
import java.util.*;

public class partitiionEqualSum {

    public partitiionEqualSum(){
        canPartition(new int[]{1,5,11,5});
    }

    HashMap<Integer, Boolean> dp = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }
        if(sum%2 != 0) return false;

        int target = sum/2;
        boolean result =  solve(nums, 0, 0, target);
        return result;
    }

    public boolean solve(int[] nums, int index, int currentSum, int target){
        if(index >= nums.length){
            return currentSum == target;
        }

        if(dp.containsKey(currentSum)) return dp.get(currentSum);
        boolean result = solve(nums, index+1, currentSum+nums[index],target) || solve(nums, index+1,currentSum,target);
        dp.put(currentSum, result);
        return result;
    }
}
