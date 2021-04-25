package leetcode.Week1.Three_sum;

import java.util.*;

public class JI_Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = nums.length-1;

            while(true){
                if( (left >= i) || (right <= i) )
                    break;
                if(nums[left] + nums[right] + nums[i] == 0){
                    hashSet.add(new ArrayList<Integer>(Arrays.asList(nums[left],nums[i],nums[right])));
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] + nums[i]  > 0)
                    right--;
                else
                    left++;
            }
        }

        return new ArrayList<>(hashSet);
    }
}
