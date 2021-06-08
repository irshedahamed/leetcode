/*

Smallest Subarray with given Sum

Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
*/

 Class SmallestSubArray {
    public int findSmallestSubArray ( int[] nums, int k){
        Int min = Integer.MAX_VALUE;
        Int sum = 0;
        Int windowStart = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            Sum += nums[windowEnd];
            while (sum >= k) {
                min = Math.min(min, windowEnd - windowStart + 1);
                Sum -= nums[windowStart++];
            }
        }
        return min;
    }
}