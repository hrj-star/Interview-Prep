

 /* 


 Construct the following tree
                  1
                /   \
              2       3
             / \     / \
            4   5   6   7
  
 
Top View : 4 2 6  3 7 

5 , 1  hidden by 6.
Algo :

                  1 (0)  ----> level 0
                /   \
              2       3 ----> level 1
             / \     / \
            4   5   6   7 ----> level 2
        

hd of nodes : root - 0 , left child - hd - 1 , right child - hd + 1 

queue remove = 1

0 - 1 (enter in map)
------------------------------

queue = 2 ,3 ->  remove 2 

-1 - 2 (enter in map)
0 - 1
-----------------------------

queue = 3 , 4 , 5  -> remove 3 

-1 - 2 
0 - 1
1- 3 (enter in map)

-----------------------------

queue =  4 , 5 , 6 , 7  -> remove 4

-2 - 4 (enter in map)
-1 - 2 
0 - 1
1- 3 

-----------------------------

queue =   5 , 6 , 7  -> remove 5

0 - 5 - dist already present in map , put in map to override

-2 - 4 
-1 - 2 
0 - 5
1- 3 

-----------------------------

queue =    6 , 7  -> remove 6

0 - 6 - dist already present in map , put in map to override

-2 - 4 
-1 - 2 
0 - 6
1- 3 


-----------------------------

queue =    7  -> remove 7

-2 - 4 
-1 - 2 
0 - 6
1- 3 
2 - 7 (enter in map)


Bottom View : 4 , 2 , 6 , 3 , 7
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


    public static void bottomView(Node root){

        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>(); // insert in order
        TreeMap<Integer,Integer> map = new TreeMap<>(); // insert in sorted manner by using natural order of keys , key : hd (horizontal distance) , value : node.data

        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll(); // remove head

            int tempData = temp.data;
            int tempHd = temp.hd;

            // if value exists for given hd key , then insert in map to override top view node with new bottom node value
            map.put(tempHd , tempData);
        

           if(temp.left != null){
                temp.left.hd = tempHd - 1;
                queue.add(temp.left);
            }

            if(temp.right != null){
                temp.right.hd = tempHd + 1;
                queue.add(temp.right);
            }
        }

        System.out.println(map.values());

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.print(e.getValue() + " ");
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


    bottomView(root);

  }  
}


/*

Solution : 

[4, 2, 6, 3, 7]
4 2 6 3 7



TC : O(n) : n - total nodes in binary tree.

SC : O(n) - queue + O(n) - map = O(n) : n - total nodes in binary tree.


*/