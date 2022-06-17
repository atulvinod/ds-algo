package questions;

public class findElementInRotatedSortedArray {

    /**
     * There are multiple cases for solving this particular problem,
     * the element can be in the left sorted array,
     * the element can be in the right sorted array,
     * we have to determine what is the location of the target
     * */

    public int solve(int [] nums, int target){
        int pos  = -1;
        int start = 0;
        int end = nums.length;

        while(start <= end){
            int mid = (start + end)/2;
            if(target == nums[mid]){
                return mid;
            }
            //we are in left sorted array
            if(nums[mid] >= nums[start]){
                if(target > nums[mid] || target < nums[start]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            // we are in right array
            }else{
                //this condition implies that the target should be in the left side,
                if(target < nums[mid] || target > nums[end]){
                    end = mid-1;
                 //right side
                }else{
                    start = mid+1;
                }
            }
        }


        return pos;
    }


}
