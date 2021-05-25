/*
	Url : https://binarysearch.com/problems/Rotate-by-90-Degrees-Counter-Clockwise
*/

import java.util.*;

class Solution {

    public int[][] transpose(int[][] matrix){
        int length = matrix.length;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
               int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }   
        }
        return matrix;
    }

    public int[][] reverse(int[][] matrix){
        int n = matrix.length;
        for(int j=0;j<n;j++){
            for(int i = 0;i<n/2;i++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp; 
            }
        }
        return matrix;
    }

    public int[][] solve(int[][] matrix) {
        matrix = transpose(matrix);
        matrix = reverse(matrix);
        return matrix;
    }
}