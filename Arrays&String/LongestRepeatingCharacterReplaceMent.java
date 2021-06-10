/*
Url : 424. Longest Repeating Character Replacement

Url : https://leetcode.com/problems/longest-repeating-character-replacement/

*/

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> charFreqMap = new HashMap<>();
        int windowStart = 0;
        int max = Integer.MIN_VALUE;
        int maxRepeating = 0;
        for(int windowEnd = 0;windowEnd < s.length();windowEnd++){
            char lastChar = s.charAt(windowEnd);
            charFreqMap.put(lastChar,charFreqMap.getOrDefault(lastChar,0)+1);
            
            maxRepeating = Math.max(maxRepeating,charFreqMap.get(lastChar));
            
            while(windowEnd - windowStart + 1 - maxRepeating > k){
                char firstChar = s.charAt(windowStart++);
                charFreqMap.put(firstChar,charFreqMap.get(firstChar)-1);
            }
            
            max = Math.max(max,windowEnd - windowStart + 1);
            
        }
        return max;
    }
}