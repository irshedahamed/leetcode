/*
We can store the first half of numbers (i.e., smallNumList) in a Max Heap. We should use a Max Heap as we are interested in knowing the largest number in the first half.

We can store the second half of numbers (i.e., largeNumList) in a Min Heap, as we are interested in knowing the smallest number in the second half.

Inserting a number in a heap will take O(logN)O(logN), which is better than the brute force approach.

At any time, the median of the current list of numbers can be calculated from the top element of the two heaps.
*/


class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> a - b);
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        //Insert into Max Heap if Num is smaller 
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
         else
            minHeap.add(num);
        
        //If Number of Elements is Odd, place it in MaxHEap.. Else balance the heaps to have same values.
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        } else if(minHeap.size() < maxHeap.size() - 1 ){
            minHeap.add(maxHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+ minHeap.peek())/2.0;
        }
        else
            return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */