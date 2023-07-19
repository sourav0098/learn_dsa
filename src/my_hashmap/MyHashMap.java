package my_hashmap;

import java.util.Arrays;
import java.util.LinkedList;

// USED CHAINING TO AVOID HASH COLLISION

class Entry {
	public int key;
	public String value;

	public Entry(int key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return key + "=" + value;
	}
}

public class MyHashMap {
	// Array of Linked List of Type Entry
	LinkedList<Entry>[] list;

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		this.list = new LinkedList[5];
	}

	// Hash Function
	private int hashKey(int key) {
		return key % list.length;
	}

	public boolean put(int key, String value) {
		int index = hashKey(key);

		if (list[index] == null) {
			list[index] = new LinkedList<>();
		}
		var bucket = list[index];

		// if value for same key already exists, override it
		for (var entry : bucket) {
			if (entry.key == key) {
				entry.value = value;
				return true;
			}
		}

		bucket.addLast(new Entry(key, value));
		return true;
	}

	public String get(int key) {
		int index = hashKey(key);
		if (list[index] == null) {
			throw new IllegalArgumentException();
		}
		var bucket = list[index];
		for (var entry : bucket) {
			if (entry.key == key) {
				return entry.value;
			}
		}
		throw new IllegalArgumentException();
	}

	public String remove(int key) {
		int index = hashKey(key);
		if (list[index] == null) {
			throw new IllegalArgumentException();
		}

		var bucket = list[index];
		for (var entry : bucket) {
			if (entry.key == key) {
				bucket.remove(entry);
				return entry.value;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public String toString() {
		return " [list=" + Arrays.toString(list) + "]";
	}
}
