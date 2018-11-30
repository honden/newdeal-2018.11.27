package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.domain.Lesson;

public class MemberList {
  static final int LENGTH = 10;
  private Member[] list;
  private int size = 0;

  public MemberList() {
    this.list = new Member[LENGTH];
  }

  public MemberList(int initialCapacity) {
    if(initialCapacity>LENGTH){
      this.list = new Member[initialCapacity];
    }else{
      this.list = new Member[LENGTH];
    }
  }
  public Member[] toArray() {
    return Arrays.copyOf(list, size);
  }
  public void add(Member member) {
    if(size >= list.length) {
      int oldLength = list.length;
      int newCapacity = oldLength + oldLength >> 1;
      list = Arrays.copyOf(list, newCapacity);
    }
    list[size] = member;
    size++;
  }
}
