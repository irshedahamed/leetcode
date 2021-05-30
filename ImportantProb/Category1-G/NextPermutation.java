/*
Url : https://leetcode.com/problems/next-permutation/submissions/
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int right = nums.length - 2 ;
       
        //Find the first Decreasing Number from the right
        while(right >= 0){
            if(nums[right] < nums[right+1])
                break;
            right--;
        }
        
        //If No Decresing Number then the Array is Sorted in reverse, So do inPlace Asending Sortr
        if(right < 0)
            inPlaceSort(nums,0,nums.length-1);
        
        //Else swap the num with next incr number in right and do a inplace sort
        else{
            int value = nums[right];
            int itr = right;
            while(itr+1<nums.length && nums[itr+1]>value)itr++;
                swap(nums,right,itr);
                inPlaceSort(nums,right+1,nums.length-1);
        }
    }
    
    public void inPlaceSort(int[] nums,int left,int right){
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    
    public void swap(int[] nums,int left,int right){
             int temp = nums[left];
            nums[left]=nums[right];
            nums[right] = temp;
    }
}
