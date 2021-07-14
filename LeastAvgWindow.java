/*
Given a list of integers nums, and integers k and target, return the number of sublists whose length is k and its average value ≥ target.

Constraints

    n ≤ 100,000 where n is the length of nums

Example 1
Input

nums = [0, 9, 4, 5, 6]

k = 3

target = 5

Output

2

Explanation

Sublist [9, 4, 5] has average value of 6 and [4, 5, 6] has average of 5

*/
class Solution {
    public int solve(int[] nums, int k, int target) {
        int windowStart = 0;
        int sum = 0;
        int result = 0;
        for(int windowEnd = 0;windowEnd < nums.length;windowEnd++){
            sum += nums[windowEnd];
            if(windowEnd - windowStart + 1 == k){
                int temp = sum / k;
                if(temp >= target)
                    result++;
                sum -= nums[windowStart++];
            }
        }
        return result;   
    }
}