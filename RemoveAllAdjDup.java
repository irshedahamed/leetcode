/*

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
*/


class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.equals(""))
            return s;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == stack.peek())
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}