/*
Url : https://binarysearch.com/problems/Interval-Overlaps
Input
l0 = [
    [1, 3],
    [5, 6],
    [7, 9]
]
l1 = [
    [1, 4],
    [5, 7]
]
Output
[
    [1, 3],
    [5, 6],
    [7, 7]
]

*/

class Solution {
    class Interval{
        int start;
        int end;
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] solve(int[][] l0, int[][] l1) {
        List<Interval> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < l0.length && j < l1.length){
            int low = Math.max(l0[i][0],l1[j][0]);
            int high = Math.min(l0[i][1],l1[j][1]);
            if(low <= high){
                list.add(new Interval(low,high));
            }    
        
            if(l0[i][1] < l1[j][1])
                i++;
            else
                j++;
         }

        int[][] result = new int[list.size()][2];
            int count = 0;
            for(Interval val : list){
                result[count][0] = val.start;
                result[count++][1] = val.end;
            }
        
        return result;
}
}