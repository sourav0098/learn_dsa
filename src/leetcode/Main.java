package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main {

	// Given a string s, find the first non-repeating character in it and return its
	// index. If it does not exist, return -1
	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.get(ch) == 1) {
				return i;
			}
		}
		return -1;

	}

	// Given a string s, find the first repeated character in it
	public static Character firstRepeatedChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		for (char ch : s.toCharArray()) {
			if(ch==' ') {
				continue;
			}
			
			// get the value for ch key, if not found then by default it is 0
			int count = map.getOrDefault(ch, 0);
			map.put(ch, count+1);
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.getOrDefault(ch,0) > 1) {
				return ch;
			}
		}
		return ' ';

	}

	public static void main(String[] args) {
		System.out.println(firstRepeatedChar("hello how are you?"));
	}

}
