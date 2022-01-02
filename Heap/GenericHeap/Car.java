import java.util.*;
// as T extends Comparable<T> hence Car implements Comparable and compareTo()

public class Car implements Comparable<Car> {

	int speed;
	int price;
	String color;

	public Car(int speed, int price, String color) {

		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {
		return "S:" + this.speed + " P:" + this.price + " C:" + this.color;
	}

	@Override
	public int compareTo(Car other) { // in increasin order of speed
		return other.speed - this.speed;
	}

}