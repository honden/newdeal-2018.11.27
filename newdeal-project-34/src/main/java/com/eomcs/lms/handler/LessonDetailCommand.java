package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonDetailCommand(Scanner keyboard, List<Lesson> list) {
    this.keyboard = keyboard;
    this.list = list;
  }

  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }

    Lesson lesson = list.get(index);

    System.out.printf("내용: %s\n", lesson.getContents());
//    System.out.printf("작성일: %s\n", lesson.getCreatedDate());
  }
  private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson b = list.get(i);
      if (b.getNo() == no)
        return i;
    }
    return -1;
  }
}
