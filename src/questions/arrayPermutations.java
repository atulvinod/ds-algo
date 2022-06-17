package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class arrayPermutations {

    List<List<Integer>> perms = new LinkedList<>();
    HashMap<Integer, Boolean> map = new HashMap<>();

    public arrayPermutations(){
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        generatePermutations(null, nums);
        return perms;
    }

    public void generatePermutations(LinkedList<Integer> currentList, int[] nums){
        if(currentList != null && currentList.size() == nums.length){
            perms.add(new LinkedList<Integer>((currentList)));
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++){
            if(!map.getOrDefault(nums[i],false)){
                map.put(nums[i],true);
                if(currentList == null){
                    currentList = new LinkedList<>();
                }
                currentList.add(nums[i]);
                generatePermutations(currentList, nums);
                map.put(nums[i],false);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
