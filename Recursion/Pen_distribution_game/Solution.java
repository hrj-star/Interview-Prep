/*

Solution To Use :
 
 1) Brute Force 
 
*/

import java.util.*;

class Solution{

 static void pen_distribution(int N,int p1,int p2,int move,int x,boolean quit1,boolean quit2){

  if(N == 0  || (quit1 && quit2)){
    System.out.println("Number of pens remaining in the box:"+N);
    System.out.println("Number of pens collected by P1 :"+p1);
    System.out.println("Number of pens collected by P2 :"+p2);
    return;
  }
  

  // if player 1 can play 

  if(move == 0 &&  quit1 == false){

    int p1move = (int)Math.pow(2,x);

    if(p1move <= N){
      p1 += p1move;
      N -= p1move;
    }
    else{
      quit1 = true;
    }

  }

  else if (move == 1 &&  quit2 == false){
    int p2move = (int)Math.pow(3,x);

    if(p2move <= N){
      p2 += p2move;
      N -= p2move;
    }
    else{
      quit2 = true;
    }

  }

  // increase X , X=0,1,2 ....

  x++;

  // switch between p1 and p2 

  move = ((move == 1) ? 0 : 1);

  pen_distribution(N,p1,p2,move,x,quit1,quit2);

  



  }
  



  public static void main(String[] args) {
    int N=22;
    int p1=0,p2=0;
    int move = 0;
    int x=0;
    boolean quit1=true,quit2=true;
   
   
    
    pen_distribution(N,p1,p2,move,x,quit1,quit2);

    

  }


}


/*

Output :
----------------------
Number of pens remaining in the box: 14
Number of pens collected by P1 : 5
Number of pens collected by P2 : 3



Complexity Analysis :
---------------------------
Time Complexity: O(Log(N))
Auxiliary Space: O(1)



*/