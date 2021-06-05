/*
Sum of Two Numbers Less Than Target
Easy

Given a list of integers nums and an integer target, return the sum of the largest pair of numbers in nums whose sum is less than target. You can assume that there is a solution.

Constraints

2 ≤ n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [5, 1, 2, 3]
target = 4
Output
3

*/
class Solution {
    public int solve(int[] nums, int target) {
        int max = Integer.MIN_VALUE;
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int val = nums[left] + nums[right];
            if(val < target){
                max = Math.max(val,max);
                left++;
            }
            else
                right--;

        }
        return max;
    }
}