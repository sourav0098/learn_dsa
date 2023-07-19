import java.util.HashMap;
import java.util.Map;

class User {
	String name;
	int rollno;

	public User(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}

	public String toString() {
		return "Name: "+this.name + ", Roll No: " + this.rollno;
	}
}

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		map.put(1, "Sourav"); // O(1)
		map.put(2, "John");
		map.put(3, "Daniel");

		map.put(3, "xyz");

		// check contains key
		System.out.println(map.containsKey(2));

		map.remove(2);

		System.out.println(map);
		System.out.println(map.get(2)); // O(1) ==> map.get(2)

		// we can also class as a key-value pair
		Map<Integer, User> map2 = new HashMap<>();
		User user = new User("Sourav", 7);
		map2.put(1, user);
		System.out.println(map2);
	}
}