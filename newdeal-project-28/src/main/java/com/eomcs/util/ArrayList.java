package com.eomcs.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class ArrayList<T> {
  final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size = 0;
  
  public ArrayList() {
    elementData  = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY) 
      elementData = new Object[initialCapacity];
    else
      elementData = new Object[DEFAULT_CAPACITY];
  }
  
  @SuppressWarnings("unchecked")
  public T[] toArray(T[] a) {
    if (a.length < size) {
      return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    }
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    return a;
  }
  
  public void add(T obj) {
    if (size >= elementData.length) {
      int oldCapacity = elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      elementData = Arrays.copyOf(elementData, newCapacity);
    }
    
    elementData[size++] = obj;
  }
  public T get(int index) {//번호, 수업명, 수업내용, 기간, 총수업시간, 일수업시간,
    if (index < 0 || index >= size) 
      return null;
    
    return (T) elementData[index];
  }
  public T set(int index, T obj) {
    if (index < 0 || index >= size) 
      return null;
    
    @SuppressWarnings("unchecked")
    T old = (T)elementData[index];
    elementData[index] = obj;
    return old;
  }
  public T remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    @SuppressWarnings("unchecked")
    T old = (T)elementData[index];
    
    int newSize = size - 1;
    System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
    elementData[size = newSize] = null;
    return old;
  }
  
}
