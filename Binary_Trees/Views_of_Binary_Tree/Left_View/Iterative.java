

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
        


Left View : 1, 2, 4

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


    public static void leftView(Node root){

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

                if(i == 1){ // print the node which is first node at current level , thats it
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


    leftView(root);

  }  
}


/*

Solution : 1 2 4





TC : O(n) : n - total nodes in binary tree.

SC : O(n) - queue - n - total nodes in binary tree.


*/