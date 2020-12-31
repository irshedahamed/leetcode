/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
*/

class Interval{
    int start;
    int end;
    public Interval(int a , int b){
        this.start = a;
        this.end = b;
    }
}
class Solution {
   
    public int[][] merge(int[][] interval) {
        if(interval.length==1)
                return interval;
        List<Interval> list = new ArrayList<>();
        for(int i=0;i<interval.length;i++){
            list.add(new Interval(interval[i][0],interval[i][1]));
        }
        Collections.sort(list, new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                return (a.start - b.start);
            }
        });
        
        Stack<Interval> stack = new Stack<>();
        
        for(Interval i : list){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                Interval x = (Interval) stack.pop();
                if (x.end >= i.start && x.end <= i.end){
                    x.end = i.end;
                    stack.push(x);
                }else if(x.end >= i.start && x.end >= i.end){
                    stack.push(x);
                }
                else{
                    stack.push(x);
                    stack.push(i);
                }    
            }
        }
        
        
        int c = 0;
        int[][] res = new int[stack.size()][2];
        for(Interval x : stack){
            res[c][0] = x.start;
            res[c++][1] = x.end;
        }
        return res;
    }
}
