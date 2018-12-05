package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import Dao.LessonDao;
@Component("/lesson/add")
public class LessonAddCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonAddCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  public void execute() {
    try {
      Lesson lesson = new Lesson();

      System.out.print("제목(%s)? ");
      lesson.setTitle(keyboard.nextLine());
      System.out.print("내용(%s)? ");
      lesson.setContents(keyboard.nextLine());
      //        System.out.print("시작날짜(%s)? ");
      //        lesson.setStartDate(keyboard.nextLine());
      //        System.out.print("종료날짜(%s)? ");
      //        lesson.setEndDate(keyboard.nextLine());
      System.out.print("총시간(%s)? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      lessonDao.insert(lesson);
      System.out.printf("입력했습니다!");
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
