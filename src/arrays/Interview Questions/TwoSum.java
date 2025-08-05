//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println("Test - Array: [2,7,11,15]. Target: 9");
        System.out.println("Expected: [0, 1] (3 + 7 = 9)");
        System.out.println("Result: " + Arrays.toString(twoSum(nums, target)));
    }
}
