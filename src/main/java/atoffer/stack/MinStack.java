package atoffer.stack;

public class MinStack {
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int val) {
		
		stack.push(val);
		if(minStack.empty() || val <= minStack.peek()) {
			minStack.push(val);
		}else {
			minStack.push(minStack.peek());
		}
		
	}
	
	public void pop() {
		
		stack.pop();
		minStack.pop();
		
	}
	
	public int top() {
		
		return stack.pop();
		
	}
	
	public int min() {
		
		return minStack.pop();
		
	}
	
}
