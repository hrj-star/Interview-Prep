public class HeapClient{
	public static void main(String[] args) {
		Heap heap = new Heap();

		heap.add(10);
		heap.display();

		heap.add(20);
		heap.display();

		heap.add(30);
		heap.display();

		heap.add(40);
		heap.display();

		heap.add(5);
		heap.display();

		heap.add(3);
		heap.display();

		System.out.println(heap.remove());
		heap.display();

		System.out.println(heap.remove());
		heap.display();

		System.out.println(heap.remove());
		heap.display();

		System.out.println(heap.remove());
		heap.display();

	}
}


/*

[10]
[10, 20]
[10, 20, 30]
[10, 20, 30, 40]
[5, 10, 30, 40, 20]
[3, 10, 5, 40, 20, 30]
3
[5, 10, 30, 40, 20]
5
[10, 20, 30, 40]
10
[20, 40, 30]
20
[30, 40]


*/