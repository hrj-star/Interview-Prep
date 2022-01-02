// change int / Integer to T for generic heap (of any data type)

import java.util.*;

public class GenericHeap<T extends Comparable<T>>{ // cant compare addresses directly so extends Comparable , set bounds meaning T is comparable
	ArrayList<T> minheap = new ArrayList<>();

	// insert new item
	public void add(T item){
		minheap.add(item); // add at last // eg : insert new element at 6th index(last index) out of total 7 size
		upheapify(minheap.size() - 1); // upheapify -- pass self index // eg 6th index passed
	}

	// upheapify after checking minheap condition
	private void upheapify(int child_index){ // child index same as self index as new element will be added there
		int parent_index = (child_index - 1)/2; // formula for parent index eg : child_index =  6 , then parent_index = 6-1/2 = 2
		if(isLarger(minheap.get(child_index) , minheap.get(parent_index)) > 0 ){ // when T datatype , cant compare addresses with < so isLarger()
			swap(parent_index,child_index);
			upheapify(parent_index); // recursive call to upheapify till root node above 
		}
	}

	// swap function to swap parent and child nodes
	public void	swap(int i  , int j){
		T ith = minheap.get(i);
		T jth = minheap.get(j);

		minheap.set(i,jth);
		minheap.set(j,ith);
	}

	// display minheap
	public void display(){
		System.out.println(minheap);
	}

	//size()
	public int size(){
		return this.minheap.size();
	}

	// isEmpty()
	public boolean isEmpty(){
		return this.size() == 0;
	}

	// remove()

	public T remove(){
		swap(0,this.minheap.size() - 1); // swap 1st and last to easily remove 1st element which is of higher priority in min heap
		T remove_element = this.minheap.remove(this.minheap.size() - 1); // get last index element
		downheapify(0); // remove root - pass root as parent index

		return remove_element; 

	}

	private void downheapify(int parent_index){
		int left_child_idx = 2 * parent_index + 1;
		int right_child_idx= 2 * parent_index + 2;

		int min_idx = parent_index;

		if(left_child_idx < this.minheap.size() && isLarger(minheap.get(left_child_idx) , minheap.get(min_idx)) > 0){
			min_idx = left_child_idx;
		}

		if(right_child_idx < this.minheap.size() && isLarger(minheap.get(right_child_idx) , minheap.get(min_idx)) > 0){
			min_idx = right_child_idx;
		}

		if(min_idx != parent_index){
			swap(min_idx,parent_index);
			downheapify(min_idx);
		}
	}


	// get element of highest priority 
	
	public T get(){ 
		return this.minheap.get(0);
	}

	// if T is having higher priority then return +ve value , else -ve value.
	public int isLarger(T t, T o) {
		return t.compareTo(o);
	}
}