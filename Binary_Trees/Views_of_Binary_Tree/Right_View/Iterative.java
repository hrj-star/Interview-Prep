

 /* 

 Construct the following tree
                  1
                /   \
              2       3
             / \     / \
            4   5   6   7
  
 
Right View : 1 3 7

2  hidden by  3.
4,5,6 hidden by 7.


Algo :

                  1 (0)  ----> level 0
                /   \
              2       3 ----> level 1
             / \     / \
            4   5   6   7 ----> level 2
        


Right View : 1, 3, 7

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

class Iterative{


    public static void rightView(Node root){

        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>(); // insert in order
       

        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            int i = 0;

            while(i++ < size){

                Node curr = queue.poll();

                if(i == size){ // print the node which is last node at current level , thats it
                    System.out.print(curr.data + " ");
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null){
                    queue.add(curr.right);
                }

            }
        }
    }


  public static void main(String[] args){

    Node root = new Node(1);
    root.left = new Node(2);
    root.right= new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);


    rightView(root);

  }  
}


/*

Solution : 1 3 7





TC : O(n) : n - total nodes in binary tree.

SC : O(n) - queue - n - total nodes in binary tree.


*/