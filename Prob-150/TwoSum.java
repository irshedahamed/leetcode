class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0 ;i < nums.length; i++){
            int key = target - nums[i];
            if(map.containsKey(key))
                return new int[]{map.get(key), i};
           map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
