class Stack{

	int[] arr;
	int size;
	int top ;

	Stack(int size){
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}

	public void push(int item) throws Exception{
		if(isFull()){
			throw new Exception("Stack full !");
		}
		else{ 
			top++;
			arr[top] = item;
			size++;
		}
	}

	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack Empty !");
		}
		else{
			int item = arr[top];
			top--;
			size--;
			return item;
		}
	}

	public boolean isFull(){
		return (size - 1== top);
	}
	public boolean isEmpty(){
		return (top == -1);
	}

	public int peek() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack Empty !");
		}
		return arr[top];
	}

	public int size(){
		return top + 1; // or this.size;
	}

	public void display(){
		for(int i=this.top;i>=0;i--){
			System.out.print(arr[i]+" ");
		}
	}
}

class Main{
	public static void main(String[] args) throws Exception{
		Stack s = new Stack(4);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);

		System.out.println("\nTop element : "+s.peek());
		System.out.println("Size : "+s.size());
		s.display();

		s.pop();
		s.pop();
		s.pop();



		System.out.println("Top element : "+s.peek());
		System.out.println("Size : "+s.size());

	}
}