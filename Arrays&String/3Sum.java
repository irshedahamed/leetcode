/*
Implementation of 3 Sum Problem

Url : https://leetcode.com/problems/3sum/submissions/

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        List<List<Integer>> result = new ArrayList<>();
        
        //Sort the Number initially
        Arrays.sort(nums);
        
        //Interate the Arr And fix a num and implement two sum approach to select other two nums
        for(int i = 0;i < nums.length; i++){
            int target = 0;
            
            //Condition to remove duplicates
            if(i>0 && nums[i] == nums[i-1])
                continue;
            
            target -= nums[i];
            //Two Sum Approach
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right])); 
                    left++;
                    right--;
                    //remove Duplicates
                    while(left<right && nums[left]==nums[left-1])left++;
                    while(left<right && nums[right]==nums[right+1])right--;
                } else if(sum < target){
                    left++;
                } else if( sum > target){
                    right--;
                }
            }
        }
        return result;
    }
}