public class Solution {
    int[][] visited;
    int[][] result;

    public void dfs(int[][] arr, int num, int[] pos, List<Integer> path) {
        int row = pos[0];
        int col = pos[1];
        if (row < 0 || col < 0)
            return;
        if (row >= arr.length || col >= arr[0].length)
            return;
        if (arr[row][col] > num || visited[row][col] == 1)
            return;

        visited[pos[0]][pos[1]] = 1;
        path.add(arr[row][col]);

        if (row == arr.length - 1 && col == arr[0].length - 1) {
            result = Arrays.copyOf(path,path.length);
            return;
        }

        int currentNum = arr[row][col];

        dfs(arr, currentNum, new int[]{row - 1, col}, path);
        dfs(arr, currentNum, new int[]{row + 1, col}, path);
        dfs(arr, currentNum, new int[]{row, col - 1}, path);
        dfs(arr, currentNum, new int[]{row, col + 1}, path);
        path.remove(path.size() - 1);
    }


    public List<Integer> getPath(int[][] arr) {
        visited = new int[arr.length][arr[0].length];
        List<Integer> path = new ArrayList<>();
        dfs(arr, arr[0][0], new int[]{0, 0}, path);
        return result;
    }
}