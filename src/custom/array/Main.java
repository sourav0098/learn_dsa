package custom.array;

public class Main {
	public static void main(String args[]) {
		MyArray arr = new MyArray(10);
		arr.insert(4);
		arr.insert(5);
		arr.insert(8);
		arr.insert(-8);
		arr.insert(15);
		arr.insert(10);
		arr.insert(7);

		arr.insert(-2);

		arr.removeAt(1);
		System.out.println(arr);
		System.out.println(arr.max());
		System.out.println(arr.min());
		arr.reverse();
		System.out.println(arr);

	}
}
