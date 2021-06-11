/*
Url : https://leetcode.com/problems/merge-intervals/

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
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
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        if(intervals.length < 2)
                return intervals;
        
        List<Interval> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];    
        for(int i = 1;i<intervals.length;i++){
            int currentS = intervals[i][0];
            int currentE = intervals[i][1];
            if(currentS <= end){
                end = Math.max(end,currentE);
            } else{
                list.add(new Interval(start,end));
                start = currentS;
                end = currentE;
            }
        }
        
        list.add(new Interval(start,end));
        
        int count = 0;
        int[][] result = new int[list.size()][2];
        for(Interval val : list){
            result[count][0] = val.start;
            result[count++][1] = val.end;
        }
        
        return result;
    }
}