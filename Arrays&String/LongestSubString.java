/*
3. Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

*/

class Solution {
    int max = 0;
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set;
        for(int i=0;i<s.length();i++){
            set = new HashSet<>();
            findSubString(i,set,s);
        }
        return max;
    }   
    public void findSubString(int i,Set<Character>set,String s){
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
            }else{
                break;
            }
        }
        max = (set.size() > max) ? set.size() : max;
    }
}

// End of Naive

//Start - Sliding window