/*
Sum : Longest Sublist of 1s After K Sets

Url : https://binarysearch.com/problems/Longest-Sublist-of-1s-After-K-Sets

You are given a list of integers nums containing 1s and 0s and an integer k. Given that you can set at most k 0s to 1s, return the length of the longest sublist containing all 1s.

Constraints

n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [1, 1, 1, 0, 0, 1, 0]
k = 2
Output
6
Explanation
We can set the two middle 0s to 1s and then the list becomes [1, 1, 1, 1, 1, 1, 0].
*/

import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int windowStart = 0;
        int repeatingOnes = 0;
        for(int windowEnd = 0;windowEnd < nums.length;windowEnd++){
                if(nums[windowEnd] == 1)
                    repeatingOnes++;
                
                if(windowEnd - windowStart +1 - repeatingOnes > k){
                    if(nums[windowStart++] == 1)
                        repeatingOnes--;
                }

                max = Math.max(max,windowEnd - windowStart + 1);
        }
        return max;
    }
}