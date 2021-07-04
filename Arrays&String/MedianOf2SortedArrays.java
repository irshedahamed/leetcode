/*
    Url : https://leetcode.com/problems/median-of-two-sorted-arrays/    

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int[] merged = new int[nums1.length + nums2.length];
        int count = 0;
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            if(nums1[ptr1] < nums2[ptr2])
                merged[count++] = nums1[ptr1++];
            else
                merged[count++] = nums2[ptr2++];
        }
        
        while(ptr1 < nums1.length)
            merged[count++]=nums1[ptr1++];
        while(ptr2 < nums2.length)
            merged[count++]=nums2[ptr2++];
        
        
        if(count == 1)
            return Double.valueOf(merged[0]);
        
        Double result;
        if(count % 2==0){
            int rmid = merged[count/2];
            int lmid = merged[count/2-1];
            result = (lmid + rmid) / 2.0;
        }else{
            result = Double.valueOf(merged[count/2]);
        }
        return result;
    }
}