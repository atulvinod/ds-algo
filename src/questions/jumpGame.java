package questions;

public class jumpGame {

    public jumpGame(){

    }

    public boolean canJump(int [] nums){

        /*
        * From the end we check if we can reach the element that will eventually reach the end
        * initially we choose the last element, as it can always reach the end an choose it as the valid
        * index,
        * then afterwards we itearate over the array and check if we can reach the valid element, if we can ,
        * then that index becomes the valid index
        *
        * In the end if valid index becomes zero, then we can reach the end from the beginning
        * **/
        int lastValidIndex = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]+i >= lastValidIndex){
                lastValidIndex = i;
            }
        }

        return lastValidIndex == 0;
    }

}
