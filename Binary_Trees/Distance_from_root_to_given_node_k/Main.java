  /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            8   4   5   6
               /   / \   \
             10   7   9   5
        */

/*
Solution to use:

1. Works for unique node values 

*/

class Node{
    int data;
    Node left=null , right=null;
    Node(int data){
        this.data=data;
    }
}

class Main{

   
    public static int distance_from_root(Node node , int k){

        // base case
        if(node == null){
            return -1;
        }
        // initialize distance
        int distance = -1;

        // Check if node k is present at root or in left subtree or right subtree.
        
        if ((node.data == k) || (distance = distance_from_root(node.left,k)) >=0 || (distance = distance_from_root(node.right,k)) >=0)
            return distance+1;


        return distance;

    }

    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(5);

       

        System.out.println("Distance from root to given node k is : "+distance_from_root(root,10));

       
    }
        
}

/*

Distance from root to given node k is : 3



TC : O(n) : n - total nodes in binary tree

SC : O(1) 



To-do :
Iterative version
solve for duplicates.


*/

