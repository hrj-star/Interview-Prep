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


class Node{
    int data;
    Node left=null , right=null;
    Node(int data){
        this.data=data;
    }
}

class Main{

    public static boolean isLeafNode(Node node){
        return (node.left == null && node.right == null);
    }


    public static boolean printPath(Node root , int sum){

         
        // base cases

        if(sum == 0){
            return true;
        }

        if(root == null){
            return false;
        }

        boolean left = printPath(root.left , sum - root.data);
        boolean right = printPath(root.right , sum - root.data);

        if(left || right){
            System.out.print(root.data + " ");
        }

        return left || right;
    }

   
    public static int printMaxSum(Node node){
        if(node == null){
            return 0;
        }
        
        if(isLeafNode(node)){
            return node.data;
        }

        return node.data + Math.max(printMaxSum(node.left) , printMaxSum(node.right));


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

        int sum = printMaxSum(root);

        System.out.println("Maximum sum is :"+sum);

        System.out.print("Maximum sum path is : ");

        printPath(root , sum);
    }
        
}

/*

Maximum sum is :18
Maximum sum path is : 9 5 3 1



TC : O(n) : n - total nodes in binary tree

SC : O(n) :  extra space .



*/

