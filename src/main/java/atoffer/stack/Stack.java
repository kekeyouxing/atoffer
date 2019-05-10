package atoffer.stack;

import atoffer.array.Vector;

public class Stack<E> extends Vector<E>{
	
	public Stack() {
	}
	
	public E push(E val) {
		
		addElement(val);
		return val;
		
	}
	
	public E pop() {
		
		E val = peek();
		int len = size();
		removeElementAt(len-1);
		return val;
		
	}
	
	public E peek() {
		
		int len = size();
		return get(len-1);
		
	}
	
	public boolean empty() {
		
		return size() == 0;
		
	}
}
