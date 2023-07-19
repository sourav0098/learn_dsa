package my_hashmap;

public class Main {

	public static void main(String[] args) {
		MyHashMap map=new MyHashMap();
		map.put(1, "Sourav");
		map.put(2, "John");
		map.put(6, "Daniel");
		map.put(1, "SC");
		map.remove(1);
		System.out.println(map);
		System.out.println(map.get(6));

	}

}
