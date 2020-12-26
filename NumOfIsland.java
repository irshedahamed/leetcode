
/*
    Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    

*/

class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans+=1;
                    grid[i][j]='0';
                    recursiveRemove(i,j,grid);
                }
            }
        }
        return ans;
    }
    
    public void recursiveRemove(int i,int j,char[][] grid){
        if(i-1>=0 && grid[i-1][j]=='1'){
            grid[i-1][j]='0';
            recursiveRemove(i-1,j,grid);
        }
        if(i+1<grid.length && grid[i+1][j]=='1'){
            grid[i+1][j]='0';
            recursiveRemove(i+1,j,grid);
        }
        if(j-1>=0 && grid[i][j-1]=='1'){
            grid[i][j-1]='0';
            recursiveRemove(i,j-1,grid);
        }
        if(j+1<grid[0].length && grid[i][j+1]=='1'){
            grid[i][j+1]='0';
            recursiveRemove(i,j+1,grid);
        }
    }
}