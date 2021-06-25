import java.util.Iterator;
import java.util.PriorityQueue;

class GFG {
	private static void kSort(int[] arr, int n, int k)	{
		PriorityQueue<Integer> minHeap= new PriorityQueue<>();
      	
      int windowStart = 0;
      for(int windowEnd = 0;windowEnd < n ; windowEnd++){
      	minHeap.add(arr[windowEnd]);
		
        if(windowEnd - windowStart > k)
          arr[windowStart++] = minHeap.poll();	
      }
      
      while(!minHeap.isEmpty())
        arr[windowStart++] = minHeap.poll();
	}

	// A utility function to print the array
	private static void printArray(int[] arr, int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver Code
	public static void main(String[] args)
	{
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array");
		printArray(arr, n);
	}
}