/*
Url : https://leetcode.com/problems/insert-interval/submissions/

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<Interval> list = new ArrayList<>();
        int it = 0;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        //Skip every interval which has end < new Start
        while(it < intervals.length && intervals[it][1] < newInterval[0]){
            list.add(new Interval(intervals[it][0],intervals[it][1]));
            it++;
        }
        
        //Merge the overlapping Intervals till newEnd >= itr start
        while(it < intervals.length && newInterval[1] >= intervals[it][0]){
            newInterval[0] = Math.min(newInterval[0] , intervals[it][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[it][1]);
            it++;
        }
        
        list.add(new Interval(newInterval[0],newInterval[1]));
        
        
        //Merge Remaining intervals
        while(it < intervals.length){
            list.add(new Interval(intervals[it][0],intervals[it][1]));
            it++;
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