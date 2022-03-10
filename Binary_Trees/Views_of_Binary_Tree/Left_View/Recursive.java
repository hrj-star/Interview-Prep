
 /* 


 Construct the following tree
                  1
                /   \
              2       3
             / \     / \
            4   5   6   7
  
 
Left View : 1 2 4

3  hidden by  2.
5,6,7 hidden by 4.


Algo :

                  1 (0)  ----> level 0
                /   \
              2       3 ----> level 1
             / \     / \
            4   5   6   7 ----> level 2
        
        

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map;


class Node{

  int data;
  int hd;
  Node left = null, right = null;

  Node(int data){
    this.data=data;
  }

   Node(int data , int hd){
    this.data=data;
    this.hd = hd;
  }
}


class Recursive{

    static int max = -1;
    public static void leftView(Node root, int level){

        if(root == null){
            return;
        }

        // if current level > max , then print current node and max = level

        if(level > max){
            System.out.print(root.data + " ");
            max = level;
        }
    

        leftView(root.left , level + 1); // first left - subtree
        leftView(root.right , level + 1); // then right - subtree

    }


  public static void main(String[] args){

    Node root = new Node(1);
    root.left = new Node(2);
    root.right= new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);


    leftView(root,0);

  }  
}


/*

Solution : 

1 2 4



TC : O(n) : n - total nodes in binary tree.

SC : O(n) or O(h) recursion space


*/