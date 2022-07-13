class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(!Character.isLetterOrDigit(leftChar))
                    left++;
            else if(!Character.isLetterOrDigit(rightChar))
                    right--;
            else if(Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)){
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }   
}
