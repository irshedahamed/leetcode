class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        Integer[] leftProduct = new Integer[nums.length];
        Integer[] rightProduct = new Integer[nums.length];
        
        leftProduct[0] = nums[0];
        rightProduct[nums.length-1] = nums[nums.length-1];
        for(int i = 1 ;i<nums.length;i++)
            leftProduct[i] = nums[i] * leftProduct[i-1];
        for(int i = nums.length-2 ; i>=0 ; i--)
            rightProduct[i] = nums[i] * rightProduct[i+1];
        
        
        nums[0] = rightProduct[1];
        nums[nums.length-1] = leftProduct[nums.length-2];
        for(int i = 1 ; i < nums.length - 1 ; i++){
            nums[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        return nums;
    }
}
