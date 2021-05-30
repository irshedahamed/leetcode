/*
Jump Sum : https://leetcode.com/problems/jump-game/submissions/	 

1. Checking if Can Jump to the GOOD position from (i + nums[i])
2. If yes then Change it to GOOD postion

*/

class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for(int i = lastPos ; i >= 0 ; i--){
            if( i + nums[i] >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }
}