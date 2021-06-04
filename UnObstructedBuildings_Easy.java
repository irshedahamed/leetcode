/*
You are given a list of integers heights representing building heights. A building heights[i] can see the ocean if every building on its right has shorter height. Return the building indices where you can see the ocean, in ascending order.

Constraints

0 ≤ n ≤ 100,000 where n is the length of heights
Example 1
Input
heights = [1, 5, 5, 2, 3]
Output
[2, 4]

*/

class Solution {
    public int[] solve(int[] heights) {
       List<Integer> list = new ArrayList<>();     
        int max = Integer.MIN_VALUE;
        for(int i = heights.length -1 ; i>=0 ; i--){
            if(heights[i] > max){
                list.add(i);
                max = heights[i];
            }
        }
        int count = 0;
        int[] res = new int[list.size()];
        for(int i =list.size() -1 ;i>=0;i--){
            res[count++] = list.get(i);
        }
        return res;
    }
}