package com.eomcs.util;

public class StackIterator<E> implements Interator<E> {
  Stack<E> stack;
  int size;
  int count;  
  public StackIterator(Stack<E> stack) {
    this.stack = stack;
    this.size = stack.size();
  }
  public boolean hasNext() {
    return this.count < stack.size();
  }
  public E next() {
    this.count++;

    return stack.pop();
  }
}
