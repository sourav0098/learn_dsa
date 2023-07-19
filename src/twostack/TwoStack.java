package twostack;

// Design a data structure, which represents two stacks using only one array common for both stacks
public class TwoStack {
	private int[] items;
	private int top1;
	private int top2;
	private int size;

	public TwoStack(int size) {
		this.items = new int[size];
		this.size = size;
		this.top1 = 0;
		this.top2 = size - 1;
	}

	public void push1(int num) {
		if (top1 <= top2) {
			this.items[top1] = num;
			this.top1++;
		}
	}

	public void push2(int num) {
		if (top1 <= top2) {
			this.items[top2] = num;
			this.top2--;
		}
	}

	public int pop1() {
		if (top1 == 0) {
			return -1;
		}
		this.top1--;
		return this.items[top1];
	}

	public int pop2() {
		if (top2 == size - 1) {
			return -1;
		}
		this.top2++;
		return this.items[top2];
	}

}
