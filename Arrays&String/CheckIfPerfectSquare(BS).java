import java.util.*;

class Solution {
    public boolean solve(int n) {
        if(n<=1)
            return true;
        long left = 1;
        long right = n;
        while(left < right){
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if(square == n)
                return true;
            else if(square < n)
                left = mid+1;
            else
                right = mid;
        }

        return false;
    }
}