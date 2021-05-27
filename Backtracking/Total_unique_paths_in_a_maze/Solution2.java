
/*

Solution to use :

1. Square matrix (N*N) , also extend for N*M
2. Backtracking .
3. Print paths (matrix form)


*/


import java.util.*;

class Solution2 {

private static final int N = 4;  // N*N matrix


// print solution

static void printMatrix(int solution[][]){
    for(int i=0 ; i<N ; i++){
        for(int j=0 ; j<N ; j++){
            System.out.print(solution[i][j]);
              System.out.println();
        }
   
    }
}


// check boundary conditions

static boolean isValidCell(int x,int y){
     return (x >= 0 || x < N ||  y >= 0 ||  y < N ); 
}


static boolean solMatrix(int maze[][]){

    int[][] solution = new int[N][N];

    if(getPaths(maze,0,0,solution) == false){
        System.out.println("No solution exists");
        return false;
    }

    printMatrix(solution);
    return true;

}



 static boolean getPaths(int maze[][] , int x , int y, int solution[][] ){

 	// if destination reached : last cell -> increment count

 	if(x == N-1 && y == N-1 ){
 		solution[x][y] = 1;
 		return true;
 	}
    
    // visit current cell and mark as visited

    solution[x][y] = 1;

    //as 1 means open cell and check boundary by isValidCell()

    if(isValidCell(x,y) == true && maze[x][y] == 1) {

    	// go down

    	if(getPaths(maze,x+1,y,solution)) 
            return true;

    	// go up

    	if(getPaths(maze,x-1,y,solution))
    		return true;

    	// go right

    	if(getPaths(maze,x,y+1,solution))
    		return true;

    	// go left

    	if(getPaths(maze,x,y-1,solution))
    		return true;


    }

    // backtrack from current cell and remove it from current path
    solution[x][y] = 0;
 
    return false;
 }
  


  public static void main(String[] args) {

  	int maze[][] =
        {
            { 1, 1, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 1 }
        };


        System.out.println(solMatrix(maze));
  
   
  }
}


/*

Output :

Total paths : 4
Should print 4 paths 


Complexity Analysis: 
----------------------------

Time Complexity: O(3^(n^2)). 
As there are N^2 cells from each cell there are 3 unvisited neighbouring cells. So the time complexity O(3^(N^2).
Auxiliary Space: O(3^(n^2)). 
As there can be atmost 3^(n^2) cells in the answer so the space complexity is O(3^(n^2)).



*/