class Solution {
    public boolean isPalindrome(int x) {
        int count = 0;
        int l = x;
        int r = x;
        double sum = 0;
        while (l > 0) {
            l = l / 10;
            count++;
        }
        while (r > 0) {
            int k = r % 10;
            sum += k * (int) Math.pow(10, count - 1);
            count--;
            r = r / 10;
        }
        if (sum == x) {
            return true;
        } else {
            return false;
        }
    }
}