/*
Url : https://leetcode.com/problems/rotate-image/submissions/
*/

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }
    
    public void transpose(int[][] matrix){
        for(int i =0 ;i<matrix.length ;i++){
            for(int j = i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public void reverseRow(int[][] matrix){
        for(int i = 0;i<matrix.length;i++){
            int left = 0;
            int right = matrix.length -1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right]= temp;
                left++;
                right--;
            }
        }
    }
}