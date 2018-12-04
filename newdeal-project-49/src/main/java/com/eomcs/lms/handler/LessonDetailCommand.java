package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import Dao.LessonDao;

public class LessonDetailCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonDetailCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      Lesson lesson = lessonDao.findByNo(no);

      if(lesson != null) {
        System.out.printf("번호: %d\n", lesson.getNo());
        System.out.printf("주제: %s\n", lesson.getTitle());
        System.out.printf("내용: %s\n", lesson.getContents());
        System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
        System.out.printf("총시간: %d\n", lesson.getTotalHours());
      }else {
        System.out.printf("해당 번호의 게시물이 없습니다!");
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
