/**
 * Url : https://leetcode.com/problems/first-unique-character-in-a-string/
*/

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        Character[] ch = new Character[s.length()];
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
    
}