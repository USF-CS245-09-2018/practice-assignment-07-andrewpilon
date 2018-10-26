// Andrew Pilon
import java.util.*;

public class ArrayList implements List {

	Object[] list = new Object[10]; // initiate list of size 10
	int size = 0;

	public void add(Object obj) {
		if(size == list.length) {
			growArray();
		}
		list[size++] = obj; // add object to end of list
	}

	public void add(int pos, Object obj) {
		if(pos>size || pos<0) {
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		if(size == list.length) {
			growArray();
		}
		for(int i=size; i>pos; i--) { // slide objects right of pos to the right to make room for obj (backwards so no overwriting)
        	list[i] = list[i-1];
        }
        list[pos] = obj; // insert obj
        size++;
	}

	public Object get(int pos) {
		if(pos>size || pos<0) {
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		return list[pos];
	}

	public Object remove(int pos) {
		if(pos>list.length || pos<0) {
			throw new ArrayIndexOutOfBoundsException(pos);
		}
		if(list[pos]==null) {
			throw new NullPointerException();
		}
		Object removed = list[pos]; // get object to remove
		for(int i=pos+1;i<size;i++) { // slide down all succeeding objects
			list[i-1] = list[i];
		}
		size--;
		return removed; 
	}

	public int size() {
		return size;
	}

	public void growArray() {
		list = Arrays.copyOf(list, list.length*2); // double size if we exceed object limit
	}

}