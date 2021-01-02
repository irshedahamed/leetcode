/*
238. Product of Array Except Self
Medium

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for(int i=1;i<n;i++){
            result[i] = result[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i= n-1;i>=0;i--){
            result[i] *= right;
            right *= nums[i]; 
        }
        return result;
    }
}