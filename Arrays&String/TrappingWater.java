/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
*/
class Solution {
    public int trap(int[] height) {
        if(height.length==0)
            return 0;
        int left = 0;
        int right = height.length-1;
        int result = 0;
        int lmax = height[left];
        int rmax = height[right];
        while(left<=right){
            if(lmax<rmax){
                if(height[left]>lmax){
                    lmax = height[left];
                }else{
                    result+=(lmax-height[left]);
                }
                left++;
            }else{
                if(height[right]>rmax){
                    rmax = height[right];
                }else{
                    result+=(rmax-height[right]);
                }
                right--;
            }
        }
        return result;
    }
}   
