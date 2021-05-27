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

   
    public static void nodes_at_dist_k(Node node , int k){

        // base case
        if(node == null){
            return;
        }
        
        // print nodes at k distance
        if(k==0){
            System.out.print(node.data+" ");
        }
        else{
            nodes_at_dist_k(node.left , k-1);
            nodes_at_dist_k(node.right , k-1);
        }

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

        int k = 3;

       

        nodes_at_dist_k(root,k);

       
    }
        
}

/*

Distance from root to given node k is : 3



TC : O(n) : n - total nodes in binary tree



To-do :
Iterative version


*/

