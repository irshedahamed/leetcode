/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.
The answer is guaranteed to fit in a 32-bit integer

Example 1:
Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
*/

class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2 ;i<=s.length();i++){
            if(s.charAt(i-1)>'0'){
                dp[i]+=dp[i-1];
            }
            if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)<'7'){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
