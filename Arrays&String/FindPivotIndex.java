class Solution {
    public int pivotIndex(int[] nums) {
        
        if(nums==null || nums.length<2)
            return -1;
        
        int totalSum = 0;
        List<Integer> list = new ArrayList<>();
                
        for(int i = 0;i < nums.length;i++)
                totalSum += nums[i];
        
        int leftSum = 0;
        
        for(int i = 0;i<nums.length;i++){
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum)
                list.add(i);
            leftSum += nums[i];
        }
            
        if(list.size()==0)
            return -1;
        
        return list.get(0);
        
    }
}
