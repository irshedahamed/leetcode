/**
Url : https://github.com/irshedahamed/leetcode/blob/main/Images/ArrWithUnknownLen.png

 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int index = 0;
        int offSet = -1;
        while(true){
            try{
                if(reader.get(index) == target)
                    return index;
                else if(reader.get(index) < target)
                    index = (int) Math.pow(2,++offSet);
                else
                    break;
            } catch(Exception ex){
                break;
            }
        }
        
        int left = index/2 + 1;
        int right = index - 1;
        int mid = -1;
        while(left<=right){
            try{
                 mid = left + (right - left)/2;
                if(reader.get(mid) == target)
                        return mid;
                else if(reader.get(mid) < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            } catch(Exception ex){
                right = mid - 1;
            }
        }
        
        return -1;
    }
}