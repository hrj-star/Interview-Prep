

 /* 

Level order traversal of a tree is breadth first traversal for the tree. 

 Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
 */


import java.util.LinkedList;
import java.util.Queue;

class Node{
  int data;
  Node left=null , right=null;
  Node(int data){
    this.data=data;
  }
}

class Iterative{


    public static void levelOrder(Node root){

        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>(); // insert in order

        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll(); // remove head

            System.out.print(temp.data + " "); // print it

           if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
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
    root.right.left.left = new Node(8);
    root.right.right.right = new Node(9);

    levelOrder(root);

  }  
}


/*

Solution : 1 2 3 4 5 6 7 8 9



TC : O(n) : n - total nodes in binary tree.

SC : O(n) : n - total nodes in binary tree.


*/