package custom.array;

public class MyArray {
	private int[] items;

	// maintain the index of array
	private int currentIndex = 0;

	public MyArray(int initialSize) {
		this.items = new int[initialSize];
	}

	public void insert(int num) {

		// dynamically increase size of array
		if (currentIndex == items.length) {
			int[] temp = new int[items.length + 10];
			for (int i = 0; i < currentIndex; i++) {
				temp[i] = items[i];
			}
			items = temp;
		}

		items[currentIndex] = num;
		currentIndex++;
	}

	public int indexOf(int num) {
		// we are make this loop only till the (current index-1) because that is the
		// value
		// until which the array is filled otherwise if we check whole array that wont
		// be much efficient
		for (int i = 0; i < this.currentIndex; i++) {
			if (this.items[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public void removeAt(int index) {
		// if index is greater than currentIndex that means no element is at that index
		if (index >= this.currentIndex) {
			throw new IllegalArgumentException();
		}

		// Start from the index from which you want to remove the element until
		// currentIndex - 2
		// If we keep it until (currentIndex-1) then it will try to move value from
		// currentIndex (this.items[i + 1];) which is 0 to right which we dont want and
		// there can also be case that arr is full so it will give error index out of
		// bounds
		for (int i = index; i <= this.currentIndex - 2; i++) {
			// move elements from right to left
			this.items[i] = this.items[i + 1];
		}

		// decrease the currentIndex by 1 as one element is removed
		currentIndex--;

		// since once element is removed so put last element to 0
		this.items[currentIndex] = 0;
	}

	public int max() {
		int result = this.items[0];

		// start from 1 since we already stored element at 0 in result
		for (int i = 1; i < currentIndex; i++) {
			if (items[i] > result) {
				result = items[i];
			}
		}
		return result;
	}

	public int min() {
		int result = this.items[0];

		// start from 1 since we already stored element at 0 in result
		for (int i = 1; i < currentIndex; i++) {
			if (items[i] < result) {
				result = items[i];
			}
		}
		return result;
	}

	public void reverse() {
		int i = 0;
		int j = this.currentIndex - 1;

		while (i < j) {
			int temp = items[i];
			items[i] = items[j];
			items[j] = temp;

			i++;
			j--;
		}
	}

	public String toString() {
		String result = "[";
		for (int i = 0; i < this.currentIndex; i++) {
			result += " " + items[i];
		}
		result += "]";
		return result;
	}

}
