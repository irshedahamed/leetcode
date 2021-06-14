/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*/

class Solution {
    public int longestConsecutive(int[] nums) { 
        if(nums.length <= 1)
            return nums.length;
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int max = 0;
        
        for(int val : set){
            if(!set.contains(val-1)){
                int count = 1;
                int current = val;
                while(set.contains(current+1)){
                    count++;
                    current = current + 1;
                }
                max = Math.max(count,max);
            }
        }
        
       return max;
    }
}