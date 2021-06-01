class NumMatrix {

    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
       
        for(int i = 0;i<matrix.length;i++)
			sum[i][0] = matrix[i][0];
        
        for(int j = 0;j<matrix[0].length;j++)
			sum[0][j] = matrix[0][j];
		
      
		//rowSum
		for(int i = 0 ;i < matrix.length;i++){
			int j = 1;
			while(j < matrix[0].length){
				sum[i][j] = matrix[i][j] + sum[i][j-1];
                j++;
            }
		}
 
        
		//colSum
		for(int j = 0 ;j < matrix[0].length;j++){
			int i = 1;
			while(i < matrix.length){
				sum[i][j] += sum[i-1][j];
                i++;
            }
		}    
    }
 
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int oa;
		int ob;
		int oc;
		int od;
		if(row1==0 || col1==0)
			oa = 0;
		else{
			oa = sum[row1-1][col1-1];
		}
		
		if(row1 == 0 )
			ob = 0;
		else{
			ob = sum[row1-1][col2];	
		}
		
		if(col1 == 0)
			oc = 0;
		else{
			oc = sum[row2][col1-1];
		}
		
		od = sum[row2][col2];
		
		return od - ob - oc +oa;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */