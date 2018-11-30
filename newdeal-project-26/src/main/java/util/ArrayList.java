package util;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class ArrayList<E> {
  final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;
  
  public ArrayList() {
    list  = new Board[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY) 
      list = new Board[initialCapacity];
    else
      list = new Board[DEFAULT_CAPACITY];
  }
  
  public E[] toArray(E[] a) {
    if(a.length < size) {
      return (E[])Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if ( a.length>size)
      a[size]=null;
    
    return a;
  }
  
  public void add(E item) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    
    list[size++] = item;
  }
  public int size() {
    return this.size;
  }
}
