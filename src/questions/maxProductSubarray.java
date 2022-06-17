package questions;

public class maxProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int res = nums[0];

        int curMin = res;
        int curMax = res;

        for(int i =1  ; i < nums.length ;i++){

            if(nums[i] < 0){
                int temp = curMin;
                curMin = curMax;
                curMax = temp;
            }


            curMin = Math.min(nums[i], (curMin * nums[i]));
            curMax = Math.max(nums[i], (curMax*nums[i]));
            res = Math.max(res, curMax);
        }

        return res;
    }
}
