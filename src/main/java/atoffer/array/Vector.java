package atoffer.array;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class Vector<E> extends AbstractList<E> implements List<E>{
	
	private Object[] elementData;
	
	private int elementCount;
	
	public Vector(int initialCapacity) {
		
		elementData = new Object[initialCapacity];
		
	}
	
	public Vector() {
		
		this(10);
		
	}
	
	public void addElement(E obj) {
		
		ensureCapacity(elementCount+1);
		elementData[elementCount++] = obj;
		
	}

	public void removeElement(E obj) {
		
		int i = indexOf(obj);
		if(i>0) {
			removeElementAt(i);
		}
		
	}
	
	public void removeElementAt(int i) {
		
		if(i<0 || i>=elementCount) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		
		int length = elementCount-i-1;
		System.arraycopy(elementData, i+1, elementData, i, length);
		elementData[--elementCount] = null;
		
	}

	public int indexOf(Object obj) {
		
		for(int i=0; i<elementCount; i++) {
			if(obj.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
		
	}

	private void ensureCapacity(int newCapacity) {
		
		if(newCapacity-elementData.length>0)
			elementData = Arrays.copyOf(elementData, newCapacity);
			
	}
	
	public boolean contains(Object obj) {
		
		return indexOf(obj)>=0;
		
	}
	
	public void clear() {
		
		for(int i=0; i<elementCount; i++) {
			elementData[i] = null;
		}
		elementCount = 0;
		
	}
	
	public int size() {
		
		return elementCount;
		
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		
		if(index<0 || index>=elementCount) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (E)elementData[index];
		
	}
	
}
