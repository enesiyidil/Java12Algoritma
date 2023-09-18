package dersler.ders016;

import java.util.Stack;

public class Stack_1 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		stack.push(2);
		stack.push(44);
		stack.push(7);
		stack.push(9);

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " - ");
		}

		stack.push(2);
		stack.push(144);
		stack.push(7);
		stack.push(9);
		stack.push(2);
		stack.push(144);
		stack.push(7);
		stack.push(150);

		int toplam = 0;
		while (!stack.isEmpty()) {
			if (stack.peek() < 100) {
				toplam += stack.pop();
			} else {
				stack2.add(stack.pop());
			}
		}
		System.out.println("Toplam: " + toplam);
		System.out.println("stack:  " + stack);
		System.out.println("stack2: " + stack2);
	}

}
