
/*

Solution to use :

1. Square matrix (N*N) , also extend for N*M
2. Backtracking , also done by DP.


*/


import java.util.*;
class Solution {// check out-of-boundary condition

private static final int N = 4;  // N*N matrix


static boolean isValidCell(int x,int y){
	if(x < 0 || y < 0 || x >= N || y >= N){
		return false;
	}

	return true;
}

 static int countPaths(int maze[][] , int x , int y, boolean visited[][] ,int count){

 	// if destination reached : last cell -> increment count

 	if(x == N-1 && y == N-1 ){
 		count++;
 		return count;
 	}
    
    // visit current cell and mark as visited

    visited[x][y] = true;

    //as 1 means open cell and check boundary by isValidCell()

    if(isValidCell(x,y) && maze[x][y] == 1) {

    	// go down

    	if(x+1 < N && !visited[x+1][y])
    		count = countPaths(maze , x+1 , y ,visited , count);

    	// go up

    	if(x-1 >=0  && !visited[x-1][y])
    		count = countPaths(maze , x-1 , y ,visited , count);

    	// go right

    	if(y+1 < N && !visited[x][y+1])
    		count = countPaths(maze , x , y+1 ,visited , count);

    	// go left

    	if(y-1 >=0 && !visited[x][y-1])
    		count = countPaths(maze , x , y-1 ,visited , count);
  
    }

    // backtrack from current cell and remove it from current path
    visited[x][y] = false;
 
    return count;
 }
  


  public static void main(String[] args) {

  	int maze[][] =
        {
            { 1, 1, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 1 }
        };

        int count =0;
        boolean[][] visited = new boolean[N][N];
          
        // start from (0,0)
        count = countPaths(maze,0,0,visited,count);

        System.out.println("Total paths : "+ count);
  
   
  }
}


/*

Output :

Total paths : 4


Complexity Analysis: 
----------------------------

Time Complexity: O(3^(n^2)). 
As there are N^2 cells from each cell there are 3 unvisited neighbouring cells. So the time complexity O(3^(N^2).
Auxiliary Space: O(3^(n^2)). 
As there can be atmost 3^(n^2) cells in the answer so the space complexity is O(3^(n^2)).



*/