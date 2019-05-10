package atoffer.stack;

public class StackUtil<E> {

	Stack<Integer> stack = null;
	public StackUtil(Stack<Integer> stack) {
		
		this.stack = stack;
		
	}
	
	public boolean isPopOrder(int[] pushArr, int[] popArr) {
		
		int i=0, j=0, size = pushArr.length;
		
		while(i<size){
			
			stack.push(pushArr[i]);
			while(j<size && stack.peek()==popArr[j]) {
				stack.pop();
			}
			
		}
		return stack.empty();
		
	}
	
}
