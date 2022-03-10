
 /* 


 Construct the following tree
                  1
                /   \
              2       3
             / \    / \
            4    5 6   7
  
 
Top View : 4 2  1  3 7 

5 , 6  below 1 so hidden by 1 , 


                  1 (0)  ----> level 0
                /   \
              2       3 ----> level 1
             / \     / \
            4    5 6    7 ----> level 2
        

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
    this.data = data;
    this.hd = hd;
  }
}

class Pair<U,V>{
    public final U first; // first field of a pair
    public final V second; // second field of a pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

      // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}

class Recursive{


    public static void topView(Node root, int hd , int level , TreeMap<Integer,Pair<Integer,Integer>> map){

        if(root == null){
            return;
        }
    
        // if the current level is less than the maximum level seen so far
        // for the same horizontal distance, or if the horizontal distance
        // is seen for the first time, update the map so as to have the top node view

        if(!map.containsKey(hd) || level < map.get(hd).second){ // if value does not exists for given hd key or value in map is greater than level , then insert in map
            map.put(hd , Pair.of(root.data , level));
        }

        topView(root.left , hd - 1 ,  level + 1 , map);
        topView(root.right , hd + 1 ,  level + 1 , map);

    }


  public static void printTop(Node root){

  TreeMap<Integer,Pair<Integer,Integer>> map = new TreeMap<>(); // insert in sorted manner by using natural order of keys , key : hd (horizontal distance) , value : pair of node.data and its level

  topView(root,0,0,map);

   for(Pair<Integer,Integer> e : map.values()){
            System.out.print(e.first + " ");
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


    printTop(root);

  }  
}


/*

Solution : 

4 2 1 3 7



TC : O(nlogn) : n - total nodes in binary tree.

SC : O(n) recursion space


*/