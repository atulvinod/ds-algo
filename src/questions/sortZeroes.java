package questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sortZeroes {

    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int index = 0;

        while(start < end && index <= end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            }else if(nums[index] == 2){
                //We dont increment index here as we don't know what will be the index value after being swapped with end,
                //but we are sure that after the swap the end should be 2, hence correct value of the element at the index
                //will be determined in the next iteration
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                index++;
            }
        }

    }
}
