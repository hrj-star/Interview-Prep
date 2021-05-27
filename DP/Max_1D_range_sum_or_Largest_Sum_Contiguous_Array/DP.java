
class DP{

	static void max_range_sum(int arr[]){

	int n= arr.length;
    int max_so_far = Integer.MIN_VALUE, max_ending_here = 0 , start=0,s=0,end=0	;

    for(int i=0 ; i<n ; i++){
    	max_ending_here+=arr[i];
    	if(max_ending_here > max_so_far){
    		max_so_far = max_ending_here;
    		start = s;
    		end = i;
    		}
    	if(max_ending_here < 0){
    		max_ending_here = 0;
    		s = i+1;
    		}
    	}	

     	System.out.println("Max 1D Range Sum :"+ max_so_far);
     	System.out.println("Start index :"+ start);
     	System.out.println("End index :"+ end);


     }
	
	 public static void main(String[] args) {

	 	int[] arr = {-2, 1,-3, 4, -1, 2, 1, -5, 4};
	 	max_range_sum(arr);
	 }
}

/*

Solution :

Max 1D Range Sum :6
Start index :3
End index :6


TC : O(N)
SC : O(1)
*/