package com.eomcs.util;

public class QueueIterator<E> implements Interator<E> {
  Queue<E> queue;
  int size;
  int count;  
  public QueueIterator(Queue<E> queue) {
    this.queue = queue;
    this.size = queue.size();
  }
  public boolean hasNext() {
    return this.count < queue.size();
  }
  public E next() {
    this.count++;

    return queue.poll();
  }
}
