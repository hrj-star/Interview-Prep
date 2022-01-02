import java.util.*;
public class HeapGClient {

	public static void main(String[] args) {
		
		Car[] cars = new Car[5];
		cars[0] = new Car(1000, 400, "Red");
		cars[1] = new Car(2000, 200, "Yellow");
		cars[2] = new Car(500, 900, "Black");
		cars[3] = new Car(300, 30, "Grey");
		cars[4] = new Car(700, 60, "White");
		
		GenericHeap<Car> heapg = new GenericHeap<>() ;
		heapg.add(cars[0]);
		heapg.add(cars[1]);
		heapg.add(cars[2]);
		heapg.add(cars[3]);
		heapg.add(cars[4]);
		
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());

	}

}

/*

S:300 P:30 C:Grey
S:500 P:900 C:Black
S:700 P:60 C:White
S:1000 P:400 C:Red
S:2000 P:200 C:Yellow

*/