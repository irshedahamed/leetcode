/*
5. Longest Palindromic Substring
Medium
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

 */


class Solution {
    String lSubString="";
    public String longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1)
            return s;
        for(int i = 0; i<s.length();i++){
            isLongPal(i,s);
        }
        return lSubString;
    }
    
    public void isLongPal(int i,String s){
        int left = i;
        int right = i;
        
        //right
        while(right+1<s.length() && Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right+1))){
            right++;           
        }
            
        while(left-1>=0 && right+1<s.length()){
            left--;
            right++;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                left++; right--;
                break;
            }
        }
     
        String temp = (left==right) ? String.valueOf(s.charAt(left)) : s.substring(left,right+1);
        if(temp.length()>lSubString.length()){
            lSubString = temp;
        }
    }
}

//End of BruteForce Solution