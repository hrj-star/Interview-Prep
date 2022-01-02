public class Main{
	public static void main(String[] args) {
		System.out.println(10+20+" Hello "+10+20); // 30 Hello 1020
		System.out.println(2+' '+5); // 2+' '+5 ==> INT is greater in size than char. So -> ' ' ascii of space is 32 , 2+32+5 = 39 
		System.out.println(2+" "+5); // 2 5
		System.out.println("Hello" + '\t' + "World"); // Hello	World
		System.out.println("Hello" + "\t" + "World"); // Hello	World
	}
}